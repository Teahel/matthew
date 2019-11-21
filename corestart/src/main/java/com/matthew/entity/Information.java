package com.matthew.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 该类将记录一些比较有趣的网站，我在服务器将开启vpn翻墙。允许登陆的人可以查看。
 * @Author: ltj
 * @Description:
 * @Date: Create in 11:31 2019/11/21
 */
@Data
@TableName("information")
public class Information implements Serializable {

    /**
     * 主键
     */
    @TableId(type= IdType.UUID)
    private String inforid;

    /**
     *内容
     */
    private String content;

    /**
     *网址
     */
    private String websiteUrl;

}
