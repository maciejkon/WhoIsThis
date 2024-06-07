package com.maciew.whoIsThis.controller;

import com.maciew.whoIsThis.service.WhoIsThisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping(path = "/whoisthis")
public class WhoIsThisController {

    @Autowired
    WhoIsThisService whoIsThisService;

    @GetMapping(path = "/songs")
    public ResponseEntity<String> getSongTitle(@RequestParam String authorName) {
        log.info("Request param: " + authorName);
        return whoIsThisService.getSongTitles(authorName);
    }
}
