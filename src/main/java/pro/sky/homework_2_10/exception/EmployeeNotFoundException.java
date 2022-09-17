// Homework 2.10
// @ Aleksandar Zubanov
// 2022/09

package pro.sky.homework_2_10.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
