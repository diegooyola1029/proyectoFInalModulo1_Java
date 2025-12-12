import java.util.Scanner;

public class App {

    static String nombre = "N/A";
    static double nota1 = -1, nota2 = -1, nota3 = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero(sc, "Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    registrarEstudiante(sc);
                    break;

                case 2:
                    mostrarDatos();
                    break;

                case 3:
                    calcularPromedio();
                    break;

                case 4:
                    mostrarResumen();
                    break;

                case 5:
                    limpiarDatos();
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }

    static void mostrarMenu() {
        System.out.println("\n--- Menú de Gestión de Estudiantes ---");
        System.out.println("1. Registrar datos de un estudiante");
        System.out.println("2. Mostrar datos del estudiante actual");
        System.out.println("3. Calcular promedio de notas");
        System.out.println("4. Mostrar resumen completo del estudiante");
        System.out.println("5. Limpiar datos del estudiante actual");
        System.out.println("0. Salir");
    }

    static int leerEntero(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Ingrese un número válido: ");
        }
        return sc.nextInt();
    }

    static void registrarEstudiante(Scanner sc) {
        sc.nextLine(); // limpiar buffer

        System.out.print("Ingrese el nombre del estudiante: ");
        nombre = sc.nextLine();

        nota1 = leerNota(sc, "Ingrese la nota 1: ");
        nota2 = leerNota(sc, "Ingrese la nota 2: ");
        nota3 = leerNota(sc, "Ingrese la nota 3: ");

        System.out.println("Datos del estudiante registrados correctamente.");
    }

    static double leerNota(Scanner sc, String mensaje) {
        double nota;
        System.out.print(mensaje);

        while (true) {
            String linea = sc.nextLine().replace(",", ".");

            try {
                nota = Double.parseDouble(linea);
                if (nota < 0 || nota > 10) {
                    System.out.print("La nota debe estar entre 0 y 10. Ingrese nuevamente: ");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.print("Nota inválida. Ingrese nuevamente: ");
            }
        }

        return nota;
    }

    static void mostrarDatos() {
        System.out.println("\n--- Datos del Estudiante ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Nota 1: " + nota1);
        System.out.println("Nota 2: " + nota2);
        System.out.println("Nota 3: " + nota3);
    }

    static void calcularPromedio() {
        if (nota1 < 0 || nota2 < 0 || nota3 < 0) {
            System.out.println("Debe registrar las notas primero.");
            return;
        }
        double promedio = (nota1 + nota2 + nota3) / 3;
        System.out.println("Promedio: " + promedio);
    }

    static void mostrarResumen() {
        System.out.println("\n--- Resumen Completo ---");
        mostrarDatos();
        calcularPromedio();
    }

    static void limpiarDatos() {
        nombre = "N/A";
        nota1 = nota2 = nota3 = -1;
        System.out.println("Datos del estudiante limpiados.");
    }
}
