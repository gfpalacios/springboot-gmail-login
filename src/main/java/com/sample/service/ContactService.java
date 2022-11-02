package com.sample.service;

import org.springframework.http.ResponseEntity;

public interface ContactService{
    public ResponseEntity getAllContactForUsrId(int userId);
}
