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
public class Expresiones
{

    /**
     * Método pos que ordena una exoresion en posfija a+b*c-d => abc*+d-
     *
     * @param s cadena tipo String que resive
     */
    public void pos(String s)
    {

        Pila operadores = new Pila(s.length());
        Pila variables = new Pila(s.length());
        Pila aux = new Pila(s.length());

        for (int i = 0; i < s.length(); i++)
        {
            if (Character.isLetter(s.charAt(i)))
            {
                variables.push(s.charAt(i));
                aux.push(s.charAt(i));
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
                            char mPop = operadores.pop();
                            variables.push(mPop);
                            aux.push(mPop);
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
                                    char mPop = operadores.pop();
                                    variables.push(mPop);
                                    aux.push(mPop);
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
                                    char mPop = operadores.pop();
                                    variables.push(mPop);
                                    aux.push(mPop);
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
                char mPop = operadores.pop();
                variables.push(mPop);
                aux.push(mPop);
            }
        }

        int mR = operacionesPos(s.length(), variables);
        System.out.println("El resultado es: " + mR);

        System.out.println("\nLa expresion postfija es: ");
        while (!aux.empty())
        {
            char mPop = aux.pop();
            System.out.println(mPop);
        }
    }

    public int operacionesPos(int mLength, Pila aux)
    {
        BufferedReader mL = new BufferedReader(new InputStreamReader(System.in));
        Pila mAux2 = new Pila(mLength);
        PilaNumerica mOperaciones = new PilaNumerica(mLength);

        do
        {
            mAux2.push(aux.pop());
        } while (!aux.empty());

        for (int i = 0; i < mLength; i++)
        {

            if (mAux2.getTope() != -1)
            {
                char mPop = mAux2.pop();
                int mAuxPopOP;
                int mResultado;
                if (Character.isLetter(mPop))
                {
                    try
                    {
                        System.out.println("¿Que valor numerico tiene: " + mPop + "?");
                        int mLeer = Integer.parseInt(mL.readLine());
                        mOperaciones.push(mLeer);
                    } catch (IOException ex)
                    {
                        System.out.println("No se aceptan letras");
                    }
                } else
                {
                    switch (mPop)
                    {
                        case '+':
                            mAuxPopOP = mOperaciones.pop();
                            mResultado = mOperaciones.pop() + mAuxPopOP;
                            mOperaciones.push(mResultado);
                            break;
                        case '-':
                            mAuxPopOP = mOperaciones.pop();
                            mResultado = mOperaciones.pop() - mAuxPopOP;
                            mOperaciones.push(mResultado);
                            break;
                        case '*':
                            mAuxPopOP = mOperaciones.pop();
                            mResultado = mOperaciones.pop() * mAuxPopOP;
                            mOperaciones.push(mResultado);
                            break;
                        case '/':
                            mAuxPopOP = mOperaciones.pop();
                            mResultado = mOperaciones.pop() / mAuxPopOP;
                            mOperaciones.push(mResultado);
                            break;
                    }
                }
            }
        }

        return mOperaciones.stackTop();
    }
}
