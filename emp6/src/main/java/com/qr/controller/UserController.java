package com.qr.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qr.dao.DepartmentDao;
import com.qr.dao.EmployeeDao;
import com.qr.dao.UserDao;
import com.qr.entity.Department;
import com.qr.entity.Employee;
import com.qr.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;


@WebServlet(value = "/user", loadOnStartup = 0)
public class UserController extends HttpServlet {
    final String prefix = "WEB-INF/user/";

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");

            String type = request.getParameter("type");
            if (type == null) {
                showLogin(request, response);
            } else if (type.equals("login")) {
                login(request, response);
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        UserDao userDao = new UserDao();
        user = userDao.search(user);
        if (user != null) {
            Cookie c = new Cookie("user", user.getUsername());
            c.setMaxAge(60*60*24*30);
            response.addCookie(c);

            HttpSession session=request.getSession();
            session.setAttribute("user",user);

            response.sendRedirect("emp");
        } else {
            response.sendRedirect("user");
        }
    }

    private void showLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = "";
        Cookie[] cookies = request.getCookies();
        for (int i = 0; cookies != null & i < cookies.length; i++) {
            if (cookies[i].getName().equals("user")) {
                username = cookies[i].getValue();

            }
        }
        request.setAttribute("username", username);
        request.getRequestDispatcher(prefix + "login.jsp").forward(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
}
