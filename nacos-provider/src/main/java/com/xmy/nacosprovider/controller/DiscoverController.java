package com.xmy.nacosprovider.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.xmy.nacosprovider.service.NacosService;
import sun.jvm.hotspot.oops.Instance;

/**
 * @author xmy
 * @date 2024/3/23 17:08
 */
@RestController
@RequestMapping("discovery")
public class DiscoverController {

    @NacosInjected
    private NacosService nacosService;

    @GetMapping("/echo")
    public String echo(HttpServletRequest request) {
        return "echo: " + request.getParameter("name");
    }


    /**
     * 请求示例：http://localhost:8080/discovery/get
     *
     * @return
     * @throws NacosException
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<Instance> get() throws NacosException {
        nacosService.testService();
        return null;
    }
}
