package com.train;

public class Student {
    private String name;
    private String department;
    private float percent;

    public Student(String name, String department, float percent) {
        this.name = name;
        this.department = department;
        this.percent = percent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }
}
