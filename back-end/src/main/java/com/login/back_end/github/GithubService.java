package com.login.back_end.github;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GithubService {

    public ResponseEntity<?> githubHello() {
        return ResponseEntity.ok().body("Hello Github");
    }
}
