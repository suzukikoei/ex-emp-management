package com.example.controller;

import com.example.domain.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 従業員検索を行うコントローラ.
 */

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * 従業員を全件表示する.
     *
     * @param model
     * @return employee/list　従業員一覧のページ
     */
    @GetMapping("/showList")
    public String showList(Model model){
        List<Employee> employees = employeeService.showList();
        model.addAttribute("employeeList", employees);
        return "employee/list";
    }
}
