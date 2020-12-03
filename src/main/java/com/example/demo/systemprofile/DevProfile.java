package com.example.demo.systemprofile;

public class DevProfile implements SystemProfile{
    @Override
    public String getProfile() {
        return "Current profile is Development";
    }
}
