package com.matthew.controller;

import com.matthew.Utils.ReturnResultUtils;
import com.matthew.entity.Article;
import com.matthew.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
@RestController
@RequestMapping ("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 查询所有文章内容
     * @return 所有文章结果
     */
    @RequestMapping( value = "/findList",method = RequestMethod.POST)
    public Map<String,Object> findArticleLists(){
        List<Article> list = articleService.findArticleLists();
        Map<String,Object> map = new HashMap<>();
        if (list!=null) {
            map.put("list",list);
            map.put("code",200);
            map.put("msg","查询成功");
        } else {
            map.put("code",500);
            map.put("msg","查询失败");
        }
        return map;
    }

    /**
     * 保存文章
     * @param article 文章实体
     * @return 返回结果
     *       成功返回true
     *       错误返回false
     */
    @RequestMapping(value = "/add")
    public ReturnResultUtils addArticle(@RequestBody Article article){
        boolean flag = articleService.addArticle(article);
        if(flag){
            return ReturnResultUtils.ok();
        }
        return ReturnResultUtils.error(111,"保存失败");
    }

    /**
     * 删除文章
     * @param article_id 文章id
     * @return 返回结果
     *       成功返回true
     *       错误返回false
     */
    @RequestMapping(value = "/delete")
    public ReturnResultUtils deleteArticle(@RequestParam String article_id){
        boolean flag = articleService.deleteArticle(article_id);
        if(flag){
            return ReturnResultUtils.ok();
        }
        return ReturnResultUtils.error(111,"删除失败");
    }

    /**
     * 修改文章
     * @param article 修改内容
     * @return  返回修改后的文章list
     */
    @RequestMapping(value = "/update")
    public ReturnResultUtils updateArticle(@RequestBody Article article){
        if(StringUtils.isEmpty(article.getArticleid())){
            return ReturnResultUtils.error(111,"修改数据ID 不能为空");
        }
        return articleService.updateArticle(article);
    }
}
