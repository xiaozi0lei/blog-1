package cn.sunguolei.blog.eurekaconsumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("user")
public interface TestClient {

    @GetMapping("test")
    String testing();

}
