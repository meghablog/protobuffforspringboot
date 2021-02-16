package com.application.database.application.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id

    @Column(name = "employeeid")
    private int employeeid;
    @Column(name = "emp_name")
    private String emp_name;
    @Column(name = "phonenumber")
    private int phoneNumber;
    @Column(name = "salary")
    private int salary;
    @Column(name = "department")
    private String department;
    @Column(name = "createdate")
    private Date createdate;


}
