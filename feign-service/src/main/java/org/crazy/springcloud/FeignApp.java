package org.crazy.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableDiscoveryClient
//feign 默认集成了ribbon负载均衡和hystrix断路器
@EnableFeignClients
//用于查看HystrixDashboard管理页面
@EnableHystrixDashboard
public class FeignApp {
    public static void main(String[] args) {
        SpringApplication.run(FeignApp.class, args);
    }
}
