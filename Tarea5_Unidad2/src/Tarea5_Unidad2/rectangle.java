package Tarea5_Unidad2;

public class rectangle {

        String area (double base, double altura) {
        double area = base * altura;
        return String.format("\nArea double \nBase: " + base + "\nAltura: " + altura + "\nArea: " + area);
    }

        String area (int base, int altura) {
        int area = base * altura;
        return String.format("\nArea int \nBase: " + base + "\nAltura: " + altura + "\nArea: " + area);
    }

        String perimeter (double base, double altura) {
        double perimeter = (2 * base) + (2 * altura);
        return String.format("\n Perimeter double \nBase: " + base + "\nAltura: " + altura + "\nPerimeter: " + perimeter);
    }

        String perimeter (int base, int altura) {
        int perimeter = (2 * base) + (2 * altura);
        return String.format("\nPerimeter int \nBase: " + base + "\nAltura: " + altura + "\nPerimeter: " + perimeter);
    }

        public static void getRectangleInfo(){
        rectangle rectangle = new rectangle();

        System.out.println("\nClass Rectangle");
        System.out.println(rectangle.area(37, 28));
        System.out.println(rectangle.area(13.98, 67.93));
        System.out.println(rectangle.perimeter(30, 76));
        System.out.println(rectangle.perimeter(17.65, 46.38));
    }
}