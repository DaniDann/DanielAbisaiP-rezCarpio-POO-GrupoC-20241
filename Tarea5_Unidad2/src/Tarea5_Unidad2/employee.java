package Tarea5_Unidad2;

public class employee {

         String calculateSalary(double baseSalary){

        return String.format("\nBase salary\nSalary: " + baseSalary);
    }

          String calculateSalary(double baseSalary, double bonus){
        double total = baseSalary + bonus;
        return String.format("\nBase salary + Bonus\nSalary: " + baseSalary + "\nBonus: " + bonus + "\ntotal: " + total);
    }


         String calculateSalary(double baseSalary, double bonus, int extraHours){
        double total = baseSalary + bonus + (extraHours * 20);
        return String.format("\nBase salary + Bonnus + Extra hours\nSalary: " + baseSalary + "\nBonus: " + bonus +
                "\nExtra hours: "+ extraHours +"\ntotal: " + total);
    }

         public static void getEmployeeInfo(){
        employee employee = new employee();

        System.out.println("\n\nClass employee");
        System.out.println(employee.calculateSalary(312));
        System.out.println(employee.calculateSalary(312,45));
        System.out.println(employee.calculateSalary(312,45,6));
    }

}