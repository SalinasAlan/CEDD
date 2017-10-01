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
        BufferedReader l = new BufferedReader(new InputStreamReader(System.in));
        Expresiones e = new Expresiones();
        System.out.println("Ingrese el tamaño del arreglo");
        int tam = Integer.parseInt(l.readLine());
        
    }
}
