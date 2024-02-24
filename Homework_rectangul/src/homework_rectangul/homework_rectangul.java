package homework_rectangul;

import clase.rectangulo.Rectangulo;


public class homework_rectangul {

   
    public static void main(String[] args) {

        Rectangulo rectangulo = new Rectangulo(34.5, 48.7);
        

        System.out.println("Area del rectangulo : " + rectangulo.calcularArea());
        
        System.out.println("Perimetro del rectangulo : " + rectangulo.calcularPerimetro());
    }
}