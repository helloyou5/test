package com.zlt.servlet;

import com.zlt.dao.UserDao;
import com.zlt.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "addServlet", value = "/addServlet")
public class addServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String ename = request.getParameter("ename");
        String password = request.getParameter("password");
        String sal = request.getParameter("sal");


        User user = new User();
        user.setEname(ename);

        user.setSal(Double.parseDouble(sal));
        System.out.println(user);
        try {
            new UserDao().insert(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
