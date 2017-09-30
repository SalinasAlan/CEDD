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
public class Padre
{

    protected int arr[];

    public Padre(int n)
    {
        arr = new int[n];
    }

    public Padre(int[] arr)
    {
        this.arr = arr;
    }

    /**
     * @return the arr
     */
    public int[] getArr()
    {
        return arr;
    }

    /**
     * @param arr the arr to set
     */
    public void setArr(int[] arr)
    {
        this.arr = arr;
    }

    public void ingresar() throws IOException
    {
        BufferedReader l = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < arr.length; i++)
        {
            int n = Integer.parseInt(l.readLine());
            arr[i] = n;
        }
    }

    public void desp()
    {
        System.out.println("");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }
}
