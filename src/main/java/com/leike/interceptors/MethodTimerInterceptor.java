package com.leike.interceptors;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @description:
 * @author: leike
 * @date: 2019-07-22 18:52
 */

/**
 * 方法耗时统计拦截器
 */
public class MethodTimerInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = Logger.getLogger(MethodTimerInterceptor.class);


    //前置功能 , 开始 - 结束 , 两个点减法得到耗时
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1 定义开始时间
        long start = System.currentTimeMillis();
        //2 将其存到请求域当中
        request.setAttribute("start",start);
        // 返回true , 才会找到下一个拦截器 , 如果没有下一个拦截器 , 则去Controller
        LOGGER.info(request.getRequestURI()+",请求到达");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 1取出start
        long start = (long) request.getAttribute("start");
        // 2得到end
        long end = System.currentTimeMillis();
        // 3记录一下耗时
        long spendTime = end - start;
        if (spendTime >= 1000){
            LOGGER.warn("方法耗时严重 , 请及时处理,耗时: "+spendTime+"毫秒");
        }else {
            LOGGER.info("方法耗时:"+spendTime+"毫秒,速度正常");
        }

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
