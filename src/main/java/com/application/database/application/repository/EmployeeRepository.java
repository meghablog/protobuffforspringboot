package com.application.database.application.repository;

import com.application.database.application.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    //Employee findByEmp_name(String name);
}
