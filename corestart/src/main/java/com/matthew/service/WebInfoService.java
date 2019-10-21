package com.matthew.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.matthew.entity.WebInfor;

public interface WebInfoService extends IService<WebInfor> {
   WebInfor findWebInfo();
}
