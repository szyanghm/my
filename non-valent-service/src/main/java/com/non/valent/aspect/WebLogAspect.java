package com.non.valent.aspect;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.non.valent.exception.Serializer;
import com.non.valent.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author dragonlai
 * @date 2019/7/10
 * @time 14:03
 * @discription
 **/
@Aspect
@Component
@Slf4j
public class WebLogAspect {

    ThreadLocal<Long> startTime = new ThreadLocal<>();
    Map params = Maps.newLinkedHashMap();


    /**
     * 以 controller 包下定义的所有请求为切入点
     */
    @Pointcut("execution(public * com.non.valent.controller..*.*(..))")
    public void webLog() {
    }

    /**
     * 在切点之前织入
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 开始打印请求日志
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        params.put("【url】", request.getRequestURL()); // 获取请求的url
        params.put("【method】", request.getMethod()); // 获取请求的方式
        params.put("【ip】", HttpUtils.getIpAddr(request)); // 获取请求的ip地址
        params.put("【className】", joinPoint.getSignature().getDeclaringTypeName()); // 获取类名
        params.put("【classMethod】", joinPoint.getSignature().getName()); // 获取类方法
        params.put("【request args】", Serializer.serialize(joinPoint.getArgs())); // 请求参数
    }

    /**
     * 在切点之后织入
     *
     * @throws Throwable
     */
    @After("webLog()")
    public void doAfter() throws Throwable {
        // 输出格式化后的json字符串
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        log.info(gson.toJson(params));
        //清空每次内容
        params.clear();
        // 每个请求之间空一行
        log.info("");
    }

    /**
     * 环绕
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = proceedingJoinPoint.proceed();
        params.put("【response args】", result); // 响应回包参数
        params.put("【spend time】", (System.currentTimeMillis() - startTime.get()) + "ms"); // 响应回包参数
        return result;
    }

}

