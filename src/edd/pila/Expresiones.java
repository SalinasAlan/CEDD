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
    public char[] pos(char arr[])
    {
        Pila op = new Pila(arr.length);
        Pila var = new Pila(arr.length);

        for (int i = 0; i < arr.length; i++)
        {
            //Ingresa la suma.
            if (arr[i] == '+')
            {
                if (!op.empty())
                {
                    if (op.stackTop() == '*' || op.stackTop() == '/' || op.stackTop() == '-' || op.stackTop() == '+')
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
            //Ingresa la resta.
            if (arr[i] == '-')
            {
                if (!op.empty())
                {
                    if (op.stackTop() == '*' || op.stackTop() == '/' || op.stackTop() == '-' || op.stackTop() == '+')
                    {
                        var.push(op.pop());
                        op.push(arr[i]);
                    }
                    if (op.stackTop() == (char) 40)
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
                    if (op.stackTop() == '*' || op.stackTop() == '/' || op.stackTop() == (char) 40)
                    {
                        op.push(arr[i]);
                    }
                    if (op.stackTop() == '-' || op.stackTop() == '+')
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
                    if (op.stackTop() == '*' || op.stackTop() == '/' || op.stackTop() == (char) 40)
                    {
                        var.push(op.pop());
                        op.push(arr[i]);
                    }
                    if (op.stackTop() == '-' || op.stackTop() == '+')
                    {
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
        return var.getArr();
    }

    
    
    
    
    /**
     *
     * @param s
     */
    public char[] pos2(String s)
    {
        Pila operadores = new Pila(s.length());
        Pila variables = new Pila(s.length());

        for (int i = 0; i < s.length(); i++)
        {
            if (Character.isLetter(s.charAt(i)))
            {
                variables.push(s.charAt(i));
            } else if (!operadores.empty())
            {
                switch (s.charAt(i))
                {
                    case (char) 40:
                        if (operadores.stackTop() == '*' || operadores.stackTop() == '/')
                        {
                            variables.push(operadores.pop());
                            operadores.push(s.charAt(i));
                        } else
                        {
                            operadores.push(s.charAt(i));
                        }
                        break;
                    case (char) 41:
                        operadores.push(s.charAt(i));
                        break;
                    case '+':
                    case '-':
                        if (operadores.stackTop() == '*' || operadores.stackTop() == '/' || operadores.stackTop() == '-' || operadores.stackTop() == '+')
                        {
                            variables.push(operadores.pop());
                            operadores.push(s.charAt(i));
                        } else
                        {
                            operadores.push(s.charAt(i));
                        }
                        break;

                    case '/':
                    case '*':
                        if (operadores.stackTop() == '*' || operadores.stackTop() == '/' )
                        {
                            variables.push(operadores.pop());
                            operadores.push(s.charAt(i));
                        }
                        if (operadores.stackTop() == '-' || operadores.stackTop() == '+' || operadores.stackTop() == (char) 40)
                        {
                            operadores.push(s.charAt(i));
                        }
                        break;
                }
            } else
            {
                operadores.push(s.charAt(i));
            }
        }

        while (operadores.getTope() != -1)
        {
            if (operadores.stackTop() == (char) 40 || operadores.stackTop() == (char) 41)
            {
                operadores.pop();
            } else
            {
                variables.push(operadores.pop());
            }
        }
        
        return variables.getArr();
    }
}
