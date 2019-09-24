package com.park.web;

import com.park.biz.CarBiz;
import com.park.entity.TblCar;
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
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/afile")
public class CarOutAction {
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
    @RequestMapping(value = "/upImg.action")
    public @ResponseBody
    Object upImg(@RequestParam(value = "file", required = false) MultipartFile mfile, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        if (!upFile.upfile(mfile, request)) {
            System.out.println("文件上传失败");
            map.put("code",1);
            return map;
        }
        //图片识别
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        String name = mfile.getOriginalFilename();
        String img = path + "/" + name;
        LicensePlateOCRResponse ocrResponse = distinguish.distinguish(img);
        //根据车牌查找信息
        TblCar car = carBiz.selCar(ocrResponse.getNumber());
        map.put("code",0);
        return map;
    }
}