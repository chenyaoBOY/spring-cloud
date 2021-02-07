package com.demo.ribbon_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private ServiceImpl service;

    @RequestMapping("/index/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name){
        String s = service.hiService(name);
        return s;
    }

}
