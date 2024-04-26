import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner red = new Scanner(System.in);

        //Rectangulo
        System.out.println("ingresa la base del rectangulo");
        double baseRectangulo = red.nextDouble();
        System.out.println("ingresa la altura del rectangulo");
        double alturaRectanglo = red.nextDouble();
        Rectangulo rectangulo = new Rectangulo(baseRectangulo, alturaRectanglo );

        //Triangulo
        System.out.println("Ingresa el primer lado del triángulo:");
        double lado1 = red.nextDouble();
        System.out.println("Ingresa el segundo lado del triángulo:");
        double lado2 = red.nextDouble();
        System.out.println("Ingresa el tercer lado del triángulo:");
        double lado3 = red.nextDouble();
        Triangulo triangulo = new Triangulo(lado1, lado2, lado3);

        //Cuadrado
        System.out.println("Ingresa el lado de tu cuadrado: ");
        double ladoCuadrado = red.nextDouble();
        Cuadrado cuadrado = new Cuadrado(ladoCuadrado);

        System.out.println("Ingresa el radio del Circulo: ");
        double radio = red.nextDouble();
        Circulo circulo = new Circulo(radio);

    }
}