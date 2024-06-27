package ejercicioaerolineas;

import java.util.Scanner;

public class EjercicioAerolineas {
    
    public static void main(String[] args) {
        // Creamos la matriz
        int vuelos[][] = new int[6][3];

        // Cargamos la matriz
        Scanner teclado = new Scanner(System.in);

        for (int f = 0; f < 6; f++) {
            for (int c = 0; c < 3; c++) {
                System.out.println("Ingrese la cantidad de asientos para el destino: " + f + ", horario: " + c);
                vuelos[f][c] = teclado.nextInt();
            }
        }

        // Imprimir matriz inicial
        System.out.println("Matriz inicial:");
        imprimirMatriz(vuelos);

        // Venta de asientos
        String bandera = "";
        int destino, horario, asientos;

        while (!bandera.equalsIgnoreCase("finish")) {
            System.out.println("Ingrese el n° de destino (0-5): ");
            destino = teclado.nextInt();

            // Verificar si el destino está fuera de rango
            if (destino < 0 || destino > 5) {
                System.out.println("Destino no disponible. Ingrese un destino válido (0-5).");
                continue; // Volver a solicitar los datos
            }

            System.out.println("Ingrese el horario del vuelo (0-2): ");
            horario = teclado.nextInt();

            // Verificar si el horario está fuera de rango
            if (horario < 0 || horario > 2) {
                System.out.println("Horario no existente. Ingrese un horario válido (0-2).");
                continue; // Volver a solicitar los datos
            }

            System.out.println("Ingrese la cantidad de asientos: ");
            asientos = teclado.nextInt();

            // Verificar si hay suficientes asientos
            if (vuelos[destino][horario] >= asientos) {
                System.out.println("Reserva Exitosa");
                // Actualizar número de asientos
                vuelos[destino][horario] -= asientos;
            } else {
                System.out.println("No hay asientos disponibles");
            }

            System.out.println("Desea continuar la reserva? Ingrese 'finish' para terminar o cualquier otro valor para seguir: ");
            bandera = teclado.next();
        }

        teclado.close();

        // Imprimir matriz actualizada
        System.out.println("Matriz actualizada:");
        imprimirMatriz(vuelos);
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }



}
