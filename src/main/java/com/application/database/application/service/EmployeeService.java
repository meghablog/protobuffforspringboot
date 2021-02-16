package com.application.database.application.service;


import com.application.database.application.dto.EmployeeProto;
import com.application.database.application.entity.Employee;
import com.application.database.application.repository.EmployeeRepository;
import org.hibernate.boot.model.relational.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;


    public EmployeeProto.EmployeeMsg saveEmployee(EmployeeProto.EmployeeMsg emp) {

        var employee = new Employee(emp.getEmployeeid(),
                emp.getEmpName(), emp.getPhoneNumber(), emp.getSalary(), emp.getDepartment(), null);

        Employee save = repository.save(employee);
        return EmployeeProto.EmployeeMsg.newBuilder().setEmployeeid(save.getEmployeeid())
                .setEmpName(save.getEmp_name())
                .setSalary(save.getSalary())
                .setDepartment(save.getDepartment())
                .setPhoneNumber(save.getPhoneNumber())
                .build();


    }

    public List<Employee> saveEmployees(List<Employee> employees) {
        return repository.saveAll(employees);
    }

    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    public EmployeeProto.EmployeeMsg getEmployeeById(Integer id) {
        var save = repository.findById(id).get();
        return EmployeeProto.EmployeeMsg.newBuilder().setEmployeeid(save.getEmployeeid())
                .setEmpName(save.getEmp_name())
                .setSalary(save.getSalary())
                .setDepartment(save.getDepartment())
                .setPhoneNumber(save.getPhoneNumber())
                .build();
    }

    public EmployeeProto.EmployeeMsg getEmployeeByName(String name) {
        var save = repository.findAll().stream().filter(data -> data.getEmp_name().equals(name)).findAny().get();
        return EmployeeProto.EmployeeMsg.newBuilder().setEmpName(save.getEmp_name())
                .setEmpName(save.getEmp_name())
                .setSalary(save.getSalary())
                .setDepartment(save.getDepartment())
                .setPhoneNumber(save.getPhoneNumber())
                .build();

    }


    public Optional<Employee> getEmployeeById(String id) {
//        Optional<Employee> employee =
        return repository.findById(Integer.valueOf(id));
    }

    public String deleteEmployee(int id) {
        repository.deleteById(id);
        return "Employee removed " + id;
    }

    public Employee updateEmployee(Employee employee) {
        Employee existingEmployee = repository.findById(employee.getEmployeeid()).get();
        existingEmployee.setEmp_name(employee.getEmp_name());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setCreatedate(employee.getCreatedate());
        existingEmployee.setEmployeeid(employee.getEmployeeid());
        existingEmployee.setPhoneNumber(employee.getPhoneNumber());
        existingEmployee.setDepartment(employee.getDepartment());
        return repository.save(existingEmployee);
    }


}

