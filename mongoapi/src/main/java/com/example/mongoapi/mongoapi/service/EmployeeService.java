package com.example.mongoapi.mongoapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.mongoapi.mongoapi.models.Employee;
import com.example.mongoapi.mongoapi.models.Response;
import com.example.mongoapi.mongoapi.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Response returnResponseForGetAllTheEmployee(){
        Response rsp = new Response();
        try {
            List<Employee> emps = employeeRepository.findAll();
            this.setResponseStatusAndMessageBasedOnCodePassed(rsp ,200);
            this.setResponseRecords(rsp , emps);
        } catch (Exception e) {
            this.setResponseStatusAndMessageBasedOnCodePassed(rsp ,500);
            System.out.println(e);
        }
        return rsp;
    }

    public Response returnResponseForGetEmployeeById(String id){
        Response rsp = new Response();
        List<Employee> lemp = new ArrayList<Employee>();
        try {
            Optional<Employee> result = employeeRepository.findById(id);
            if (result.get() != null){
                lemp.add(result.get());
            }
            this.setResponseStatusAndMessageBasedOnCodePassed(rsp ,200);
            this.setResponseRecords(rsp , lemp);
        } catch (Exception e) {
            this.setResponseStatusAndMessageBasedOnCodePassed(rsp ,500);
            System.out.println(e);
        }
        return rsp;
    }

    public Response returnResponseForAddEmployee(Employee employee){
        Response rsp = new Response();
        try {
            employeeRepository.save(employee);
            this.setResponseStatusAndMessageBasedOnCodePassed(rsp ,200);
        } catch (Exception e) {
            this.setResponseStatusAndMessageBasedOnCodePassed(rsp ,500);
            System.out.println(e);
        }
        return rsp;
    }

    public Response returnResponseForUpdateEmployee(Employee employee){
        Response rsp = new Response();
        try {
            employeeRepository.save(employee);
            this.setResponseStatusAndMessageBasedOnCodePassed(rsp ,200);
        } catch (Exception e) {
            this.setResponseStatusAndMessageBasedOnCodePassed(rsp ,500);
            System.out.println(e);
        }
        return rsp;
    }

    public Response returnResponseForDeleteEmployee(String id){
        Response rsp = new Response();
        try {
            employeeRepository.delete(employeeRepository.findById(id).get());
            this.setResponseStatusAndMessageBasedOnCodePassed(rsp ,200);
        } catch (Exception e) {
            this.setResponseStatusAndMessageBasedOnCodePassed(rsp ,500);
            System.out.println(e);
        }
        return rsp;
    }
    
    public void setResponseStatusAndMessageBasedOnCodePassed(Response rsp , int code){
        switch(code){
            case 200 : {
                rsp.setStatus(200);
                rsp.setMessage("Ok");
                rsp.setCode(0);
                break;
            }
            case 201:{
                rsp.setStatus(201);
                rsp.setMessage("Added Succesfully");
                rsp.setCode(0);
                break;
            }
            case 500: {
                rsp.setStatus(500);
                rsp.setMessage("Server Error");
                rsp.setCode(1);
                break;
            }
        }
    }

    public void setResponseRecords(Response rsp ,  List<Employee> employeeList){
        rsp.setRecords(employeeList);
    }
}
