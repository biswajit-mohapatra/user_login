package com.biswajit.user.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Accessors(chain = true)
public class Department {

  private Integer deptId;
  private List<Employee> empList;

  public Integer getDeptId() {
    return deptId;
  }

  public void setDeptId(Integer deptId) {
    this.deptId = deptId;
  }

  public List<Employee> getEmpList() {
    return empList;
  }

  public void setEmpList(List<Employee> empList) {
    this.empList = empList;
  }
}
