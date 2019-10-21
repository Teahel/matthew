package com.matthew.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.matthew.entity.ArticleType;

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
}
