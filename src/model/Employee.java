package model;

public abstract class Employee {
    String name, LastName;
    double monthSalary, yearSalary;

    public Employee(String name, String lastName) {
        this.name = name;
        LastName = lastName;
    }

    @Override
    public String toString() {
        return  name + " " +  LastName + ", Miesięczna wypłata: " + calculateMonthSalary() + ", Roczna wypłata: " + calculateYearSalary() ;
    }

    public abstract double calculateMonthSalary();
    public abstract double calculateYearSalary();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public double getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(double monthSalary) {
        this.monthSalary = monthSalary;
    }

    public double getYearSalary() {
        return yearSalary;
    }

    public void setYearSalary(double yearSalary) {
        this.yearSalary = yearSalary;
    }
}
