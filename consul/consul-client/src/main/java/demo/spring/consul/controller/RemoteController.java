package demo.spring.consul.controller;

import demo.spring.consul.service.RemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenyao
 * @date 2020/5/28 17:32
 * @description
 */
@RestController
public class RemoteController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RemoteService remoteService;

    @GetMapping("/fegin")
    public String fegin(){
        return remoteService.remoteRequestByFeign();
    }

    @GetMapping("/request")
    public String request(@RequestParam String servicename,
                          @RequestParam String path){

        return restTemplate.getForObject("http://"+servicename+"/"+path,String.class);
    }

    @GetMapping("/home")
    public String home(){
        return "hello world";
    }

}
