package com.cdu.springboot.domain;

import org.springframework.web.multipart.MultipartFile;

public class User {
    private String username;
    private MultipartFile headPortrait;

    public User(String username, MultipartFile headPortrait) {
        this.username = username;
        this.headPortrait = headPortrait;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public MultipartFile getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(MultipartFile headPortrait) {
        this.headPortrait = headPortrait;
    }
}
