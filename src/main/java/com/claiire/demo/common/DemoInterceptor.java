package com.claiire.demo.common;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈一句话功能简述〉<br>
 * 〈拦截器〉
 *
 * @author Claire
 * @create 2021/3/4
 * @since 1.0.0
 */
@Component
@Slf4j
public class DemoInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info(" === preHandle === ");
        log.info(" === request.getRequestURI === "+ request.getRequestURI());
        return true;
//        return false;//返回false只有前置拦截器，就当前拦截器
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        log.info(" === postHandle === ");
        log.info(" === request.getRequestURI === "+ request.getRequestURI());

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        log.info(" === afterCompletion === ");
        log.info(" === request.getRequestURI === "+ request.getRequestURI());
    }
}
