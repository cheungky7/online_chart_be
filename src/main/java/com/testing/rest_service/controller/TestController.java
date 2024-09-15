package com.testing.rest_service.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("testing")
public class TestController {

    @GetMapping("/number/{id}")
    String testNumber(@PathVariable Long id){
        String ret="Return number:"+id;

        return ret;
    }



}
