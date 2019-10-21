package com.matthew.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.matthew.entity.Article;
import com.matthew.mapper.ArticleMapper;
import com.matthew.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: L.T.J
 * @project core_start
 * @package com.matthew.service.impl
 * @CreateDate: 2019/9/24 14:44
 * @Version: 1.0
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper,Article> implements ArticleService {

    /**
     * 查询所有文章
     * @return 返回所有文章
     */
    @Override
    public List<Article> findArticleLists() {
        List<Article> list = this.list();
        return list;
    }
}
