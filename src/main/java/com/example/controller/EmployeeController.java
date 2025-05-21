package com.example.controller;

import com.example.domain.Administrator;
import com.example.domain.Employee;
import com.example.form.UpdateEmployeeForm;
import com.example.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 従業員情報を操作するコントローラ.
 */

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    HttpSession session;

    /**
     * 従業員を全件表示する.
     *
     * @param model モデル
     * @return 従業員一覧画面
     */
    @GetMapping("/showList")
    public String showList(Model model){
        if(!isLogin()){
            return "redirect:/";
        }
        List<Employee> employees = employeeService.showList();
        model.addAttribute("employeeList", employees);
        return "employee/list";
    }

    /**
     * 従業員の詳細情報を表示する.
     *
     * @param id 従業員ID
     * @param model リクエストスコープ
     * @return 従業員詳細画面
     */
    @GetMapping("/showDetail")
    public String showDetail(String id, Model model, UpdateEmployeeForm form){
        if(!isLogin()){
            return "redirect:/";
        }
        Employee employee = employeeService.showDetail(Integer.parseInt(id));
        model.addAttribute("employee", employee);
        return "employee/detail";
    }

    /**
     * 従業員情報を更新する.
     *
     * @param form IDと扶養人数が入ったフォーム
     * @return 従業員一覧画面
     */
    @PostMapping("/update")
    public String update(@Validated UpdateEmployeeForm form, BindingResult result, Model model){
        if(result.hasErrors()){
            Employee employee = employeeService.showDetail(Integer.parseInt(form.getId()));
            return showDetail(String.valueOf(employee.getId()), model, form);
        }
        Employee employee = employeeService.showDetail(Integer.parseInt(form.getId()));
        employee.setDependentsCount(Integer.parseInt(form.getDependentsCount()));
        employeeService.update(employee);
        return "redirect:/employee/showList";
    }

    private boolean isLogin(){
        String administrator = (String) session.getAttribute("administratorName");
        return !(administrator == null);
    }
}
