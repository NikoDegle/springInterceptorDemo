package mine.practice.springdemo.intercepter.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;


/**
 * @author : whc
 * @version : 1.0
 * 该类用于解析controller返回值的内容 需要继承ResponseBodyAdvice 并使用ControllerAdvice注解
 */

@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {

    /**
     * 该方法返回值需要修改为true
     * @param returnType
     * @param converterType
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    /**
     * 该方法是具体获取返回值内容的方法 返回值内容可以从body中获取
     * @param body
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        HttpServletRequest httpServletRequest =
                ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        HttpSession httpSession = httpServletRequest.getSession(true);
        httpServletRequest.setAttribute("response", body);
        httpSession.setAttribute("body", body);

        return body;
    }
}
