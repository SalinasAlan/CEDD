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
public class Expresiones
{

    /**
     * Método pos que convierte una expresión normal a una expresion pos.
     * a*b-(c+d) => ab*cd+-
     *
     * @param arr es un arreglo te tipo char.
     */
    public void pos(char arr[])
    {
        Pila op = new Pila(arr.length);
        Pila var = new Pila(arr.length);

        for (int i = 0; i < arr.length; i++)
        {
            //Ingresa la resta.
            if (arr[i] == '-')
            {
                if (!op.empty())
                {
                    if (op.stackTop() == '*')
                    {
                        var.push(op.pop());
                        op.push(arr[i]);
                    }
                    if (op.stackTop() == (char)40)
                    {
                        op.push(arr[i]);
                    }
                } else
                {
                    op.push(arr[i]);
                }
            }
            //Ingresa la multiplicacion.
            if (arr[i] == '*')
            {
                if (!op.empty())
                {
                    if (op.stackTop() == '-')
                    {
                        op.push(arr[i]);
                    }
                    if (op.stackTop() == '+')
                    {
                        op.push(arr[i]);
                    }
                    if (op.stackTop() == (char)40)
                    {
                        op.push(arr[i]);
                    }
                } else
                {
                    op.push(arr[i]);
                }
            }
            //Ingresa la división.
            if (arr[i] == '/')
            {
                if (!op.empty())
                {
                    if (op.stackTop() == '*')
                    {
                        var.push(op.pop());
                        op.push(arr[i]);
                    }
                } else
                {
                    op.push(arr[i]);
                }
            }
            //Ingresa paréntesis inicial.
            if (arr[i] == (char) 40)
            {
                if (!op.empty())
                {
                    if (op.stackTop() == '*')
                    {
                        var.push(op.pop());
                        op.push(arr[i]);
                    } else
                    {
                        op.push(arr[i]);
                    }
                } else
                {
                    op.push(arr[i]);
                }
            }
            //Ingresa paréntesis final.
            if (arr[i] == (char) 41)
            {
                op.push(arr[i]);
            }
            //Ingresa las variables.
            if (arr[i] >= (char) 97 && arr[i] <= (char) 122)
            {
                var.push(arr[i]);
            }
            //Ingresa la suma.
            if (arr[i] == '+')
            {
                if (!op.empty())
                {
                    if (op.stackTop() == '*')
                    {
                        var.push(op.pop());
                        op.push(arr[i]);
                    } else
                    {
                        op.push(arr[i]);
                    }
                } else
                {
                    op.push(arr[i]);
                }
            }
        }

        //Al finalizar la división de los términos, todo se pasa a la pila de las variables 
        //excepto los paréntesis.
        while (op.getTope() != -1)
        {
            if (op.stackTop() == (char) 40 || op.stackTop() == (char) 41)
            {
                op.pop();
            } else
            {
                var.push(op.pop());
            }
        } 
    }
}
