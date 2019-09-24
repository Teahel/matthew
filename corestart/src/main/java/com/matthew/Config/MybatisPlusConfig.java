package com.matthew.Config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: L.T.J
 * @project mybatis_plus
 * @package com.matthew.config
 * @CreateDate: 2019/9/4 8:54
 * @Version: 1.0
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * 分页查询插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
