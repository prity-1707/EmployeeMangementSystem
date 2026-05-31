package com.employeemanagement;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        EmployeeDaoEnterface Dao = new EmployeeDaoImpl();

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome To Employee Management System");

        while (true) {


            System.out.println("========== ADMIN LOGIN ==========");

            System.out.print("Enter Username : ");
            String username = sc.next();

            System.out.print("Enter Password : ");
            String password = sc.next();

            if (!Dao.adminLogin(username, password)) {
                System.out.println("Invalid Username or Password");
                System.exit(0);
            }

            System.out.println("Login Successful");

            System.out.println("\n===== MENU =====");

            System.out.println("1. Add Employee");
            System.out.println("2. Show All Employee");
            System.out.println("3. Show Employee By ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Search Employee By Name");
            System.out.println("7. Exit");

            System.out.print("Enter Choice : ");

            int ch = sc.nextInt();

            switch (ch) {

                case 1:

                    Employee emp = new Employee();

                    System.out.print("Enter ID : ");
                    int id = sc.nextInt();

                    System.out.print("Enter Name : ");
                    String name = sc.next();

                    System.out.print("Enter Salary : ");
                    double salary = sc.nextDouble();

                    if (salary <= 0) {
                        System.out.println("Salary must be greater than 0");
                        break;
                    }

                    System.out.print("Enter Age : ");
                    int age = sc.nextInt();

                    if (age < 18) {
                        System.out.println("Age must be 18 or above");
                        break;
                    }

                    emp.setId(id);
                    emp.setName(name);
                    emp.setSalary(salary);
                    emp.setAge(age);

                    Dao.createEmployee(emp);

                    break;

                case 2:

                    Dao.showEmployee();
                    break;

                case 3:

                    System.out.print("Enter ID : ");
                    int empId = sc.nextInt();

                    Dao.shoeEmployeeBasedOnID(empId);

                    break;

                case 4:

                    System.out.print("Enter Employee ID : ");
                    int updateId = sc.nextInt();

                    System.out.print("Enter New Name : ");
                    String newName = sc.next();

                    Dao.updateEmployee(updateId, newName);

                    break;

                case 5:

                    System.out.print("Enter Employee ID : ");
                    int deleteId = sc.nextInt();

                    Dao.deleteEmployee(deleteId);

                    break;

                case 6:

                    System.out.print("Enter Employee Name : ");

                    String empName = sc.next();

                    Dao.searchEmployeeByName(empName);

                    break;

                case 7:

                    System.out.println("Thank You");

                    System.exit(0);

                    break;

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}