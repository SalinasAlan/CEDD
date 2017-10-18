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
public class Alumno
{

    private String mNombre;
    private int mProm;
    private int mNoControl;
    private Alumno mSig;

    public Alumno(String mNombre, int mProm, int mNoControl)
    {
        this.mNombre = mNombre;
        this.mProm = mProm;
        this.mNoControl = mNoControl;
        this.mSig = null;
    }

    /**
     * @return the mNombre
     */
    public String getmNombre()
    {
        return mNombre;
    }

    /**
     * @param mNombre the mNombre to set
     */
    public void setmNombre(String mNombre)
    {
        this.mNombre = mNombre;
    }

    /**
     * @return the mProm
     */
    public int getmProm()
    {
        return mProm;
    }

    /**
     * @param mProm the mProm to set
     */
    public void setmProm(int mProm)
    {
        this.mProm = mProm;
    }

    /**
     * @return the mNoControl
     */
    public int getmNoControl()
    {
        return mNoControl;
    }

    /**
     * @param mNoControl the mNoControl to set
     */
    public void setmNoControl(int mNoControl)
    {
        this.mNoControl = mNoControl;
    }

    /**
     * @return the mSig
     */
    public Alumno getmSig()
    {
        return mSig;
    }

    /**
     * @param mSig the mSig to set
     */
    public void setmSig(Alumno mSig)
    {
        this.mSig = mSig;
    }

}
