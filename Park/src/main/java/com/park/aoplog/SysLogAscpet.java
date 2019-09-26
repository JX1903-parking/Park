package com.park.aoplog;


import com.park.biz.LogBiz;
import com.park.entity.TblBackUser;
import com.park.entity.TblLog;
import com.park.tools.IpUtil;
import com.tencentcloudapi.live.v20180801.models.LogInfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: 林深时见鹿
 * @Date: 2019/9/10 10:35
 * @Description:日志切面
 */


@Aspect
@Component
public class SysLogAscpet {
    @Resource
    private LogBiz logBiz;

    @Pointcut("execution(* com.park.web..*.*(..))  ")
    public void logPoint() {
    }


    @After("logPoint()")
    public void after(JoinPoint joinPoint) throws ClassNotFoundException, NoSuchMethodException, UnknownHostException {
        System.out.println("日志--------------");
        //方法通知前获取时间,为什么要记录这个时间呢？当然是用来计算模块执行时间的
        long start = System.currentTimeMillis();
        //获取系统ip,这里用的是我自己的工具类,可自行网上查询获取ip方法
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = IpUtil.getIpAddr(request);
        TblLog tblLog = new TblLog();
        TblLog g=getMethodDesc(joinPoint);

        //获取操作用户
        String uname = getUSerMsg(request);

        //获取系统时间
        String time = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date());

        //数据存储到实体类中
        tblLog.setUname(uname);
        tblLog.setIncident(g.getIncident());
        tblLog.setDescription(g.getDescription());
        tblLog.setModule(g.getModule());
        tblLog.setRsponseDate(String.valueOf(getMethodDesc(joinPoint).getEndtime() - start));
        tblLog.setActtime(time);
        tblLog.setIp(ip);

        if (g.getDescription() != null) {
            int num = logBiz.addLog(tblLog);
            if (num > 0) {
                System.out.println("成功");
            } else {
                System.out.println("失败");
            }
        }
    }


    //配置后置返回通知,使用在方法aspect()上注册的切入点
    @AfterReturning("logPoint()")
    public void afterReturn(JoinPoint joinPoint) {
        System.out.println("=====执行controller后置返回通知=====");
    }

    @AfterThrowing(pointcut = "logPoint()", throwing = "e")
    public void throwing(JoinPoint joinPoint, Throwable e) {
        System.out.println("异常处理======");
        System.out.println(e.getClass().getName());

    }


    public static TblLog getMethodDesc(JoinPoint joinPoint) throws ClassNotFoundException, NoSuchMethodException {

        String targetName = joinPoint.getTarget().getClass().getName();

        String methodName = joinPoint.getSignature().getName();

        Object[] arguments = joinPoint.getArgs();

        Class targetClass = Class.forName(targetName);

        Method[] methods = targetClass.getMethods();

        Signature signature = joinPoint.getSignature();
        Method targetMethod = ((MethodSignature) signature).getMethod();
        Method realMethod = joinPoint.getTarget().getClass().getDeclaredMethod(signature.getName(), targetMethod.getParameterTypes());

        String operationType = "";
        String operationName = "";
        String module = "";
        long end = 0;

        for (Method method : methods) {

            if (method.getName().equals(methodName)) {

                Class[] clazzs = method.getParameterTypes();

                if (clazzs.length == arguments.length) {
                    // 操作说明
                    if (realMethod.getAnnotation(Log.class) != null) {
                        operationType = realMethod.getAnnotation(Log.class).operationType();
                        operationName = realMethod.getAnnotation(Log.class).operationName();
                        module = realMethod.getAnnotation(Log.class).module();
                        end = System.currentTimeMillis();
                    }
                    break;

                }

            }

        }
        TblLog g = new TblLog();
        g.setDescription(operationName);
        g.setIncident(operationType);
        g.setModule(module);
        g.setEndtime(end);
        return g;

    }

    /**
     * 得到用户信息
     *
     * @return
     */

    public static String getUSerMsg(HttpServletRequest request) {
        String uname = "";

        TblBackUser user = (TblBackUser) request.getSession().getAttribute("backUser");
        if (null != user) {
            uname = user.getUname();
        } else {
            uname = "系统";
        }
        return uname;

    }


}
