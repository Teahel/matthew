package com.matthew.controller;

import com.matthew.Utils.ReturnResultUtils;
import com.matthew.entity.Article;
import com.matthew.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: L.T.J
 * @project core_start
 * @package com.matthew.controller
 * @CreateDate: 2019/9/24 14:46
 * @Version: 1.0
 */
@RestController("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 查询所有文章内容
     * @return 所有文章结果
     */
    public ReturnResultUtils findArticleLists(){
        List<Article> list = articleService.findArticleLists();
        ReturnResultUtils returnResultUtils = new ReturnResultUtils();
        Map<String,Object> map = new HashMap<>();
        if (list!=null) {
            map.put("list",list);
            map.put("code",200);
            map.put("msg","查询成功");
        } else {
            map.put("code",500);
            map.put("msg","查询失败");
        }
        returnResultUtils.ok(map);
        return returnResultUtils;
    }

}
