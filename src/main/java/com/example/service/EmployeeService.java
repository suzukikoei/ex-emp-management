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
     * @return すべての従業員一覧
     */
    public List<Employee> showList(){
        return employeeRepository.findAll();
    }
}
