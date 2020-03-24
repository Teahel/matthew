package org.teahel.repository;

import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @Author L.T.J
 * @Date 2020/3/24 17:16
 * @Version 1.0
 */

public interface HandlerRepository<T> {
    public <T>T query(BeanHandler<T> beanHandler) throws SQLException;

}
