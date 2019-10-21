package com.matthew.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.matthew.entity.Article;

import java.util.List;

/**
 * @Author: L.T.J
 * @project core_start
 * @package com.matthew.service
 * @CreateDate: 2019/9/24 14:43
 * @Version: 1.0
 */
public interface ArticleService extends IService<Article> {
    List<Article> findArticleLists();
}
