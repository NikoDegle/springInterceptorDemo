package mine.practice.springdemo.intercepter.configure;

import mine.practice.springdemo.intercepter.TestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author : whc
 * @version : 1.0
 * 拦截器配置类 需要继承WebMvcConfigurer接口 加上Configuration注释
 * 这里先配置上TestInterceptor
 */

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * 在拦截器链上注册我们的拦截器方法 重写该方法后加上我们的拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册一个拦截器并拦截所有请求
        // registry.addInterceptor(new TestInterceptor());

        // 注册一个拦截器并拦截对应请求
        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/test");

        // 注册一个拦截器并不拦截部分请求
        // registry.addInterceptor(new TestInterceptor()).excludePathPatterns("/test");
    }
}
