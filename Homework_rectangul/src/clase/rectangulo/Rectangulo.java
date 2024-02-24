package clase.rectangulo;


public class Rectangulo {
    double base;
    double altura;
    
    
    public Rectangulo(double ancho, double altura) {
        this.base = ancho;
        this.altura = altura;
    }
    
    public double calcularArea() {
        return base * altura;
    }
    
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }
}