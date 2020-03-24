package org.teahel.uitls;

import org.apache.commons.dbutils.ResultSetHandler;
import org.teahel.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author L.T.J
 * @Date 2020/3/23 11:14
 * @Version 1.0
 *
 */
public class QueryHanderUtils implements ResultSetHandler<List<User>> {
    public List<User> handle(ResultSet resultSet) throws SQLException {
        List<User> list = new ArrayList<User>();
        while (resultSet.next()){
            User user = new User();
            user.setUserid(resultSet.getString("userid"));
            user.setPassword(resultSet.getString("password"));
            user.setUsername(resultSet.getString("username"));
            list.add(user);
        }
        return list;
    }
}
