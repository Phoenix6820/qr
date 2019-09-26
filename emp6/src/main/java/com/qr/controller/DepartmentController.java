package com.qr.controller;

import com.qr.dao.DepartmentDao;
import com.qr.dao.DepartmentDao;
import com.qr.entity.Department;
import com.qr.entity.Department;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;


@WebServlet(value = "/dep", loadOnStartup = 0)
public class DepartmentController extends HttpServlet {
    final String prefix="WEB-INF/dep/";
    @Override
    public void init() {
        System.out.println("****************************************8ddd");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");

            String type = request.getParameter("type");
            if (type == null) {
                search(request, response);
            } else if (type.equals("showAdd")) {
                showAdd(request, response);
            } else if (type.equals("add")) {
                add(request, response);

            } else if (type.equals("showUpdate")) {
                showUpdate(request, response);
            } else if (type.equals("update")) {
                update(request, response);

            } else if (type.equals("delete")) {
                delete(request, response);

            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        try {
            String name = request.getParameter("name");


            Department dep = new Department();
            dep.setName(name);
            DepartmentDao depDao = new DepartmentDao();
            boolean flag = depDao.add(dep);
            if (flag) {
                response.sendRedirect("dep");
            } else {
                response.sendRedirect("dep?type=showAdd");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");


            Department dep = new Department();
            dep.setId(id);
            dep.setName(name);

            DepartmentDao depDao = new DepartmentDao();
            boolean flag = depDao.update(dep);
            if (flag) {
                response.sendRedirect("dep");
            } else {
                response.sendRedirect("dep?type=showAdd");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            DepartmentDao depDao = new DepartmentDao();
            boolean flag = depDao.delete(id);
            if (flag) {
                response.sendRedirect("dep");
            } else {
                response.sendRedirect("dep?type=showAdd");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAdd(HttpServletRequest request, HttpServletResponse response) {
        try {
            DepartmentDao depDao = new DepartmentDao();
            List<Department> depList = depDao.search();
            request.setAttribute("depList", depList);
            request.getRequestDispatcher(prefix+"add.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            DepartmentDao depDao = new DepartmentDao();
            Department dep = depDao.search(id);

            request.setAttribute("dep", dep);

            request.getRequestDispatcher(prefix+"update.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void search(HttpServletRequest request, HttpServletResponse response) {
        try {
            DepartmentDao depDao = new DepartmentDao();
            List<Department> list = depDao.search();
            request.setAttribute("list", list);
            request.getRequestDispatcher(prefix+"show.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
}
