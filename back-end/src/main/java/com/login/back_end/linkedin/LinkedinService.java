package com.login.back_end.linkedin;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LinkedinService {

    public ResponseEntity<?> linkedinHello(){
        return ResponseEntity.ok().body("Hello Linkedin");
    }
}
