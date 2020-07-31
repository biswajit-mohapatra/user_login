package com.biswajit.user.controller;

import com.biswajit.user.domain.Department;
import com.biswajit.user.domain.DepartmentWiseAverageSallary;
import com.biswajit.user.domain.Employee;
import com.biswajit.user.domain.DeptEmployeeList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class EmployeeController {

  @GetMapping("getDeptWiseEmployeeList")
  public DeptEmployeeList  getDeptWiseEmployeeList() {

    List<Department> deptList = new ArrayList<>();

    Department dept1 = new Department();
    dept1.setDeptId(570);

    /*
    Employee List1
     */
    List<Employee> empList1 = new ArrayList<>();
    empList1.add(new Employee(100, "Subrat Routray", "05-05-1980", 32470.00));
    empList1.add(new Employee(101, "Biswajit Mohapatra", "05-05-1981", 12500.00));
    empList1.add(new Employee(102, "Krupalini Bal", "05-05-1987", 22000.00));
    empList1.add(new Employee(103, "Dinesh Kumar Bal", "05-05-1978", 17000.00));

    dept1.setEmpList(empList1);
    deptList.add(dept1);


    dept1 = new Department();
    dept1.setDeptId(580);

    empList1 = new ArrayList<>();
    empList1.add(new Employee(100, "Subrat Routray", "05-05-1980", 21900.00));
    empList1.add(new Employee(101, "Biswajit Mohapatra", "05-05-1981", 12000.00));
    empList1.add(new Employee(102, "Krupalini Bal", "05-05-1987", 8000.00));

    dept1.setEmpList(empList1);
    deptList.add(dept1);

    DeptEmployeeList deptEmployeeList = new DeptEmployeeList();
    deptEmployeeList.getDeptList().addAll(deptList);
    return deptEmployeeList;
  }

  @GetMapping("getEmployee")
  public  List<DepartmentWiseAverageSallary> getEmployeeDetailsById() {

    RestTemplate restTemplate = new RestTemplate();
    DeptEmployeeList DeptEmpList =
        restTemplate.getForObject("http://localhost:9922/getDeptWiseEmployeeList", DeptEmployeeList.class);
    log.info("Found Dept employee List  : {} ", DeptEmpList);

    List<DepartmentWiseAverageSallary> deptWiseSalary = new ArrayList<>();
    Map<Integer, List<Employee>> map = DeptEmpList.getDeptList().stream().collect(Collectors.toMap(Department :: getDeptId,Department::getEmpList));
    for(Entry<Integer,List<Employee>> entry: map.entrySet()){
      deptWiseSalary.add(new DepartmentWiseAverageSallary(entry.getKey(),entry.getValue().stream().collect(Collectors.averagingDouble(Employee :: getSalary))));
    }
   log.info("Average Salary  : {} ", deptWiseSalary);
    return deptWiseSalary;
  }
}
