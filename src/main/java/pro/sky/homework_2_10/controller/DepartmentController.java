// Homework 2.10
// @ Aleksandar Zubanov
// 2022/09

package pro.sky.homework_2_10.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework_2_10.model.Employee;
import pro.sky.homework_2_10.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee findEmployeeMaxSalaryFromDepartment(@RequestParam("department") int department) {
        return departmentService.findEmployeeMaxSalaryFromDepartment(department);
    }

    @GetMapping("/min-salary")
    public Employee findEmployeeMinSalaryFromDepartment(@RequestParam("department") int department) {
        return departmentService.findEmployeeMinSalaryFromDepartment(department);
    }

    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> findEmployeesFromDepartment(@RequestParam("department") int department) {
        return departmentService.findEmployeesFromDepartment(department);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> findEmployeesFromDepartment() {
        return departmentService.findEmployees();
    }

}
