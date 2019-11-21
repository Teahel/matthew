package com.matthew.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.matthew.entity.Information;
import com.matthew.mapper.InformationMapper;
import com.matthew.service.InformationService;
import org.springframework.stereotype.Service;

/**
 * @Author: ltj
 * @Description:
 * @Date: Create in 17:59 2019/11/21
 */
@Service
public class InformationServiceImpl extends ServiceImpl<InformationMapper, Information> implements InformationService {
}
