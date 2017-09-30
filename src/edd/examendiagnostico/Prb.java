/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.examendiagnostico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Salinas
 */
public class Prb
{

    public static void main(String[] args) throws IOException
    {
        try
        {
            BufferedReader l = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("¿Cual es la longitud del arreglo?");
            int longitud = Integer.parseInt(l.readLine());
            Hijo h = new Hijo(longitud);

            System.out.println("Ingrese los datos.");
            h.ingresar();
            
            int op;
            do
            {
                System.out.println("\n*********MENU*********");
                System.out.println("1. Desplegar");
                System.out.println("2. Cubo");
                System.out.println("3. Salir");
                op = Integer.parseInt(l.readLine());
                switch (op)
                {
                    case 1:
                        h.desp();
                        break;
                    case 2:
                        h.cubo();
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Opcion incorrecta!!");
                        break;
                }
            } while (op != 3);
        } catch (Exception e)
        {
            System.out.println("No se aceptan letras.");
        }

    }
}
