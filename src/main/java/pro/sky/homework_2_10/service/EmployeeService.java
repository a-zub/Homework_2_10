// Homework 2.10
// @ Aleksandar Zubanov
// 2022/09

package pro.sky.homework_2_10.service;

import org.springframework.stereotype.Service;
import pro.sky.homework_2_10.exception.EmployeeAlreadyAddedException;
import pro.sky.homework_2_10.exception.EmployeeNotFoundException;
import pro.sky.homework_2_10.exception.EmployeeStorageIsFullException;
import pro.sky.homework_2_10.model.Employee;

import java.util.*;

@Service
public class EmployeeService {

    private static final int LIMIT = 10;

    private final Map<String, Employee> employees = new HashMap<>();
    private final ValidatorService validatorService;

    public EmployeeService(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    private String getKey(String name, String surname) {
        return name + " | " + surname;
    }


    public Employee addEmployee(String name, String surname, int department, double salary) {
        Employee employee = new Employee(
                validatorService.validateName(name),
                validatorService.validateSurname(surname),
                department,
                salary);
        String key = getKey(employee.getName(), employee.getSurname());
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже имеется!");
        }
        if (employees.size() < LIMIT) {
            employees.put(key, employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException(" Список сотрудников переполнен! ");
    }

    public Employee removeEmployee(String name, String surname) {
        String key = getKey(name, surname);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException(" Сотрудник не найден! ");
        }
        return employees.remove(key);
    }

    public Employee findEmployee(String name, String surname) {
        String key = getKey(name, surname);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException(" Сотрудник не найден! ");
        }
        return employees.get(key);
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }
}
