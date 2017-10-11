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

    public Pila(int n)
    {
        this.tope = -1;
        arr = new char[n];
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

    /**
     * @return the arr
     */
    public char[] getArr()
    {
        return arr;
    }

    /**
     * @param arr the arr to set
     */
    public void setArr(char[] arr)
    {
        this.arr = arr;
    }
        
    /**
     * Método empty.
     *
     * @return boolean, true si esta vacia y false si no lo está.
     */
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
     * Método pull.
     *
     * @return boolean, true si esta llena y false si no lo está.
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
     * Método stackTop.
     *
     * @return regresa un char, el valor del tope en la pila.
     */
    public char stackTop()
    {
        return arr[tope];
    }

    /**
     * Método push, ingresa datos a la pila.
     * @param c es el dato que se ingresara a la pila.
     * @return mensaje de sobre el estado de la acción.
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
     * Método pop, elimina elementos de la pila.
     *
     * @return un char que es el dato eliminado que está en tope.
     */
    public char pop()
    {
        return arr[tope--];
    }
}
