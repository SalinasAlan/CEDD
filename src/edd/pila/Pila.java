/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.pila;

/**
 *
 * @author Salinas
 */
public class Pila
{

    private int tope;
    private char arr[];

    public Pila(char[] arr)
    {
        this.tope = -1;
        this.arr = arr;
    }

    /**
     * @return the tope
     */
    public int getTope()
    {
        return tope;
    }

    /**
     * @param tope the tope to set
     */
    public void setTope(int tope)
    {
        this.tope = tope;
    }

    public boolean empty()
    {
        if (tope == -1)
        {
            return true;
        } else
        {
            return false;
        }
    }
    
    /**
     * Método pull
     * @return boolean 
     */
    public boolean full()
    {
        if (tope + 1 == arr.length)
        {
            return true;
        } else
        {
            return false;
        }
    }

    /**
     * Método stackTop
     * @return regresa un char, ultimo valor en la pila
     */
    public char stackTop()
    {
        if (empty() == true)
        {
            System.out.println("La pila esta vacia");
            return 0;
        } else
        {
            return arr[tope];
        }
    }

    /**
     * Método push, ingresa datos a la pila
     * @param c es el dato que se ingresara a la pila
     * @return un String acerca del estado de la operación en la pila
     */
    public String push(char c)
    {
        if (full())
        {
            return "La pila esta llena";
        } else
        {
            arr[++tope] = c;
            return "Dato insertado";
        }
    }

    /**
     * Método pop, elimina elementos de la pila
     *
     * @return un char que es el dato que esta en tope
     */
    public char pop()
    {
        if (empty())
        {
            return ' ';
        } else
        {
            return arr[tope--];
        }
    }
}
