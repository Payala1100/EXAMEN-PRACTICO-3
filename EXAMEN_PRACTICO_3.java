/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EXAMEN_PRACTICO_3;

import java.util.Scanner;

/**
 *
 * @author Jose Antonio
 */

public class GestionCalificaciones {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numEstudiantes;
        do {
            System.out.print("Ingrese el número de estudiantes (mayor a 0): ");
            numEstudiantes = scanner.nextInt();
        } while (numEstudiantes <= 0);

        
        double[] calificaciones = new double[numEstudiantes];

        
        for (int i = 0; i < numEstudiantes; i++) {
            double calificacion;
            do {
                System.out.print("Ingrese la calificación del estudiante " + (i + 1) + " (entre 0 y 100): ");
                calificacion = scanner.nextDouble();
            } while (calificacion < 0 || calificacion > 100);
            calificaciones[i] = calificacion;
        }

        
        double promedio = calcularPromedio(calificaciones);
        int mayoresOIguales = contarCalificacionesMayores(calificaciones, promedio);
        double masAlta = obtenerCalificacionMasAlta(calificaciones);
        double masBaja = obtenerCalificacionMasBaja(calificaciones);

        System.out.println("\nResultados:");
        System.out.printf("Promedio de calificaciones: %.2f%n", promedio);
        System.out.println("Número de calificaciones mayores o iguales al promedio: " + mayoresOIguales);
        System.out.printf("Calificación más alta: %.2f%n", masAlta);
        System.out.printf("Calificación más baja: %.2f%n", masBaja);

        scanner.close();
    }

    
    public static double calcularPromedio(double[] calificaciones) {
        double suma = 0;
        for (double calificacion : calificaciones) {
            suma += calificacion;
        }
        return suma / calificaciones.length;
    }
    public static int contarCalificacionesMayores(double[] calificaciones, double promedio) {
        int contador = 0;
        for (double calificacion : calificaciones) {
            if (calificacion >= promedio) {
                contador++;
            }
        }
        return contador;
    }
        
    public static double obtenerCalificacionMasAlta(double[] calificaciones) {
        double max = calificaciones[0];
        for (double calificacion : calificaciones) {
            if (calificacion > max) {
                max = calificacion;
            }
        }
        return max;
    }
        
    public static double obtenerCalificacionMasBaja(double[] calificaciones) {
        double min = calificaciones[0];
        for (double calificacion : calificaciones) {
            if (calificacion < min) {
                min = calificacion;
            }
        }
        return min;
    }
}