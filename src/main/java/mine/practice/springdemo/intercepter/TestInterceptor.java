package mine.practice.springdemo.intercepter;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : whc
 * @version : 1.0
 * 测试springmvc中拦截器 实现部分拦截器功能
 * @note : 拦截器需要继承HandlerInterceptorAdapter类 或 实现handlerInterceptor接口
 * 本TestInterceptor使用了实现接口的方式
 * 拦截器需要实现三个方法 分别是preHandle() postHandle() afterCompletion()
 */

public class TestInterceptor implements HandlerInterceptor {

    /**
     * 该方法于请求被处理之前调用 用于需要预先处理参数或者用户状态校验之类的工作
     * 这里做一个输出表示已经调用了该拦截器了
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入预处理部分");
        String uri = request.getRequestURI();
        System.out.println("请求uri为" + uri);
        return true;
    }


    /**
     * 该方法用于请求被处理并返回modleAndView之后调用，可以操作modelAndView
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("执行返回前部分");
        if (null != modelAndView && !StringUtils.isEmptyOrWhitespace(modelAndView.getViewName())) {
            String viewName = modelAndView.getViewName();
            System.out.println("返回页面名为" + viewName);
        }
    }

    /**
     * 该方法用于执行方法返回结果后执行，用于处理返回值
     * 该方法必须要preHandle()方法返回true的情况下才会执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("执行业务逻辑后返回值部分");
        String backStr = request.getAttribute("response").toString();
        System.out.println("业务逻辑返回值为" + backStr);
    }
}
