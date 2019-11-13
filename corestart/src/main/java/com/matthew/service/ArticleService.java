package com.matthew.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.matthew.Utils.ReturnResultUtils;
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
    /**
     * 查询所有文章
     * @return 返回所有文章
     */
    List<Article> findArticleLists();

    /**
     * 保存文章
     * @param article 文章实体
     * @return 返回结果
     *       成功返回true
     *       错误返回false
     */
    boolean addArticle(Article article);

    /**
     * 删除文章
     * @param article_id 文章id
     * @return 返回结果
     *       成功返回true
     *       错误返回false
     */
    boolean deleteArticle(String article_id);

    /**
     * 修改文章
     * @param article 修改内容
     * @return  返回修改后的文章list
     */
    ReturnResultUtils updateArticle(Article article);

}
