package com.example.mongoapi.mongoapi.repository;

import com.example.mongoapi.mongoapi.models.Employee;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository< Employee , String > {
    
}
