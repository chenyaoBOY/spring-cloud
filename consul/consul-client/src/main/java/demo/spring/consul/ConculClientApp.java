package demo.spring.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenyao
 * @date 2020/5/28 16:16
 * @description
 */
@Configuration
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ConculClientApp {


    public static void main(String[] args) {
        SpringApplication.run(ConculClientApp.class,args);
    }
}
