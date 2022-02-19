package com.github.rod1andrade.lendbookbackend.features.infos.external.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoController {

    @GetMapping(value = "/version")
    public ResponseEntity<String> version() {
        return ResponseEntity.ok().body("Version: 1.0.0");
    }

}
