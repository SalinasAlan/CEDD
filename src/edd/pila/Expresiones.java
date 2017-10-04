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

    public void pos(char arr[])
    {
        Pila op = new Pila(arr);
        Pila var = new Pila(arr);

        for (int i = 0; i < arr.length; i++)
        {
            //Ingresa las variables
            if (arr[i] > 'a' || arr[i] < 'z')
            {
                var.push(arr[i]);
            }
            //Ingresa la resta
            if (arr[i] == '-')
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
            //Ingresa la multiplicacion
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
                } else
                {
                    op.push(arr[i]);
                }
            }
            //Ingresa la división
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
            //Ingresa paréntesis inicial
            if (arr[i] == '(')
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
            //Ingresa paréntesis final
            if (arr[i] == ')')
            {
                if (!op.empty())
                {

                }
            }

        }

    }

}
