package demo.spring.consul;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenyao
 * @date 2020/5/28 16:43
 * @description
 */
@SpringBootApplication
@RestController
public class ConsulServerApp {

    @Value("${server.port}")
    private String port;
    @GetMapping("/")
    public String home(){
        return "hello world! port="+port;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsulServerApp.class,args);
    }

}
