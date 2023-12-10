package com.pengcan.colyba.Service;

import com.pengcan.colyba.common.Result;
import com.pengcan.colyba.entity.Employee;

import java.util.List;

public interface EmpService {
    List<Employee> findAll();

    Result save(Employee employee);

    //登陆验证
    Result login(Employee employee);

    Result deleteById(Integer id);

    void update(Employee employee);
}
