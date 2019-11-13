package com.matthew.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.matthew.entity.WebInfor;

public interface WebInfoService extends IService<WebInfor> {
   /**
    * 查询网站信息
    * @return 网站信息对象
    */
   WebInfor findWebInfo();
}
