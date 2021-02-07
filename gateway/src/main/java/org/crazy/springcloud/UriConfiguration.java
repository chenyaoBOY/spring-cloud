package org.crazy.springcloud;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author chenyao
 * @date 2020/2/17 21:28
 * @description
 */
@ConfigurationProperties
public class UriConfiguration {


    private String httpbin = "http://httpbin.org:80";

    public String getHttpbin() {
        return httpbin;
    }

    public void setHttpbin(String httpbin) {
        this.httpbin = httpbin;
    }
}
