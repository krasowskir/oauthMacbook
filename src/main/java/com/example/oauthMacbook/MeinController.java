package com.example.oauthMacbook;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeinController {

    @GetMapping("/endpunkt/test")
    public HttpStatus getEndpoint(){

        return HttpStatus.OK;
    }


}
