package com.example.demo.controller;

import com.example.demo.systemprofile.SystemProfile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProfileController {
    private SystemProfile systemProfile;

    public ProfileController(SystemProfile systemProfile) {
        this.systemProfile = systemProfile;
    }

    @GetMapping("profile")
    public String getProfile() {
        return systemProfile.getProfile();
    }
}
