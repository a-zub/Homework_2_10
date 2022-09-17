// Homework 2.10
// @ Aleksandar Zubanov
// 2022/09

package pro.sky.homework_2_10.exception;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}
