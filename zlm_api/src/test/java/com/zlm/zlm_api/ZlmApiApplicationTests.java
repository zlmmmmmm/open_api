package com.zlm.zlm_api;

import com.zlm.zlmapiclientsdk.client.ZlmApiClient;
import com.zlm.zlmapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ZlmApiApplicationTests {
    @Resource
    private ZlmApiClient zlmApiClient;

    @Test
    void contextLoads() {
        String result = zlmApiClient.getNameByGet("zlm");
        System.out.println(result);

        User user = new User();
        user.setName("zlm");

        String res1 = zlmApiClient.getUserNameByPost(user);
        System.out.println(res1);
    }

}
