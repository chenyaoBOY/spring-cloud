package org.crazy.springcloud;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//feign提供的注解@FeignClient 用于消费服务(负载均衡的消费)  fallback 断路器配置 实现类
@FeignClient(value = "EUREKA-CLIENT",fallback = FeignServiceImpl.class)
public interface FeignService {


    //value值 是远程调用路径
    @GetMapping(value = "/index/{name}")
    String getName(@PathVariable("name") String name);

}
