import java.util.Scanner;

public class App {

static String nombre = "N/A", estado = "N/A";
static double nota1 = -1, nota2 = -1, nota3 = -1;
static double promedio = 0;

    public static void main(String[] args) throws Exception {
    
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero(sc, "\nSeleccione una opción: ");
        
            switch (opcion) {
                case 1:
                    // ToDo: Registrar datos de un estudiante
                    registrarEstudiante(sc);
                    break;
                case 2:
                    // ToDo: Mostrar datos del estudiante actual
                    mostrarEstudiante();
                    break;
                case 3:
                    // ToDo: Calcular promedio de notas
                    calcularPromedio();
                    break;
                case 4:
                    //ToDo: Mostrar resumen completo del estudiante
                    mostrarEstudiante();
                    System.out.printf("Promedio: %.2f%n", promedio);
                    setEstado();
                    break;
                case 5:
                    // ToDo: Limpiar datos del estudiante actual
                    nombre = "N/A";
                    nota1 = -1;
                    nota2 = -1;
                    nota3 = -1;
                    promedio = 0;
                    estado = "N/A";
                    System.out.println("Estado: " + estado);
                    break;
                case 0:
                    // ToDo: Salir
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        
        } while (opcion != 0);
          sc.close();    
    }

    static void mostrarMenu() {
        System.out.println("\n----- Menú de opciones: -----\n");
        System.out.println("1. Registrar datos de un estudiante");
        System.out.println("2. Mostrar datos del estudiante actual");
        System.out.println("3. Calcular promedio de notas");
        System.out.println("4. Mostrar resumen completo del estudiante");
        System.out.println("5. Limpiar datos del estudiante actual");
        System.out.println("0. Salir");
        

    }

    static int leerEntero(Scanner sc, String mensaje) {
       int numero;
       System.out.print(mensaje);
       numero = sc.nextInt();
       sc.nextLine(); // Limpiar el buffer
       return numero;
    }

    static void registrarEstudiante(Scanner sc) {
        nombre = validarNombre(sc);
        
        nota1 = leerNota(sc, "Ingrese la nota 1: ");
        nota2 = leerNota(sc, "Ingrese la nota 2: ");
        nota3 = leerNota(sc, "Ingrese la nota 3: ");
        System.out.println("\nDatos del Estudiante registrados exitosamente.");
        System.out.println("-----------------------------");

          
    }
    static double leerNota(Scanner sc, String mensaje) {
        double nota;
        while (true) {
            System.out.print(mensaje);
            String linea = sc.nextLine().replace("," , ".");
            nota = Double.parseDouble(linea);
            if (validarNota(nota)) {
                break;
            }else {
                System.out.println("Nota inválida. Debe estar entre 0 y 100.");
            }   
        }
        return nota;        
    }

    static void mostrarEstudiante() {
      if (nombre.equals("N/A")) {
        System.out.println("No hay datos de estudiante registrados.");
      } else {
        System.out.println("Nombre del estudiante: " + nombre);
        System.out.println("Nota 1: " + nota1);
        System.out.println("Nota 2: " + nota2);
        System.out.println("Nota 3: " + nota3);
      }
    }

    static boolean validarNota(double nota) {
        return nota >= 0 && nota <= 100;
    }

    static void calcularPromedio() {
        if (nombre.equals("N/A")) {
            System.out.println("No hay datos de estudiante registrados.");
        } else {
            promedio = (nota1 + nota2 + nota3) / 3;
            System.out.printf("Promedio: %.2f%n", promedio);
        }
    }

    static void setEstado() {
        estado = (promedio >= 60) ? "Aprobado" : "Reprobado";

    }

    static String validarNombre(Scanner sc) {
        String nombreInput;
        while (true) {
            System.out.print("Ingrese el nombre del estudiante: ");
            nombreInput = sc.nextLine().trim();
            if (!nombreInput.isEmpty()) {
                break;
            } else {
                System.out.println("El nombre no puede estar vacío. Ingrese el nombre de nuevo.");
            }
        }
        return nombreInput;
    }
}

