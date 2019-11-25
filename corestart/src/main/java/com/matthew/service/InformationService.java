package com.matthew.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.matthew.Utils.ReturnResultUtils;
import com.matthew.entity.Information;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: ltj
 * @Description:
 * @Date: Create in 17:58 2019/11/21
 */
public interface InformationService  extends IService<Information> {

    /**
     * 保存信息(成功之后将会再次检索一次全部数据。)
     * @return  失败返回错误码
     *           成功返回正确数据
     *
     */
    ReturnResultUtils saveInformation(Information information);

    /**
     * 查询信息
     * @return  失败返回错误码
     *           成功返回正确数据
     */
    ReturnResultUtils findInformations();

    /**
     * 删除信息
     * @return  失败返回错误码
     *           成功再次查询数据
     *
     */
    ReturnResultUtils deleteInformation(Information information);
}
