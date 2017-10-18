/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.listas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Salinas
 */
public class PrbLista
{

    public static void main(String[] args) throws IOException
    {
        BufferedReader mLeer = new BufferedReader(new InputStreamReader(System.in));
        Lista mLista = new Lista();
        int op;
        do
        {
            System.out.println("\n1. Insertar"
                    + "\n2. Eliminar"
                    + "\n3. Desplegar"
                    + "\n4. Salir");
            op = Integer.parseInt(mLeer.readLine());
            switch (op)
            {
                case 1:
                    System.out.println("\nIngrese el nombre del Alumno");
                    String mNombre = mLeer.readLine();
                    System.out.println("Ingrese el promedio");
                    int mProm = Integer.parseInt(mLeer.readLine());
                    System.out.println("Ingrese el numero de control");
                    int mNoControl = Integer.parseInt(mLeer.readLine());
                    Alumno mAlumno = new Alumno(mNombre, mProm, mNoControl);
                    mLista.push(mAlumno);
                    break;
                case 2:
                    if (!mLista.empty())
                    {
                        Alumno mPop = mLista.pop();
                        String mAuxN = mPop.getmNombre();
                        int mAuxP = mPop.getmProm();
                        System.out.println("\nEl alumno eliminado es: " + mAuxN
                                + "\nPromedio: " + mAuxP);
                    } else
                    {
                        System.out.println("\nNo hay Alumnos");
                    }
                    break;
                case 3:
                    if (!mLista.empty())
                    {
                        mLista.dep();
                    } else
                    {
                        System.out.println("\nNo hay Alumnos");
                    }
                    break;
                case 4:
                    System.out.println("\nAdios");
                    break;
                default:
                    System.out.println("\nOpcion no valida");
                    break;
            }
        } while (op != 4);

    }
}
