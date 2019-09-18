package com.matthew.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.matthew.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @Author: L.T.J
 * @project mybatis_plus
 * @package com.matthew.mapper
 * @CreateDate: 2019/9/2 11:50
 * @Version: 1.0
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
