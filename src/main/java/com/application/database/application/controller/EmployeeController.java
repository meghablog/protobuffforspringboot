package com.application.database.application.controller;

import com.application.database.application.dto.EmployeeProto;
import com.application.database.application.entity.Employee;
import com.application.database.application.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")

public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/addEmployee")
    public EmployeeProto.EmployeeMsg addEmployee(@RequestBody EmployeeProto.EmployeeMsg employee) {

        return service.saveEmployee(employee);
    }

    @PostMapping("/addEmployees")
    public List<Employee> addEmployee(@RequestBody List<Employee> employee) {
        return service.saveEmployees(employee);
    }

    @GetMapping("/employees")
    public List<Employee> findAllEmployees() {
        log.info("/employee has been called");
        return service.getEmployees();
    }


    @GetMapping("/employees/{id}")
    public EmployeeProto.EmployeeMsg findEmployeeByName(@PathVariable String id) {
        Optional<Employee> employeeDetailsById = service.getEmployeeById(id);
        return EmployeeProto.EmployeeMsg.newBuilder()
                .setEmployeeid(employeeDetailsById.get().getEmployeeid())
                .setEmpName(employeeDetailsById.get().getEmp_name())
                .setSalary(employeeDetailsById.get().getSalary())
                .setDepartment(employeeDetailsById.get().getDepartment())
                .setPhoneNumber(employeeDetailsById.get().getPhoneNumber())
                .build();
    }

//    @PutMapping ("/update")
//    public Employee updateEmployee(@RequestBody Employee employee ) {
//        return service.saveEmployee(employee);
//    }
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id){
        return service.deleteEmployee(id);
    }
}
