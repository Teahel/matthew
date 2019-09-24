package com.matthew.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: L.T.J
 * @project core_start
 * @package com.matthew.entity
 * @CreateDate: 2019/9/24 13:49
 * @Version: 1.0
 */
@Data
@TableName("article_type")
public class ArticleType implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 类型id
     */
    @TableId(type=IdType.UUID)
    private String typeid;

    /**
     * 类型名称
     */
    private String typename;

}
