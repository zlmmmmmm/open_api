package com.zlm.zlm_api.controller;

import com.zlm.zlm_api.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("name")
public class NameController {
    @GetMapping("/")
    public String getNameByGet(String name) {
        return "Get 你的名字是" + name;
    }

    @PostMapping("/")
    public String getNameByPost(@RequestParam String name) {
        return "Post 你的名字是" + name;
    }

    @PostMapping("/user")
    public String getUserNameByPost(@RequestBody User user) {
        return "Post 用户名字是" + user.getName();
    }
}
