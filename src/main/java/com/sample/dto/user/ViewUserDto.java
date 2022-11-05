package com.sample.dto.user;

import com.sample.dto.contact.ViewContactDto;

import java.util.List;

public class ViewUserDto {
    private Integer userId;
    private String username;
    private List<ViewContactDto> sampleContactCollection;

    public ViewUserDto() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<ViewContactDto> getSampleContactCollection() {
        return sampleContactCollection;
    }

    public void setSampleContactCollection(List<ViewContactDto> contacts) {
        this.sampleContactCollection = contacts;
    }
}
