package com.qr.controller;

import com.qr.dao.EmployeeDao;
import com.qr.entity.Employee;
import com.qr.service.EmployeeService;
import com.qr.service.impl.EmployeeServiceImpl;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;


@Controller
@RequestMapping("emp")
public class EmployeeController {
    @Autowired
    EmployeeService empService;
    @RequestMapping("add")
    private String add(Employee emp) {
        boolean flag = empService.add(emp);
        if (flag) {
            return "redirect:emp";
        } else {
            return "redirect:emp?type=showAdd";
        }

    }

    @RequestMapping("update")
    private String update(Employee emp) {

        boolean flag = empService.update(emp);
        if (flag) {
            return "redirect:emp";
        } else {
            return "redirect:emp?type=showUpdate";
        }
    }

    @RequestMapping("delete")
    private String delete(int id) {

        boolean flag = empService.delete(id);
        return "redirect:emp";


    }

    @RequestMapping("showAdd")
    private String showAdd() {
        return "add";
    }

    @RequestMapping("showUpdate")
    private ModelAndView showUpdate(int id) {
        ModelAndView mv = new ModelAndView("update");

        Employee emp = empService.search(id);
        mv.addObject("emp", emp);
        return mv;
    }

    @RequestMapping("search")
    public ModelAndView search() {
        ModelAndView mv = new ModelAndView("show");

        List<Employee> list = empService.search();
        //list.add(new Employee());
        mv.addObject("list", list);
        return mv;
    }

    @RequestMapping("testJson")
    @ResponseBody
    public List<Employee> testJson() {

        List<Employee> list = empService.search();
        return list;
    }
}
