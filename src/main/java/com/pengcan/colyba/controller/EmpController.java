package com.pengcan.colyba.controller;

import com.pengcan.colyba.Service.EmpService;
import com.pengcan.colyba.common.Result;
import com.pengcan.colyba.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("findAll")
    public Result findAll() {
        List<Employee> list = empService.findAll();
        return Result.success(list);
    }

    @PostMapping("insert")
    public Result save(@RequestBody Employee employee) {
        return empService.save(employee);
    }

    @PostMapping("login")
    public Result login(@RequestBody Employee employee) {
        Result res = empService.login(employee);
        return res;
    }
    @DeleteMapping("delete/{id}")
    public Result delete(@PathVariable Integer id){
        return empService.deleteById(id);
    }
    @PostMapping("update")
    public Result update(@RequestBody Employee employee){
        empService.update(employee);
        return Result.success();
    }
}
