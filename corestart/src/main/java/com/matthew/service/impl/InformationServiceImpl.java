package com.matthew.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.matthew.Utils.ReturnResultUtils;
import com.matthew.entity.Information;
import com.matthew.mapper.InformationMapper;
import com.matthew.service.InformationService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ltj
 * @Description:
 * @Date: Create in 17:59 2019/11/21
 */
@Service
public class InformationServiceImpl extends ServiceImpl<InformationMapper, Information> implements InformationService {

    /**
     * 保存网址信息
     * @return
     */
    @Override
    public ReturnResultUtils saveInformation(Information information) {
        boolean flag = this.save(information);
        if(flag){
            ReturnResultUtils returnResultUtils = new ReturnResultUtils();
            List<Information> informationList = this.list();
            returnResultUtils.putList(informationList);
            return  returnResultUtils;
        }
        return ReturnResultUtils.error(500,"保存失败。");
    }

    /**
     * 查询信息
     * @return  失败返回错误码
     *           成功返回正确数据
     */
    @Override
    public ReturnResultUtils findInformations() {
        ReturnResultUtils returnResultUtils = new ReturnResultUtils();
        List<Information> informationList = this.list();
        returnResultUtils.putList(informationList);
        return returnResultUtils;
    }

    /**
     * 删除信息
     * @return  失败返回错误码
     *           成功返回正确数据
     */
    @Override
    public ReturnResultUtils deleteInformation(Information information) {
        boolean flag = this.removeById(information.getInforid());
        if(flag){
            ReturnResultUtils returnResultUtils = new ReturnResultUtils();
            List<Information> informationList = this.list();
            returnResultUtils.putList(informationList);
            return returnResultUtils;
        }
        return ReturnResultUtils.error(500,"删除失败");
    }


}
