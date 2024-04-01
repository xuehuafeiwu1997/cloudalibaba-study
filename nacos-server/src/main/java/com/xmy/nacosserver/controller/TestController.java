package com.xmy.nacosserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xmy
 * @date 2024/4/1 17:03
 */
@Controller
public class TestController {
    @RequestMapping(value = "/testService", method = RequestMethod.GET)
    @ResponseBody
    public String testService() {
        return "这是来自服务端提供的服务";
    }
}
