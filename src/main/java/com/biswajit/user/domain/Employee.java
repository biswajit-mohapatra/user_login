package com.biswajit.user.domain;

import lombok.Data;

@Data
public class Employee {

  private Long id;
  private String name;
  private String dob;
  private Double salary;
}
