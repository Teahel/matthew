package org.teahel.uitls;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import org.teahel.entity.User;
import org.teahel.repository.HandlerRepository;

import java.sql.SQLException;

/**
 * @Author L.T.J
 * @Date 2020/3/24 11:23
 * @Version 1.0T
 */
public class HandlerUse<T> implements HandlerRepository<T> {

    private QueryRunner queryRunner;

    public <T>T query(BeanHandler<T> beanHandler) throws SQLException {
        queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from user";
        T t  = queryRunner.query(sql,beanHandler);
        return  t;
    }


}
