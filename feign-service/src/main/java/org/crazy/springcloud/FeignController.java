package org.crazy.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private FeignService service;

    @GetMapping("/feign/{name}")
    public String getName(@PathVariable String name){

        return service.getName(name);
    }
}
