package com.employeemanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDaoImpl implements EmployeeDaoEnterface {

    Connection con;

    @Override
    public void createEmployee(Employee emp) {

        con = DBConnection.createDBConnection();

        String query =
                "INSERT INTO employee(id,name,salary,age,department,email) VALUES(?,?,?,?,?,?)";

        try {

            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setInt(1, emp.getId());
            pstm.setString(2, emp.getName());
            pstm.setDouble(3, emp.getSalary());
            pstm.setInt(4, emp.getAge());
            pstm.setString(5, emp.getDepartment());
            pstm.setString(6, emp.getEmail());

            int cnt = pstm.executeUpdate();

            if (cnt != 0)
                System.out.println("Employee Inserted Successfully");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void showEmployee() {

        con = DBConnection.createDBConnection();

        String query = "SELECT * FROM employee";

        try {

            Statement stmt = con.createStatement();

            ResultSet result = stmt.executeQuery(query);

            System.out.println("Employee Details");

            System.out.format("%s\t%s\t%s\t%s\t%s\t%s\n",
                    "ID", "NAME", "SALARY", "AGE", "DEPARTMENT", "EMAIL");

            while (result.next()) {

                System.out.printf("%d\t%s\t%.2f\t%d\t%s\t%s\n",
                        result.getInt("id"),
                        result.getString("name"),
                        result.getDouble("salary"),
                        result.getInt("age"),
                        result.getString("department"),
                        result.getString("email"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void shoeEmployeeBasedOnID(int id) {

        con = DBConnection.createDBConnection();

        String query = "SELECT * FROM employee WHERE id=?";

        try {

            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setInt(1, id);

            ResultSet result = pstm.executeQuery();

            while (result.next()) {

                System.out.printf("%d\t%s\t%.2f\t%d\t%s\t%s\n",
                        result.getInt("id"),
                        result.getString("name"),
                        result.getDouble("salary"),
                        result.getInt("age"),
                        result.getString("department"),
                        result.getString("email"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(int id, String name) {

        con = DBConnection.createDBConnection();

        String query = "UPDATE employee SET name=? WHERE id=?";

        try {

            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setString(1, name);
            pstm.setInt(2, id);

            int cnt = pstm.executeUpdate();

            if (cnt != 0)
                System.out.println("Employee Updated Successfully");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {

        con = DBConnection.createDBConnection();

        String query = "DELETE FROM employee WHERE id=?";

        try {

            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setInt(1, id);

            int cnt = pstm.executeUpdate();

            if (cnt != 0)
                System.out.println("Employee Deleted Successfully");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void searchEmployeeByName(String name) {

        con = DBConnection.createDBConnection();

        String query = "SELECT * FROM employee WHERE name=?";

        try {

            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setString(1, name);

            ResultSet result = pstm.executeQuery();

            while (result.next()) {

                System.out.printf("%d\t%s\t%.2f\t%d\t%s\t%s\n",
                        result.getInt("id"),
                        result.getString("name"),
                        result.getDouble("salary"),
                        result.getInt("age"),
                        result.getString("department"),
                        result.getString("email"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean adminLogin(String username, String password) {

        if (username.equals("prity") &&
                password.equals("1707")) {

            return true;
        }

        return false;
    }
}