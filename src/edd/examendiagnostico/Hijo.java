/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.examendiagnostico;

/**
 *
 * @author Salinas
 */
public class Hijo extends Padre
{

    public Hijo(int n)
    {
        super(n);
    }

    public void cubo()
    {
        int aux;
        for (int i = 0; i < arr.length; i++)
        {
            aux = arr[i];
            arr[i] = aux * aux * aux;
        }
    }    
    
}
