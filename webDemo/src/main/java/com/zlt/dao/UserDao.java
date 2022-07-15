package com.zlt.dao;

import com.zlt.entity.User;
import com.zlt.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    //添加一个用户
    public int insert(User user) throws SQLException {
        //1. 连接
        Connection conn = JDBCUtil.getConnection();

        //2. sql
        String sql = "INSERT INTO USER(id,ename,sal) VALUES(?,?,?)";
        PreparedStatement prep = conn.prepareStatement(sql);
        prep.setInt(1,user.getId());
        prep.setString(2,user.getEname());
        prep.setDouble(3,user.getSal());

        //3. 结果
        int row = prep.executeUpdate();

        //4. 关闭连接
        conn.close();

        return row;
    }

    //删除
    public int delete(int id) throws SQLException {
        //1. 连接
        Connection conn = JDBCUtil.getConnection();

        //2. sql
        String sql = "delete from user where id=?";
        PreparedStatement prep = conn.prepareStatement(sql);
        prep.setInt(1,id);

        //3. 结果
        int row = prep.executeUpdate();

        //4. 关闭连接
        conn.close();

        return row;
    }

    public List<User> findAll() throws SQLException {
        //1. 连接
        Connection conn = JDBCUtil.getConnection();

        //2. sql
        String sql = "select * from user";
        PreparedStatement prep = conn.prepareStatement(sql);

        //3. 结果
        ResultSet rs = prep.executeQuery();
        //处理结果
        List<User> list = new ArrayList<User>();
        while(rs.next()){
            //rs代表的就是每一行
            User user = new User();

            int id = rs.getInt("id");
            String ename = rs.getString("ename");
            double sal = rs.getDouble("sal");

            user.setId(id);
            user.setEname(ename);
            user.setSal(sal);

            list.add(user);
        }

        //4. 关闭连接
        conn.close();

        return list;
    }

    public static void main(String[] args) throws SQLException {
        List<User> list = new UserDao().findAll();
        System.out.println(list);
    }


}
