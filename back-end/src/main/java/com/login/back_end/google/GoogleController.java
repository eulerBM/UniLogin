package com.login.back_end.google;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/google")
public class GoogleController {

    private final GoogleService googleService;

    public GoogleController(GoogleService googleService) {
        this.googleService = googleService;
    }

    @GetMapping
    public ResponseEntity<?> google(){

        return googleService.googleHello();
    }
}
