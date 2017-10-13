/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.pila;

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
        BufferedReader mL = new BufferedReader(new InputStreamReader(System.in));
        Expresiones mE = new Expresiones();
        System.out.println("Ingrese la expresión");
        String mS = mL.readLine();

        System.out.println("\nLa expresion postfija es...");
        mE.pos(mS);
        System.out.println("");
//        mE.operaciones(mS.length());
        
    }
}
