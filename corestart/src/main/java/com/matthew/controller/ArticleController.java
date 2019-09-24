package com.matthew.controller;

import com.matthew.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: L.T.J
 * @project core_start
 * @package com.matthew.controller
 * @CreateDate: 2019/9/24 14:46
 * @Version: 1.0
 */
@Controller
@RestController("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;


}
