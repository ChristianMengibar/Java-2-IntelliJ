package org.iesfm.company;

import java.util.Objects;

public class Employee {
    private String nif;
    private String employeeName;
    private String employeeSurname;
    private String position;

    public Employee() {

    }

    public Employee(String nif, String employeeName, String employeeSurname, String position) {
        this.nif = nif;
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
        this.position = position;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(nif, employee.nif) && Objects.equals(employeeName, employee.employeeName) && Objects.equals(employeeSurname, employee.employeeSurname) && Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, employeeName, employeeSurname, position);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "nif='" + nif + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", employeeSurname='" + employeeSurname + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}