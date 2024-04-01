package com.xmy.nacosprovider.controller;

import javax.xml.ws.RequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author xmy
 * @date 2024/4/1 16:53
 */
@RestController
public class ClientController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * 请求：http://localhost:8080/test
     *
     * @return
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        //通过Springcloud common 中的负载均衡接口选取服务提供节点实现接口调用
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-server");
        System.out.println("uri:" + serviceInstance.getUri());
        String url = serviceInstance.getUri() + "/testService";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return "Invoke:" + url + ",return:" + result;
    }
}
