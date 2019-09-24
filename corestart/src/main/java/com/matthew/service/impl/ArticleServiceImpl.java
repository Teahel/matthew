package com.matthew.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.matthew.entity.Article;
import com.matthew.mapper.ArticleMapper;
import com.matthew.service.ArticleService;
import org.springframework.stereotype.Service;

/**
 * @Author: L.T.J
 * @project core_start
 * @package com.matthew.service.impl
 * @CreateDate: 2019/9/24 14:44
 * @Version: 1.0
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper,Article> implements ArticleService {
}
