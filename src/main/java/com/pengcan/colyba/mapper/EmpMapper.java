package com.pengcan.colyba.mapper;

import com.pengcan.colyba.entity.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("select * from employee")
    List<Employee> findAll();

    @Insert("insert into employee (username, nickname, password, sex,create_time, update_time)" +
            " values (#{username},#{nickname},#{password},#{sex},#{createTime},#{updateTime});")
    void insert(Employee employee);

    //根据username查询用户
    @Select("select * from employee where username = #{username}")
    Employee findByUsername(String username);

    @Delete("delete from employee where id=#{id};")
    boolean delete(Integer id);

    void update(Employee employee);
}
