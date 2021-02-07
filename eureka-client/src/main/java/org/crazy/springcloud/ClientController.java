package org.crazy.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/index/{name}")
    String home(@PathVariable String name){
        return "name="+name +"访问的端口是="+port;
    }
}
