package Tarea5_Unidad2;

public class taxCalculator {

        String calculateTaxes(int income) {
        double taxes = income + 0.15;
        return String.format("\n income \nincome: " + income + "\ntaxes: " + taxes);
    }

        String calculateTaxes(double sales, double taxPercentage) {
        double taxes = sales * (taxPercentage / 100);
        return String.format("\nsale +Tax Percentage \nSales: " + sales +"\nTax Percentage: " + taxPercentage + "\nTaxes: " + taxes);
    }

        String calculateTaxes(double dividends, double taxPercentage, double exemption) {
        double taxes = dividends * (taxPercentage / 100);
        if (taxes > exemption) {

            return String.format("\nDividends+ tax parcentage + exeption - -\nDividends: " + dividends +
                    "\nTax Percentage: " + taxPercentage +"\nExemption: " + exemption + "\nTaxes: " + taxes);
          } else {
            return "\n tax calculator \n whitout taxes";
        }
    }

         public static void getTaxCalculatorInfo(){
        taxCalculator taxCalculator = new taxCalculator();

        System.out.println("\n\nClass tax Calculator");
        System.out.println(taxCalculator.calculateTaxes(290));
        System.out.println(taxCalculator.calculateTaxes(167, 263));
        System.out.println(taxCalculator.calculateTaxes(143, 175, 20));
    }

}