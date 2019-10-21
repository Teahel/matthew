package com.matthew.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.matthew.entity.WebInfor;
import com.matthew.mapper.WebInforMapper;
import com.matthew.service.WebInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebInfoServiceImpl extends ServiceImpl<WebInforMapper, WebInfor> implements WebInfoService {
    /**
     * 查询网站信息
     * @return 网站信息对象
     */
    @Override
    public WebInfor findWebInfo() {
        List<WebInfor> list = this.list();
        if(list!=null){
            return list.get(0);
        }
        return  null;
    }
}
