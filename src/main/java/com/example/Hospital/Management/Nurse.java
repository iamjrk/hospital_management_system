package com.example.Hospital.Management;

public class Nurse
{
    private int id;
    private String name;
    private int age;
    private String qualification;

    public Nurse(int id, String name, int age, String qualification) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.qualification = qualification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
