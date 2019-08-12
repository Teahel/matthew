package com.teahel.powsers.service.impl;

import com.teahel.powsers.beans.Poweruser;
import com.teahel.powsers.repository.PoweruserRepository;
import com.teahel.powsers.service.IPoweruserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by Theahel
 * User: Matthew
 * Date: 2019/4/2
 * Time: 23:36
 * Description: No Description
 */
@Service
@Transactional(rollbackOn=Exception.class)
public class PoweruserServiceImpl implements IPoweruserService {
    private static Logger LOGGER = LoggerFactory.getLogger(PoweruserServiceImpl.class);
    @Resource
    PoweruserRepository repository;

    public Poweruser findById(long id){
        return repository.findById(id);
    }
    /**
     * 用户登录
     * @param username 账户
     * @param password 密码
     * @return 用户实体
     */
    public Poweruser findByUsernameAndPassword(String username,String password){
        LOGGER.info("开始查询");
        Poweruser user= repository.findByUsernameAndPassword(username,password);
        LOGGER.debug("查询结束");
        return  user;
    }
}
