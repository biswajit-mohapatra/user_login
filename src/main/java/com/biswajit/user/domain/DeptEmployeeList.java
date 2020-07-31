package com.biswajit.user.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
public class DeptEmployeeList {
  private List<Department> deptList = new ArrayList<>();
}
