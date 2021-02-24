package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[] comisiones = new double[10];

        for (int i = 0; i < comisiones.length; i++) {
            System.out.println("Digite el valor de la comision del empleado " + i);
            comisiones[i] = scanner.nextDouble();
        }

        System.out.println("Opciones:");
        System.out.println("1. Mostrar cuántas comisiones de las almacenadas fueron iguales a una comisión leída por teclado");
        System.out.println("2. Actualizar las comisiones almacenadas, aumentándoles el 4% a los que son inferiores a medio millón y un 2% a los que son iguales o superiores");
        System.out.println("3. Obtener y mostrar cuál es la comisión más alta y cuántos empleados tuvieron esa comisión");
        System.out.println("4. Descontar de cada comisión un 10%. Dichas comisiones nuevas, después de descontar, se guardarán en otro vector en la misma posición y se mostrarán");
        System.out.println("5. Organice el vector original de comisiones de mayor a menor y muestre cuales son las 2 comisiones más bajas. No deberá realizar comparaciones innecesarias y tenga en cuenta que puede haber varios empleados con la misma comisión");
        System.out.println("6. Salir");

        System.out.println("Elija una opcion:");
        int opcion = scanner.nextInt();

        while (opcion != 6) {

            switch (opcion) {

                case 1 -> {

                    System.out.println("Digite la comision que desea saber cuantas veces fue almacenada:");
                    double comisionDigitada = scanner.nextDouble();

                    int cantidadComisionesIguales = 0;

                    for (int i = 0; i < comisiones.length; i++) {
                        if (comisiones[i] == comisionDigitada) {
                            cantidadComisionesIguales += 1;
                        }
                    }

                    System.out.println("De las comisiones almacenadas " + cantidadComisionesIguales + " fueron iguales a la comision leida por teclado");

                    System.out.println("---------------------------------------------------------------");

                }

                case 2 -> {

                    for (int i = 0; i < comisiones.length; i++) {

                        if (comisiones[i] < 500000) {
                            double cuatroPorciento = (comisiones[i] * 4) / 100;
                            comisiones[i] += cuatroPorciento;
                            // aumentando 4%
                        } else if (comisiones[i] >= 500000) {
                            double dosPorciento = (comisiones[i] * 2) / 100;
                            comisiones[i] += dosPorciento;
                            // aumentando 2%
                        }

                    }

                    System.out.println("Comisiones actualizadas:");
                    for (int i = 0; i < comisiones.length; i++) {
                        System.out.println("Empleado #" + i + ": " + comisiones[i]);
                    }

                    System.out.println("---------------------------------------------------------------");

                }

                case 3 -> {

                    for (int recorrido = 0; recorrido < comisiones.length - 1; recorrido++) {
                        for (int elemento = 0; elemento < comisiones.length - 1; elemento++) {
                            if (comisiones[elemento] > comisiones[elemento + 1]) {
                                double t = comisiones[elemento];
                                comisiones[elemento] = comisiones[elemento + 1];
                                comisiones[elemento + 1] = t;
                            }
                        }
                    }

                    double comisionMasAlta = comisiones[comisiones.length - 1];

                    int cantidadEmpleadosComisionAlta = 0;

                    for (int i = 0; i < comisiones.length; i++) {
                        if (comisiones[i] == comisionMasAlta) {
                            cantidadEmpleadosComisionAlta += 1;
                        }
                    }

                    System.out.println("La comision mas alta es " + comisionMasAlta + " y la cantidad de empleados que tuvieron esa comision es " + cantidadEmpleadosComisionAlta);

                    System.out.println("---------------------------------------------------------------");

                }

                case 4 -> {

                    double[] nuevoVectorComisiones = new double[comisiones.length];

                    for (int i = 0; i < comisiones.length; i++) {
                        double diezPorciento = (comisiones[i] * 10) / 100;
                        nuevoVectorComisiones[i] = comisiones[i] - diezPorciento;
                    }

                    System.out.println("Nuevo vector con los descuentos del 10%:");
                    for (int i = 0; i < nuevoVectorComisiones.length; i++) {
                        System.out.println("Empleado #" + i + ": " + nuevoVectorComisiones[i]);
                    }

                    System.out.println("---------------------------------------------------------------");

                }

                case 5 -> {

                    for (int recorrido = comisiones.length - 1; recorrido > 0; recorrido--) {
                        for (int elemento = comisiones.length - 1; elemento > 0; elemento--) {
                            if (comisiones[elemento] > comisiones[elemento - 1]) {
                                double t = comisiones[elemento];
                                comisiones[elemento] = comisiones[elemento - 1];
                                comisiones[elemento - 1] = t;
                            }
                        }
                    }

                    double comisionMasBaja1 = comisiones[comisiones.length - 1];
                    double comisionMasBaja2 = 0;

                    for (int i = comisiones.length - 1; i < comisiones.length; i--) {
                        if (comisiones[i] != comisiones[i - 1]) {
                            comisionMasBaja2 = comisiones[i - 1];
                            break;
                        }
                    }

                    System.out.println("Las dos comisiones mas bajas son " + comisionMasBaja1 + " y " + comisionMasBaja2);

                    System.out.println("---------------------------------------------------------------");

                }

            }

            System.out.println("Elija una opcion:");
            opcion = scanner.nextInt();

        }

        scanner.close();

    }

}
