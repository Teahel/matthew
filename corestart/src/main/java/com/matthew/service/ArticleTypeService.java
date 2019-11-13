package com.matthew.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.matthew.Utils.ReturnResultUtils;
import com.matthew.entity.ArticleType;

import java.util.List;

/**
 * @Author: L.T.J
 * @project core_start
 * @package com.matthew.service
 * @CreateDate: 2019/9/24 14:25
 * @Version: 1.0
 */
public interface ArticleTypeService extends IService<ArticleType> {
    /**
     * 文章类型名称
     * @param typeName
     * @return 保存结果
     */
    boolean saveArticleType(String typeName);

    /**
     * 删除文章类型
     * @param typeid
     * @return 成功 返回删除后的list
     *         失败 返回错误信息
     */
    ReturnResultUtils deleteArticleType(String typeid);

    /**
     * 查询所有的类型
     * @return 返回所有的类型
     */
    ReturnResultUtils findList();
}
