package com.xmy.nacosprovider.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xmy
 * @date 2024/3/23 17:08
 */
@RestController
public class EchoController {


    @GetMapping("/echo")
    public String echo(HttpServletRequest request) {
        return "echo: " + request.getParameter("name");
    }
}
