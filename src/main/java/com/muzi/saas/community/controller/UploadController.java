package com.muzi.saas.community.controller;

import com.muzi.saas.community.service.BossExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @GetMapping("/1")
    public Object upload() {
        BossExecutor.addJob();
        return 1;
    }

    @GetMapping("/2")
    public Object test() {
        return 2;
    }
}
