package com.example.demo.systemprofile;

public class ProductionProfile implements SystemProfile{
    @Override
    public String getProfile() {
        return "Current profile is Production";
    }
}
