package org.teahel;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.teahel.entity.User;
import org.teahel.pathxmlapplicationcontext.PathXmlApplicationContext;
import org.teahel.service.impl.UserServiceImpl;
import org.teahel.uitls.HandlerUse;
import org.teahel.uitls.JDBCUtils;
import org.teahel.uitls.QueryHanderUtils;

import java.sql.SQLException;
import java.util.List;

import static javafx.scene.input.KeyCode.T;

/**
 * @Author L.T.J
 * @Date 2020/3/19 16:38
 * @Version 1.0
 */
public class Test {

    public static void main(String args[]) throws Exception {
        PathXmlApplicationContext pathXmlApplicationContext = new PathXmlApplicationContext("org.teahel.service.impl");
        UserServiceImpl userService = (UserServiceImpl)pathXmlApplicationContext.getBean("userServiceImpl");
        User result = userService.outPut();
        System.out.println("orderservice输出:"+result);
/*
        System.out.println("对象:"+userService);
*/
    }

    /**
     * 查询
     */
    @org.junit.jupiter.api.Test
   public void testSelect() throws SQLException {
       QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
       String sql = "select * from user";
       List<User> list = queryRunner.query(sql,new QueryHanderUtils());
       System.out.println(list);
   }

    /**
     * 插入
     */
    @org.junit.jupiter.api.Test
   public void testInsert() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "insert into user values(?,?,?)";
        int update = queryRunner.update(sql,"4","2","7");
        System.out.println(update);
    }

    /**
     * 修改
     */
    @org.junit.jupiter.api.Test
    public void testUpdate() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "update user set username = ? where userid = ?";
        int update = queryRunner.update(sql,"mathtew","4");
        System.out.println(update);
    }

    /**
     * 删除
     */
    @org.junit.jupiter.api.Test
    public void testDelete() throws SQLException {
        QueryRunner queryRunner  = new QueryRunner(JDBCUtils.getDataSource());
        String sql  = "delete from user where userid = ?";
        int update = queryRunner.update(sql,4);
        System.out.println(update);
    }

    /**
     * 测试BeanHandler策略
     */
    @org.junit.jupiter.api.Test
    public void testBeanHandler() throws SQLException {
        QueryRunner queryRunner  = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from user";
        User user  = queryRunner.query(sql,new BeanHandler<User>(User.class));
        System.out.println(user);
    }

    /**
     * 测试BeanListHandler 策略
     */
    @org.junit.jupiter.api.Test
    public void testBeanListHandler() throws SQLException {
        QueryRunner queryRunner  = new QueryRunner(JDBCUtils.getDataSource());
        String sql  = "select * from user";
        List<User> list = queryRunner.query(sql,new BeanListHandler<User>(User.class));
        System.out.println(list);
    }

    /**
     * 测试自己封装的框架(只查询第一个)
     * @throws SQLException
     */
    @org.junit.jupiter.api.Test
    public void testHandlerUse() throws SQLException {
        HandlerUse handlerUse = new HandlerUse<User>();
        System.out.println(handlerUse.query(new BeanHandler<User>(User.class)));
    }

}
