public class Main {
    public static void main(String[] args) {


        Cuadrado cuadrado = new Cuadrado(40);
        System.out.println("Cuadrado:");
        System.out.println("Area del cuadrado: " + cuadrado.calcularArea());
        System.out.println("Perimetro del cuadrado : " + cuadrado.calcularPerimetro());

        Circulo circulo = new Circulo(19);
        System.out.println("\nCirculo:");
        System.out.println("Area del  circulo: " + circulo.calcularArea());
        System.out.println("Perimetro del circulo: " + circulo.calcularPerimetro());

        Rectangulo rectangulo = new Rectangulo(13, 18);
        System.out.println("\nRectangulo:");
        System.out.println("Area del rectangulo : " + rectangulo.calcularArea());
        System.out.println("Perimetro del rectaangulo: " + rectangulo.calcularPerimetro());

        Triangulo triangulo = new Triangulo(8, 8, 7);
        System.out.println("\nTriangulo:");
        System.out.println("Area del triangulo : " + triangulo.calcularArea());
        System.out.println("Perimetro del triangulo: " + triangulo.calcularPerimetro());
    }
}