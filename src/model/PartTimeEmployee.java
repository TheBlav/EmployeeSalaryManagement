package model;

public class PartTimeEmployee extends Employee {
    double wage, workedHours;
    public PartTimeEmployee(String name, String lastName, double wage, double workedHours) {
       super(name,lastName);
       this.wage = wage;
       this.workedHours = workedHours;


    }

    @Override
    public double calculateMonthSalary() {
        return (wage*workedHours);
    }

    @Override
    public double calculateYearSalary() {
        return (calculateMonthSalary()*12);
    }
}
