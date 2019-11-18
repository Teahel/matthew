package com.matthew.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/** 公告
 * @Author: ltj
 * @Description:
 * @Date: Create in 15:33 2019/11/14
 */
@Data
@TableName("announcement")
public class Announcement {
    /**
     * 主键
     */
    private int announcement_id;

    /**
     * 内容
     */
    private String compoment;

    /**
     * 创建时间
     */
    private String creat_time;

    /**
     * 发布用户
     */
    private String userid;

     /*
     CREATE TABLE announcement(
      announcement_id varchar(60) not null comment '主键',
      compoment varchar(500) not null comment '内容',
      creat_time datetime not null comment '公告发布时间',
      userid varchar(60) not null comment '用户id',
      PRIMARY KEY(announcement_id)
     );
    */
}
