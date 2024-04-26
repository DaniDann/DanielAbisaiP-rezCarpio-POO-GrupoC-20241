import java.util.Scanner;

public class Rectangulo extends Shape {
    Scanner red =  new Scanner(System.in);



    double base;
    double altura;

   public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double calcularArea() {
        return base * altura;
    }


    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }

    public double getAltura() {
        return altura;
    }

    public double getBase() {
        return base;
    }

}