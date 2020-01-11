package com.merdekacloud.JdbcTemplate.Controllers;

import com.merdekacloud.JdbcTemplate.Entity.Employee;
import com.merdekacloud.JdbcTemplate.Repositories.JDBCEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class EmployeeController {

    @Autowired
    @Qualifier("JdbcEmployeeRepositories")
    private JDBCEmployeeRepo jdbcEmployeeRepo;

    @GetMapping("/employee")
    public List<Employee> getEmployees(){
        return jdbcEmployeeRepo.findAll();
    };

    @PostMapping("/employee")
    public int postEmployee(@Valid @RequestBody Employee employee){
        return jdbcEmployeeRepo.save(employee);
    }

    @PostMapping("/employee/ps")
    public int postEmployeePS(@Valid @RequestBody Employee employee){
        return jdbcEmployeeRepo.savePS(employee);
    }

    @DeleteMapping("/employee")
    public int deleteEmployee(@RequestParam(value = "id") Long id){
        return jdbcEmployeeRepo.deleteById(id);
    }

    @PutMapping("/employee")
    public int updateEmployee(@RequestBody Employee employee){
        return jdbcEmployeeRepo.update(employee);
    }
}
