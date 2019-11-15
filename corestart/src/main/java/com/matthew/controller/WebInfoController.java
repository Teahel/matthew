package com.matthew.controller;

import com.matthew.Utils.ReturnResultUtils;
import com.matthew.service.WebInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webinfo")
public class WebInfoController {
    @Autowired
    private WebInfoService webInfoService;

    /**
     * 查询网站信息
     * @return 网站
     */
    @RequestMapping(value = "/find",method = RequestMethod.POST)
    public ReturnResultUtils findWebInfo(){
        ReturnResultUtils returnResultUtils = new ReturnResultUtils();
        returnResultUtils.putObject(webInfoService.findWebInfo());
        return returnResultUtils;
    }
}
