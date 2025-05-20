package com.example.service;

import com.example.domain.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 従業員情報一覧を全件検索する業務処理を行う.
 */

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * 全件検索する.
     *
     * @return 全従業員情報の一覧
     */
    public List<Employee> showList(){
        return employeeRepository.findAll();
    }

    /**
     * 従業員情報を一件検索する.
     *
     * @param id 従業員のID
     * @return IDで検索された従業員
     */
    public Employee showDetail(Integer id){
        return employeeRepository.findById(id);
    }

    /**
     * 従業員情報を更新する.
     *
     * @param employee 従業員情報
     */
    public void update(Employee employee){
        employeeRepository.update(employee);
    }
}
