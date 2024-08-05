package com.pandulove.springboot.cruddemo.rest;

import com.pandulove.springboot.cruddemo.entity.Employee;
import com.pandulove.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
//    private EmployeeDAO employeeDAO;
    private EmployeeService employeeService;

    // quick and dirty: inject employee dao (use constructor injection)
//    public EmployeeRestController(EmployeeDAO employeeDAO) {
//        this.employeeDAO = employeeDAO;
//    }

    // using service layer
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // add mapping for GET/employess/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if(employee == null){
            throw new RuntimeException("Employee Id not found " +employeeId);
        }

        return employee;
    }

        // add mapping for POST/employees - add new employee
    @PostMapping("/employees/{employee}")
    public Employee addEmployee(@RequestBody Employee employee){

        Employee savedEmployee = employeeService.save(employee);

        return  savedEmployee;
    }
}
