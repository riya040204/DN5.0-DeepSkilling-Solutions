package com.cognizant.springlearn.model;

public class Employee {

    private int id;
    private String name;
    private String gender;
    private String department;
    private String skill;

    public Employee() {}

    public Employee(int id, String name, String gender,
                    String department, String skill) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.skill = skill;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getSkill() { return skill; }
    public void setSkill(String skill) { this.skill = skill; }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name +
               ", department=" + department + "]";
    }
}
