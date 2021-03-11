package com.example.mongoapi.mongoapi.controller;

import com.example.mongoapi.mongoapi.models.Employee;
import com.example.mongoapi.mongoapi.models.Response;
import com.example.mongoapi.mongoapi.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private EmployeeService service;
    
    @GetMapping(value="/check")
    public String getMethodName() {
        return "MongoAPI server is up and running";
    }

    @GetMapping(value = "/getEmployee")
    public Response getAllEmployee(){
        return service.returnResponseForGetAllTheEmployee();
    }

    @GetMapping(value = "/getEmployeeById/{id}")
    public Response getAllEmployeeById(@PathVariable String id ){
        return service.returnResponseForGetEmployeeById(id);
    }

    @PostMapping(value = "/addEmployee")
    public Response addEmployee(@RequestBody Employee employee){
       return service.returnResponseForAddEmployee(employee);
    }

    @PostMapping(value = "/updateEmployee")
    public Response updateEmployee(@RequestBody Employee employee){
        return service.returnResponseForUpdateEmployee(employee);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Response deleteEmployee(@PathVariable String id){
        return service.returnResponseForDeleteEmployee(id);
    }

}
