package com.matthew.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.matthew.Utils.ReturnResultUtils;
import com.matthew.entity.Article;
import com.matthew.mapper.ArticleMapper;
import com.matthew.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.BitSet;
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

    /**
     * 保存文章
     * @param article 文章实体
     * @return 返回结果
     *       成功返回true
     *       错误返回false
     */
    @Override
    public boolean addArticle(Article article) {
        return this.save(article);
    }

    /**
     * 删除文章
     * @param article_id 文章id
     * @return 返回结果
     *       成功返回true
     *       错误返回false
     */
    @Override
    public boolean deleteArticle(String article_id) {
        return this.removeById(article_id);
    }

    /**
     * 修改文章
     * @param article 修改内容
     * @return 返回结果
     *       成功返回true
     *       错误返回false
     */
    @Override
    public ReturnResultUtils updateArticle(Article article) {
        boolean flag = this.updateById(article);
        ReturnResultUtils resultUtils = new ReturnResultUtils();
        if(flag){
            resultUtils.putList(findArticleLists());
            return resultUtils;
        }
        return  ReturnResultUtils.error(111,"修改失败");
    }

}
