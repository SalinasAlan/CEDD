/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.recursividad;

/**
 *
 * @author Salinas
 */
public class Recursividad
{

    public int factorialI(int n)
    {
        int aux = 1, aux2 = n;
        for (int i = 0; i < aux2; i++)
        {
            aux = aux * n;
            n--;
        }
        return aux;
    }

    public int factorialR(int n)
    {
        if (n == 0)
        {
            return 1;
        } else
        {
            return n * (factorialR(n - 1));
        }
    }

    public int potenciaI(int numero, int potencia)
    {
        int aux = 1;
        for (int i = 0; i < potencia; i++)
        {
            aux = aux * numero;
        }
        return aux;
    }

    public int potenciaR(int numero, int potencia)
    {
        if (potencia == 0)
        {
            return 1;
        } else
        {
            return numero * potenciaR(numero, potencia - 1);
        }
    }

    /**
     * Método iterativo que busca un número en un arreglo
     *
     * @param arr es el arreglo que se resive
     * @param n es el número por buscar en el arreglo
     * @return la casilla donde se encuentra el número solicitado y si no esta
     * regresa -1
     */
    public int busquedaAI(int arr[], int n)
    {
        int aux = -1;

        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == n)
            {
                aux = i;
            }

        }
        if (aux == -1)
        {
            return -1;
        }
        return aux;
    }

    public int busquedaAR(int arr[], int n, int i)
    {
        if (i >= arr.length || arr[i] == n)
        {
            return i;
        }
        return busquedaAR(arr, n, i + 1);
    }

    public int sumaI(int arr[])
    {
        int s = 0;
        for (int i = 0; i < arr.length; i++)
        {
            s += arr[i];
        }
        return s;
    }

    public int sumaR(int arr[], int i)
    {
        if (i == 0)
        {
            return arr[i];

        }
        return arr[i] + sumaR(arr, i - 1);
    }

//    public int invertir(int n)
//    {
//        if (n < 10)
//            return n;
//        return (n % 10) + invertir(n / 10);
//    }
}
