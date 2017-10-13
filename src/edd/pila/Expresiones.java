/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.pila;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Salinas
 */
public class Expresiones
{

    private Pila aux;

    /**
     * Método pos que ordena una exoresion en posfija a+b*c-d => abc*+d-
     *
     * @param s cadena tipo String que resive
     */
    public void pos(String s)
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
                boolean mB = false;
                switch (s.charAt(i))
                {
                    case (char) 40:
                        operadores.push(s.charAt(i));
                        break;
                    case (char) 41:
                        while (operadores.stackTop() != '(')
                        {
                            variables.push(operadores.pop());
                        }
                        operadores.pop();
                        break;
                    case '+':
                    case '-':
                        do
                        {
                            if (!operadores.empty())
                            {
                                if (operadores.stackTop() == '*' || operadores.stackTop() == '/' || operadores.stackTop() == '-' || operadores.stackTop() == '+')
                                {
                                    variables.push(operadores.pop());
                                } else
                                {
                                    operadores.push(s.charAt(i));
                                    mB = true;
                                }
                            } else
                            {
                                operadores.push(s.charAt(i));
                                mB = true;
                            }
                        } while (mB == false);
                        break;
                    case '/':
                    case '*':
                        do
                        {
                            if (!operadores.empty())
                            {
                                if (operadores.stackTop() == '*' || operadores.stackTop() == '/')
                                {
                                    variables.push(operadores.pop());
                                }
                                if (operadores.empty() || operadores.stackTop() == '-' || operadores.stackTop() == '+' || operadores.stackTop() == (char) 40)
                                {
                                    operadores.push(s.charAt(i));
                                    mB = true;
                                }
                            } else
                            {
                                operadores.push(s.charAt(i));
                                mB = true;
                            }
                        } while (mB = false);
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

        aux = variables;

        System.out.println(variables.getArr());
    }

    public void operaciones(int lenght)
    {
        BufferedReader mL = new BufferedReader(new InputStreamReader(System.in));
        PilaNumerica operaciones = new PilaNumerica(lenght);
        do
        {
            operaciones.push(aux.pop());
        } while (!aux.empty());

    }
}
