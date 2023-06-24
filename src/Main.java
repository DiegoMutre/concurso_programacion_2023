import java.util.ArrayList;
import java.util.Scanner;

// Coordinador Academico
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Numero total de estudiantes nuevos");

        int numeroTotalEstudiantesNuevos = scanner.nextInt();

        while (numeroTotalEstudiantesNuevos > 300) {
            System.out.println("Numero total de estudiantes nuevos (maximo 300)");
            numeroTotalEstudiantesNuevos = scanner.nextInt();
        }

        ArrayList<Integer> paralelos = asignarParalelo(numeroTotalEstudiantesNuevos);
        ArrayList<Paralelo> paralelosOrdenados = ordenarParalelos(paralelos);
        mostrarMateriasPorParalelo(paralelosOrdenados);
    }

    static ArrayList<Integer> asignarParalelo(int estudiantes) {
        ArrayList<Integer> paralelos = new ArrayList<>();

        if (estudiantes <= 100) {
            while (estudiantes != 0) {
                if (estudiantes < 30) {
                    paralelos.add(estudiantes);
                    estudiantes = 0;
                    break;
                }

                estudiantes -= 30;
                paralelos.add(30);
            }
        }

        if (estudiantes <= 200) {
            while (estudiantes != 0) {
                if (estudiantes < 50) {
                    paralelos.add(estudiantes);
                    estudiantes = 0;
                    break;
                }

                estudiantes -= 50;
                paralelos.add(50);
            }
        }

        if (estudiantes <= 300) {
            while (estudiantes != 0) {
                if (estudiantes < 75) {
                    paralelos.add(estudiantes);
                    estudiantes = 0;
                    break;
                }

                estudiantes -= 75;
                paralelos.add(75);
            }
        }
        return paralelos;
    }

    static ArrayList<Paralelo> ordenarParalelos(ArrayList<Integer> paralelos) {
        ArrayList<Paralelo> paralelosOrdenados = new ArrayList<>();

        for (int i = 0; i < paralelos.size(); i++) {
            Paralelo paraleloObject = new Paralelo();
            paraleloObject.numero = i;
            paraleloObject.totalEstudiantes = paralelos.get(i);
            paralelosOrdenados.add(paraleloObject);
        }

        return paralelosOrdenados;
    }

    static void mostrarMateriasPorParalelo(ArrayList<Paralelo> paralelos) {
        String[] materias = new String[]{"Calculo Diferencial", "Fisica", "Tecnicas de Comunicacion oral y escrita",
                "Etica y Responsabilidad social", "Derecho Constitucional", "Herramientas Digitales y colaborativas"
        };
        System.out.printf("%-50s %-50s %-50s\n", "Materia", "Paralelo", "Grupo Estudiantes");
        System.out.println("------------------------------------------------------------------------------------");

        for (Paralelo paralelo : paralelos) {
            String paraleloAcronimo = "P" + (paralelo.numero + 1);
            String grupoEstudiante = "G" + (paralelo.numero + 1) + "-" + paralelo.totalEstudiantes;

            for (String materia : materias) {
                System.out.printf("%-50s %-50s %-50s\n", materia, paraleloAcronimo, grupoEstudiante);
            }

            System.out.println("-----------------------------");
        }
    }

    static class Paralelo {
        int numero;
        int totalEstudiantes;
    }
}