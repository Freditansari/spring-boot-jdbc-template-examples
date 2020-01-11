package com.merdekacloud.JdbcTemplate.Repositories;

import com.merdekacloud.JdbcTemplate.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    int count();
    int savePS(Employee employee);
    int save(Employee employee);
    int update(Employee employee);
    int deleteById(Long id);
    List<Employee> findAll();
    List<Employee> findByLastName(String lastName);
    Optional<Employee> findById(Long id);



}
