package demo.spring.consul.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author chenyao
 * @date 2020/5/28 17:30
 * @description
 */
@FeignClient(value = "consul-server-chenyao")
public interface RemoteService {

    @GetMapping("/")
    String remoteRequestByFeign();
}
