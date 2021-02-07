package org.crazy.springcloud;


import org.springframework.stereotype.Service;

//需要加component注解  spring管理
@Service
public class FeignServiceImpl implements FeignService{


    public String getName(String name) {
        return name+"  sorry  client is not connect";
    }
}
