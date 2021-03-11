package com.example.mongoapi.mongoapi.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Response {
    private Integer status;
    private Integer code;
    private String message;
    private List<Employee> records;
}
