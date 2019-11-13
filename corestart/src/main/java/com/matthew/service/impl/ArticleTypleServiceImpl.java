package com.matthew.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.matthew.Utils.ReturnResultUtils;
import com.matthew.entity.ArticleType;
import com.matthew.mapper.ArticleTypeMapper;
import com.matthew.service.ArticleTypeService;
import org.springframework.stereotype.Service;

/**
 * @Author: L.T.J
 * @project core_start
 * @package com.matthew.service.impl
 * @CreateDate: 2019/9/24 14:28
 * @Version: 1.0
 */
@Service
public class ArticleTypleServiceImpl extends ServiceImpl<ArticleTypeMapper,ArticleType> implements ArticleTypeService {

    /**
     * 文章类型名称
     * @param typeName
     * @return 保存结果
     */
    @Override
    public boolean saveArticleType(String typeName) {
        ArticleType articleType = new ArticleType();
        articleType.setTypename(typeName);
        return this.save(articleType);
    }

    /**
     * 删除文章类型
     * @param typeid
     * @return 成功 返回删除后的list
     *         失败 返回错误信息
     */
    @Override
    public ReturnResultUtils deleteArticleType(String typeid) {
        ReturnResultUtils returnResultUtils = new ReturnResultUtils();
       boolean flag = this.removeById(typeid);
       if(flag){
           returnResultUtils.putList(this.list());
       }
       return ReturnResultUtils.error(111,"删除文章类型失败");
    }

    /**
     * 查询所有的类型
     * @return 类型list
     */
    @Override
    public ReturnResultUtils findList() {
        ReturnResultUtils returnResultUtils = new ReturnResultUtils();
        returnResultUtils.putList(this.list());
        return returnResultUtils;
    }


}
