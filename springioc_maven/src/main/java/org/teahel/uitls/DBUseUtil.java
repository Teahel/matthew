package org.teahel.uitls;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.jupiter.api.Test;
import org.teahel.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
/**
 * @Author L.T.J
 * @Date 2020/3/20 16:52
 * @Version 1.0
 */
public class DBUseUtil {
    @Test
    public void testDbUtils(){
//首先使用c3p0创建DataSource
        ComboPooledDataSource cpds = new ComboPooledDataSource();

        try {
            //DBUtils只是帮助我们简化增删改查的代码，连接的创建和获取，不在DBUtils的考虑范围之内
            //创建QueryRunner对象，可以操作增删改查  new QueryRunner的时候要注意传参，参数为一个连接池 dataSource
            QueryRunner queryRunner = new QueryRunner(cpds);
            //测试增加
//			queryRunner.update("insert into stu_user values(null,?,?)", "aaa","123456");
            //测试删除
//			queryRunner.update("delete from stu_user where id = ?",2);
            //测试修改
//			queryRunner.update("update stu_user set username=? where id=?", "bbb",3);

            //测试查询，首先用自己写匿名实现类自己封装的方法 后面的rsh是ResultSetHandler<T> T装泛型，此时需要写一个JavaBean来封装  目前只是查询一个的
            User user = queryRunner.query("select * from user where userid=?",new ResultSetHandler<User>(){
                User user = new User();
                public User handle(ResultSet rs) throws SQLException {

                    while(rs.next()){
                        //获取三个的值后封装
                        String userid = rs.getString("userid");
                        String username = rs.getString("username");
                        String password = rs.getString("password");

                        user.setUserid(userid);
                        user.setUsername(username);
                        user.setPassword(password);
                    }
                    return user;
                }
            } , 1);

            System.out.println(user);

            //测试查询，使用现在不自己写匿名实现类了，直接用人家写的实现类
            //BeanHandler(一个对象) 和 BeanListHandler(多个对象)  尖括号里面装JavaBean 圆括号里面装字节码，他要通过字节码来创建实例化对象
            List<User> list = queryRunner.query("select * from user", new BeanListHandler<User>(User.class));
            System.out.println(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
