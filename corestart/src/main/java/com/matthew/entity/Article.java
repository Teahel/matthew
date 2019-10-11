package com.matthew.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**文章内容
 * @Author: L.T.J
 * @project core_start
 * @package com.matthew.entity
 * @CreateDate: 2019/9/24 13:58
 * @Version: 1.0
 */
@Data
@TableName("article")
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId(type=IdType.UUID)
    private String articleid;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     *上传时间
     */
    private String createtime;

    /**
     * 上传账户
     */
    private String userid;

    /**
     * 转载链接
     */
    private String reprintlink;
}
