package cn.sunguolei.blog.eurekaconsumer.controller;

import cn.sunguolei.blog.eurekaconsumer.service.TestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private TestClient testClient;

    public TestController(TestClient testClient) {
        this.testClient = testClient;
    }

    @GetMapping("consumer")
    public String consumer() {
        return testClient.testing();
    }
}
