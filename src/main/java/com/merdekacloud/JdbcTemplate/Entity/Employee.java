package com.merdekacloud.JdbcTemplate.Entity;

import lombok.*;

import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private Long employeeId;

    @Size(min = 2, max = 15, message="Last name minimum of 2 and max of 15 characters")
    private String lastName;
    private String firstName;
    private String address;
    private String city;


}
