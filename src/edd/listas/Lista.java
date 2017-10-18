/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.listas;

/**
 *
 * @author Salinas
 */
public class Lista //se comporta como una Pila
{

    private Alumno mTope;

    public boolean empty()
    {
        return mTope == null;
    }

    public void push(Alumno mObjA)
    {
        if (empty())
        {
            mTope = mObjA;
        } else
        {
            mObjA.setmSig(mTope);
            mTope = mObjA;
        }
    }

    public Alumno pop()
    {
        Alumno mAux = mTope;
        mTope = mTope.getmSig();
        return mAux;
    }

    public void dep()
    {
        Alumno mAux = mTope;
        while (mAux != null)
        {
            System.out.println("\nEl nombre es: " + mAux.getmNombre());
            System.out.println("El promedio es: " + mAux.getmProm());
            System.out.println("El No. de control es: " + mAux.getmNoControl());
            mAux = mAux.getmSig();
        }
    }
}
