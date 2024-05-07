public class Main {

    public static void main(String[] args) {
        try {
            // NullPointerException
            String s = null;
            System.out.println(s.length()); // Rayo McQueen sin ruedas.
        } catch (NullPointerException e) {
            System.out.println("Error: Se intentó acceder a un objeto que es null.");
            e.printStackTrace();
        }

        try {
            // ArrayIndexOutOfBoundsException
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]); // Intentando acceder a un elemento más allá del tamaño del array.
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Se intentó acceder a un índice fuera del rango de un array.");
            e.printStackTrace();
        }

        try {
            //  ArithmeticException
            int result = 10 / 0; // División entre cero. Randy Orton tratando de dividir por 0, imposible.
        } catch (ArithmeticException e) {
            System.out.println("Error: Se intentó realizar una operación aritmética ilegal.");
            e.printStackTrace();
        }

        try {
            //  IllegalArgumentException
            int age = -5;
            if (age < 0 || age > 150) {
                throw new IllegalArgumentException("Edad inválida"); // Intentando ingresar una edad negativa o mayor a 150 años.
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Se pasó un argumento ilegal a un método.");
            e.printStackTrace();
        }

        try {
            //  NumberFormatException
            String numStr = "abc";
            int num = Integer.parseInt(numStr); // Convertir una cadena no numérica a un número.
        } catch (NumberFormatException e) {
            System.out.println("Error: No se pudo convertir la cadena a un formato numérico.");
            e.printStackTrace();
        }

        try {
            //  FileNotFoundException
            java.io.FileInputStream fis = new java.io.FileInputStream("archivo.txt"); // Intentando abrir un archivo que no existe.
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Error: No se encontró el archivo especificado.");
            e.printStackTrace();
        }

        try {
            //  IOException
            java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader("archivo.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (java.io.IOException e) {
            System.out.println("Error de entrada/salida al leer el archivo.");
            e.printStackTrace();
        }

        try {
            //  InterruptedException
            Thread.sleep(1000); // Interrupción mientras se espera.
        } catch (InterruptedException e) {
            System.out.println("Error: Se interrumpió el hilo mientras estaba en espera.");
            e.printStackTrace();
        }

        try {
            //  StackOverflowError
            recursiveMethod(); // Método recursivo sin caso base.
        } catch (StackOverflowError e) {
            System.out.println("Error: Se excedió el límite de profundidad de la pila de llamadas.");
            e.printStackTrace();
        }
    }

    // Método recursivo que eventualmente causa un StackOverflowError
    public static void recursiveMethod() {
        recursiveMethod();
    }
}

