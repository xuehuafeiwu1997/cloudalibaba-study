package com.xmy.nacosprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.nacos.api.config.annotation.NacosValue;

/**
 * @author xmy
 * @date 2024/3/23 17:17
 */
@Controller
@RequestMapping("config")
@RefreshScope
//自动刷新需要增加上这个注解
public class ConfigController {

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    @Value("${nickName}")
//    @NacosValue(value = "${nickName}", autoRefreshed = true)
    //NacosValue拿不到对应的值
    private String nickName;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.cloud.nacos.config.fileExtension}")
    private String fileExtension;


    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String get() {
        System.out.println("application:" + applicationName);
        System.out.println("fileExtension:" + fileExtension);
        return nickName;
    }
}
