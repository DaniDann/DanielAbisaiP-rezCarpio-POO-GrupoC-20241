import java.util.Scanner;

public class Cuadrado extends Shape {

    double ladoCuadrado;

    public Cuadrado (double ladoCuadrado) {
        this.ladoCuadrado = ladoCuadrado;
    }

    @Override
    public double calcularArea() {
        return ladoCuadrado * ladoCuadrado;
    }

    @Override
    public double calcularPerimetro(){
        return ladoCuadrado * 4;


    }

    public double getLadoCuadrado() {
        return ladoCuadrado;
    }
}
