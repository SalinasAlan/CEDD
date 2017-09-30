/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.recursividad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Salinas
 */
public class Prb
{

    int arr[];

    public static void main(String[] args) throws IOException
    {

        Recursividad r = new Recursividad();
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        int ops;
        do
        {
            System.out.println("*********MENU*********"
                    + "\n 1. Factorial"
                    + "\n 2. Potencia"
                    + "\n 3. Busqueda de posición"
                    + "\n 4. Suma de numeros en arreglo"
                    + "\n 5. Salir");
            ops = Integer.parseInt(leer.readLine());

            switch (ops)
            {
                case 1:
                    System.out.println("Ingrese un número");
                    int op = Integer.parseInt(leer.readLine());
                    System.out.println("FI: " + r.factorialI(op));
                    System.out.println("FR: " + r.factorialR(op));
                    break;
                case 2:
                    System.out.println("Ingrese un número");
                    int op2 = Integer.parseInt(leer.readLine());
                    System.out.println("Ingresa la potencia");
                    int op3 = Integer.parseInt(leer.readLine());
                    System.out.println("PI: " + r.potenciaI(op2, op3));
                    System.out.println("PR: " + r.potenciaR(op2, op3));
                    break;
                case 3:
                    System.out.println("Ingrese el tamaño del arreglo");
                    int tam = Integer.parseInt(leer.readLine());
                    int arr[] = new int[tam];

                    if (tam != 0)
                    {
                        System.out.println("Ingrese los números");

                        llenado(arr);

                        System.out.println("Que número desea buscar");
                        int nb = Integer.parseInt(leer.readLine());

                        if (r.busquedaAI(arr, nb) != -1)
                        {
                            System.out.println("BI: El número " + nb + " esta en: " + r.busquedaAI(arr, nb));
                        } else
                        {
                            System.out.println("BI: El número " + nb + " no esta en el arreglo");
                        }

                        if (r.busquedaAR(arr, nb, 0) != arr.length)
                        {
                            System.out.println("BR: El número " + nb + " esta en: " + r.busquedaAR(arr, nb, 0));
                        } else
                        {
                            System.out.println("BR: El número " + nb + " no esta en el arreglo");

                        }
                    } else
                    {
                        System.out.println("El arreglo esta vacio");
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el tamaño del arreglo");
                    int tamS = Integer.parseInt(leer.readLine());
                    int arrS[] = new int[tamS];

                    if (tamS != 0)
                    {
                        System.out.println("Ingrese los números");
                        llenado(arrS);
                        System.out.println("SI: La suma es: " + r.sumaI(arrS));
                        System.out.println("SR: La suma es: " + r.sumaR(arrS, tamS - 1));
                    } else
                    {
                        System.out.println("No hay datos en el arreglo");
                    }
                    break;
                case 5:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (ops != 5);
    }

    public static void llenado(int arr[]) throws IOException
    {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < arr.length; i++)
        {
            int n = Integer.parseInt(leer.readLine());
            arr[i] = n;
        }
    }
}
