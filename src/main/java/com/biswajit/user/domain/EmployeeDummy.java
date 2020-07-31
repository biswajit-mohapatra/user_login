package com.biswajit.user.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EmployeeDummy {

  private Integer id;
  private String name;
  private String dob;
  private Double salary;
}
