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
 * @CreateDate: 2019/9/24 14:12
 * @Version: 1.0
 */

@Data
@TableName("webinformation")
public class WebInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * webinfor主键
     */
    @TableId(type=IdType.UUID)
    private String webinforid;

    /**
     * 网站名称
     */
    private String webName;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 著作人
     */
    private String madeName;

    /**
     * 代码地址
     */
    private String codeAddress;
}
