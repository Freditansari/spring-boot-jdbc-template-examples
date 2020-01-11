package com.merdekacloud.JdbcTemplate.Repositories;

import com.merdekacloud.JdbcTemplate.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Repository("JdbcEmployeeRepositories")
public class JDBCEmployeeRepo implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int count() {
        return jdbcTemplate.queryForObject("Select count(*) from employee", Integer.class);
    }

    @Override
    public int savePS(Employee employee) {
        String sql = "INSERT INTO public.employee (lastname, firstname, address, city) VALUES ( ?, ?, ?, ?)";

        KeyHolder kh = new GeneratedKeyHolder();

        int result = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"employeeid"});
            ps.setString(1, employee.getLastName());
            ps.setString(2, employee.getFirstName());
            ps.setString(3, employee.getAddress());
            ps.setString(4, employee.getCity());
            return ps;
        }, kh);

        System.out.println("your key is :" +kh.getKey().toString());

        //code to insert to other detail tables
        return result;
    }


    @Override
    public int save(Employee employee) {

        return jdbcTemplate
                .update("INSERT INTO public.employee(\n" +
                        "\t lastname, firstname, address, city)\n" +
                        "\tVALUES ( ?, ?, ?, ?)",
                employee.getLastName(),
                employee.getFirstName(),
                employee.getAddress(),
                employee.getCity()
        );

    }

    @Override
    public int update(Employee employee) {


        return jdbcTemplate.update(
                "Update employee set lastname =?, firstname =?, address =?, city=? where employeeId =?",
                employee.getLastName(),
                employee.getFirstName(),
                employee.getAddress(),
                employee.getCity(),
                employee.getEmployeeId());
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("delete from employee where employeeId = ?", id );
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query(
                "select * from employee",
                (rs, rowNum) ->
                        new Employee(
                                rs.getLong("employeeid"),
                                rs.getString("lastname"),
                                rs.getString("firstname"),
                                rs.getString("Address"),
                                rs.getString("city")
                        ));
    }

    @Override
    public List<Employee> findByLastName(String lastName) {
        return null;
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return Optional.empty();
    }
}
