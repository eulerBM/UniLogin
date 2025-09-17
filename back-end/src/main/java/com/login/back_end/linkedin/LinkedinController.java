package com.login.back_end.linkedin;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/linkedin")
public class LinkedinController {

    private final LinkedinService linkedinService;

    public LinkedinController(LinkedinService linkedinService) {
        this.linkedinService = linkedinService;
    }

    @GetMapping
    public ResponseEntity<?> linkedin(){
        return linkedinService.linkedinHello();
    }
}
