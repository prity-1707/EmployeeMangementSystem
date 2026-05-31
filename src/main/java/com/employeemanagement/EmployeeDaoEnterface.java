package com.employeemanagement;

public interface EmployeeDaoEnterface {

    void createEmployee(Employee emp);

    void showEmployee();

    void shoeEmployeeBasedOnID(int id);

    void updateEmployee(int id, String name);

    void deleteEmployee(int id);

    void searchEmployeeByName(String name);

    boolean adminLogin(String username, String password);
}