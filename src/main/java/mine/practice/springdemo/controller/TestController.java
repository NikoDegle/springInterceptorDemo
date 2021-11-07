package mine.practice.springdemo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : whc
 * @version : 1.0
 * 测试controller类 用于测试springboot框架是否正常运行
 */

@RestController
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "the spring framework is running";
    }
}
