package com.qr.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qr.dao.DepartmentDao;
import com.qr.dao.EmployeeDao;
import com.qr.entity.Department;
import com.qr.entity.Employee;
import com.qr.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;


@WebServlet(value = "/emp", loadOnStartup = 0)
public class EmployeeController extends HttpServlet {
    final String prefix = "WEB-INF/emp/";

    @Override
    public void init() {
        System.out.println("****************************************8ddd");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

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
            } else if (type.equals("show")) {
                delete(request, response);

            } else if (type.equals("testJson")) {
                testJson(request, response);

            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        try {
            String name = request.getParameter("name");
            String sex = request.getParameter("sex");
            int age = Integer.parseInt(request.getParameter("age"));
            int depId = Integer.parseInt(request.getParameter("depId"));

            Employee emp = new Employee();
            emp.setName(name);
            emp.setSex(sex);
            emp.setAge(age);
            Department dep = new Department();
            dep.setId(depId);
            emp.setDep(dep);
            EmployeeDao empDao = new EmployeeDao();
            boolean flag = empDao.add(emp);
            if (flag) {
                response.sendRedirect("emp");
            } else {
                response.sendRedirect("emp?type=showAdd");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String sex = request.getParameter("sex");
            int age = Integer.parseInt(request.getParameter("age"));
            int depId = Integer.parseInt(request.getParameter("depId"));

            Employee emp = new Employee();
            emp.setId(id);
            emp.setName(name);
            emp.setSex(sex);
            emp.setAge(age);
            Department dep = new Department();
            dep.setId(depId);
            emp.setDep(dep);
            EmployeeDao empDao = new EmployeeDao();
            boolean flag = empDao.update(emp);
            if (flag) {
                response.sendRedirect("emp");
            } else {
                response.sendRedirect("emp?type=showAdd");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            EmployeeDao empDao = new EmployeeDao();
            boolean flag = empDao.delete(id);
            if (flag) {
                response.sendRedirect("emp");
            } else {
                response.sendRedirect("emp?type=showAdd");
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
            request.getRequestDispatcher(prefix + "add.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            EmployeeDao empDao = new EmployeeDao();
            Employee emp = empDao.search(id);
            DepartmentDao depDao = new DepartmentDao();
            List<Department> depList = depDao.search();

            request.setAttribute("depList", depList);
            request.setAttribute("emp", emp);

            request.getRequestDispatcher(prefix + "update.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void search(HttpServletRequest request, HttpServletResponse response) {
        try {
            EmployeeDao empDao = new EmployeeDao();
            List<Employee> list = empDao.search();
            request.setAttribute("list", list);
            request.getRequestDispatcher(prefix + "show.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testJson(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        String json = null;
        PrintWriter out=null;
        EmployeeDao empDao = new EmployeeDao();
        List<Employee> list = empDao.search();
        ObjectMapper om = new ObjectMapper();
        try {
            json = om.writeValueAsString(list);

             out = response.getWriter();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.print(json);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
