package com.zlt.servlet;

import com.alibaba.fastjson.JSON;
import com.zlt.dao.UserDao;
import com.zlt.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "findAllServlet", value = "/findAllServlet")
public class findAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet方法");
        UserDao userDao = new UserDao();
        try {
//            User user = new User();
//            user.setId(5);
//            user.setEname("gg4");
//            user.setSal(123);
//            int list1 = userDao.insert(user);
            List<User> list = userDao.findAll();
            //System.out.println(list);
            String listStr = JSON.toJSONString(list);

            //System.out.println(listStr);
            PrintWriter out = response.getWriter();
            out.print(listStr);
            out.flush();
            out.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost方法");
    }
}
