import java.sql.ResultSet;

import db.SqlRunner;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private Department department;

    public Employee(String name, Department department, double salary) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void save() {
//        String sql = String.format(
//                "INSERT INTO employees (name, salary, department) VALUES ('%s', %7.2f, %d; "
//                , this.name, this.salary, department);
//        this.id = SqlRunner.executeUpdate(sql);
//        SqlRunner.closeConnection();
    }

//    public static void all(){
//        String sql = "SELECT * FROM employees;";
//        ResultSet rs = SqlRunner.executeQuery();
//        try {
//            while (rs.next()) {
//                String name = rs.getString("name");
//                Double salary = rs.getDouble(this.salary);
//                System.out.println(name);
//                System.out.println(this.salary);
//                System.out.println();
//            }
//        } catch (Exception e) {
//            System.err.println(e.getClass().getName() + " : " + e.getMessage());
//            System.exit(0);
//        } finally {
//            SqlRunner.closeConnection();
//
//        }
//    }
}