package com.matthew.controller;

import com.matthew.Utils.ReturnResultUtils;
import com.matthew.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ltj
 * @Description:
 * @Date: Create in 11:29 2019/10/21
 */
@RestController
@RequestMapping("/article_type")
public class ArticleTypeController {

    @Autowired
    private ArticleTypeService articleTypeService;

    /**
     * 保存文章类型名称
     * @param typeName 类型名称
     * @return 保存结果
     *   code:200：成功 500：失败
     */
    @RequestMapping( value = "/save",method = RequestMethod.POST)
    public ReturnResultUtils saveArticleType(@RequestParam String typeName){
        ReturnResultUtils returnResultUtils = new ReturnResultUtils();
        Map<String,Object> map = new HashMap<>();
        boolean flag = articleTypeService.saveArticleType(typeName);
        if(flag){
            map.put("code",200);
            map.put("msg","保存文章类型成功");
        } else {
            map.put("code",500);
            map.put("msg","保存文章类型失败");
        }
        returnResultUtils.ok(map);
        return returnResultUtils;
    }
}
