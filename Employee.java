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
        int department_id = this.department.getId();
        String sql = String.format("INSERT INTO employees (name, department_id, salary) VALUES ('%s', %d, %7.2f);", this.name, department_id, this.salary);
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }




    public static void all(){
        String sql = "SELECT * FROM employees;";
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while (rs.next()) {
                String name = rs.getString("name");
                Double salary = rs.getDouble("salary");
                System.out.println(name);
                System.out.println(salary);
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();

        }
    }

    public static void deleteAll(){
        String sql = "DELETE FROM employees;";
        SqlRunner.executeUpdate(sql);
    }
    public void getAllDetails() {
        String sql = String.format("SELECT employees.id, employees.name, departments.title, employees.salary FROM employees JOIN departments ON departments.id = employees.department_id WHERE employees.id = %d;", this.id);
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String deptTitle = rs.getString("title");
                Double salary = rs.getDouble("salary");
                System.out.println(id);
                System.out.println(name);
                System.out.println(deptTitle);
                System.out.println(salary);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
    }
}