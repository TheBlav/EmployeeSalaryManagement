package IO;

import model.Employee;
import model.FullTimeEmployee;
import model.PartTimeEmployee;

import java.util.InputMismatchException;
import java.util.Scanner;

public class io implements Printer {
private static final int MAX_EMPLOYEES = 50;
    Employee[] employees = new Employee[MAX_EMPLOYEES];

private int employeesNUmber=0;
Scanner sc = new Scanner(System.in);

public void io() {
    boolean error2 = true;
    do {
        try {
            printer("Jaką ilość pracowników chcesz dodać? \n  ilość: :");
          int  numberOfEmployees = sc.nextInt();


            for (int i = 0; i < numberOfEmployees; i++) {
                addEmployee();
                error2 = false;
            }
        } catch (InputMismatchException e) {
            System.err.println("Nie dokonano poprawnego wyboru, spróbuj ponownie.");
            sc.nextLine();
            error2 = true;
        }
    }while (error2);
}


   private void addEmployee() {
       boolean error = false;
       do {
           try {
               printer("Podaj rodzaj zatrudnienia pracownika: 1 dla UoP oraz 2 dla UZ: ");
               int choice = sc.nextInt();
               sc.nextLine();
               printer("Imię pracownika: ");
               String name = sc.nextLine();
               printer("Nazwisko pracownika: ");
               String lastName = sc.nextLine();
               if (choice == 1) {
                   printer("Pensja pracownika: ");
                   double salary = sc.nextDouble();
                   employees[employeesNUmber] = new FullTimeEmployee(name, lastName, salary);
                   employeesNUmber++;
                   error = false;
               }
               if (choice == 2) {
                   printer("Podaj stawkę godzinową pracownika: ");
                   double wage = sc.nextDouble();
                   printer("Podaj ilość przepracowanych godzin: ");
                   double workedHours = sc.nextDouble();
                   employees[employeesNUmber] = new PartTimeEmployee(name, lastName, wage, workedHours);
                   employeesNUmber++;
                   error = false;
               }
           } catch (InputMismatchException e) {
               System.err.println("Podano błędną daną, spróbuj ponownie: ");
               sc.nextLine();
               error = true;
           }
       } while (error);
   }

   public void printEmployees () {
       for (int i = 0; i < employeesNUmber; i++) {
           printer(employees[i].toString());
       }
   }

   private double getTotalMonthlyCost(){
    double totalMonthSalary = 0;
       for (int i = 0; i < employeesNUmber; i++) {
           totalMonthSalary += employees[i].calculateMonthSalary();
       }
       return  totalMonthSalary;
   }
   private  double getTotalYearlyCost(){
    double totalYearSalary=0;
    for (int i = 0; i< employeesNUmber; i++){
        totalYearSalary += employees[i].calculateYearSalary();
    }
    return totalYearSalary;
   }


    public String getTotalCosts() {
        return "Miesięczny koszt wypłat: " + getTotalMonthlyCost() + ",\n Roczny koszt wypłąt: " + getTotalYearlyCost();
    }
}
