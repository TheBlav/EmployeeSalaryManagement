package model;

public class FullTimeEmployee extends Employee {
double monthSalary;
    public FullTimeEmployee(String name, String lastName, double monthSalary) {
        super(name, lastName);
        this.monthSalary = monthSalary;
    }

    @Override
    public double calculateMonthSalary() {
        return monthSalary;
    }

    @Override
    public double calculateYearSalary() {
        return ((monthSalary*12)*1.05);
    }
}
