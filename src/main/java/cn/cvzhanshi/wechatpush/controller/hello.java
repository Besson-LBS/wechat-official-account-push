package cn.cvzhanshi.wechatpush.controller;

import cn.cvzhanshi.wechatpush.entity.message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/getVersion")
    public String getVersion() {
        return "3";
    }

    @PostMapping("/foo")
    public String send(@RequestBody message message) {
        System.out.println(message);
        return "success ";
    }
}
