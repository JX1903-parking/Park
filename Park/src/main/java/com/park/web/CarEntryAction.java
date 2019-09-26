package com.park.web;

import com.park.aoplog.Log;
import com.park.biz.CarBiz;
import com.park.entity.TblCar;
import com.park.entity.TblLocation;
import com.park.entity.TblRecord;
import com.park.tools.Distinguish;
import com.park.tools.UpFile;
import com.tencentcloudapi.ocr.v20181119.models.LicensePlateOCRResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/file")
public class CarEntryAction {
    @Resource
    private UpFile upFile;
    @Resource
    private Distinguish distinguish;
    @Resource
    private CarBiz carBiz;

    /**
     * 文件上传
     *
     * @return {Result}
     */
    @Log(operationType = "文件上传", operationName = "上传入场车辆的车牌号图片", module = "系统管理")
    @RequestMapping(value = "/upfile.action")
    public @ResponseBody
    Object upfile(@RequestParam(value = "file", required = false) MultipartFile mfile, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        if (upFile.upfile(mfile, request)) {
            System.out.println("文件上传成功");
        }
        map.put("code", 0);
        return map;
    }

    //图片识别
    @Log(operationType = "图片识别", operationName = "将获取的车牌号图片转为文字，并添加入场时间和设置车辆停车位置", module = "系统管理")
    @RequestMapping(value = "/upImg.action")
    public @ResponseBody
    Object upImg(@RequestParam(value = "file", required = false) MultipartFile mfile, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        if (!upFile.upfile(mfile, request)) {
            map.put("code", 1);
            return map;
        }
        //图片识别
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        String name = mfile.getOriginalFilename();
        String img = path + "/" + name;
        LicensePlateOCRResponse ocrResponse = distinguish.distinguish(img);
        System.out.println(ocrResponse.getNumber());
        //根据车牌查找信息
        TblCar car = carBiz.selCar(ocrResponse.getNumber());
        //按顺序给车位
        TblLocation location = null;
        int b = 0;
        while (null == location) {
            b++;
            location = carBiz.selLocation(b);
        }
        if (null == car) {
            car = new TblCar();
            car.setCarid(ocrResponse.getNumber());
            car.setCarimage(name);
            car.setLocationid(b);
            //增加临时车
            carBiz.addCar(car);
        } else {
            Map<String, Object> m = new HashMap<>();
            m.put("carid", car.getCarid());
            m.put("locationid", b);
            carBiz.modCar(m);
        }
        //增加停车流水
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String dateStr = dateFormat.format(now);
        TblRecord record = new TblRecord();
        record.setCarid(car.getCarid());
        record.setIntime(dateStr);
        record.setLocationid(b);
        carBiz.addRecord(record);

        int current = carBiz.getLocation();
        int total = carBiz.getTotal();
        //修改车位状态
        carBiz.modLocation(b);
        map.put("code", 0);
        map.put("mag", "闸门开启");
        //车辆信息
        map.put("data", car);
        //当前可用车位
        map.put("current", current);
        //总车位
        map.put("total", total);
        return map;
    }
}
