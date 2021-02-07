package com.demo.ribbon_service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ServiceImpl {

    @Autowired
    private RestTemplate restTemplate;

    //断路器配置 @HystrixCommand  当服务挂掉以后  执行serviceError方法 并返回
    @HystrixCommand(fallbackMethod = "serviceError")
    public String hiService(String name) {
        //EUREKA-CLIENT  是client中的注册名称  /index 为注册者的一个controller路径
        return restTemplate.getForObject("http://EUREKA-CLIENT/index/"+name,String.class);
    }

    public String serviceError(String name){
        return name+"   sorry,rpc service is not work";
    }
}
