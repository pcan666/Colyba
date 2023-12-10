package com.pengcan.colyba.Service.impl;

import com.pengcan.colyba.Service.EmpService;
import com.pengcan.colyba.common.Result;
import com.pengcan.colyba.entity.Employee;
import com.pengcan.colyba.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Employee> findAll() {
        return empMapper.findAll();
    }

    @Override
    public Result save(Employee employee) {
        //判断新增用户的用户名是否唯一
        Employee byUsername = empMapper.findByUsername(employee.getUsername());
        if (byUsername == null) {//用户名可用
            employee.setCreateTime(LocalDateTime.now());
            employee.setUpdateTime(LocalDateTime.now());
            empMapper.insert(employee);
            return Result.success();
        } else {
            return Result.error("用户名已存在");
        }
    }

    @Override
    /**
     * 登录成功返回数据库中的数据
     */
    public Result login(Employee employee) {
        //判断用户名是否存在
        Employee DBEmployee = empMapper.findByUsername(employee.getUsername());
        if (DBEmployee != null) {//存在
            //判断密码是否正确
            if (DBEmployee.getPassword().equals(employee.getPassword())) {
                return Result.success(DBEmployee);
            }
        }
        return Result.error("用户名或密码错误");
    }

    @Override
    /**
     * 通过id删除用户
     */
    public Result deleteById(Integer id) {
        if (empMapper.delete(id)) {
            return Result.success();
        }else {
            return Result.error("删除失败");
        }
    }

    @Override
    public void update(Employee employee) {
        empMapper.update(employee);
    }
}
