/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.cola;

/**
 *
 * @author Salinas
 */
public class ColaCircular
{
    
    private int mFrente;
    private int mFin;
    private String[] arr;
    
    public ColaCircular(int n)
    {
        this.mFrente = -1;
        this.mFin = -1;
        arr = new String[n];
    }

    /**
     * @return the mFrente
     */
    public int getmFrente()
    {
        return mFrente;
    }

    /**
     * @param mFrente the mFrente to set
     */
    public void setmFrente(int mFrente)
    {
        this.mFrente = mFrente;
    }

    /**
     * @return the mFin
     */
    public int getmFin()
    {
        return mFin;
    }

    /**
     * @param mFin the mFin to set
     */
    public void setmFin(int mFin)
    {
        this.mFin = mFin;
    }

    /**
     * @return the arr
     */
    public String[] getArr()
    {
        return arr;
    }

    /**
     * @param arr the arr to set
     */
    public void setArr(String[] arr)
    {
        this.arr = arr;
    }
    
    public boolean empty()
    {
        if (mFin == -1)
        {
            return true;
        } else
        {
            return false;
        }
    }
    
    public boolean full()
    {
        if (((mFin + 1 == arr.length) && (mFrente == 0)) || (mFin + 1 == mFrente))
        {
            return true;
        }else
        {
            return false;
        }
    }
    
    public void qInsert(String s)
    {
        if (empty())
        {
            mFin = mFrente = 0;
        } else if (mFin == arr.length - 1)
        {
            mFin = 0;
        } else
        {
            mFin++;
        }
        arr[mFin] = s;
    }
    
    public String qRemove()
    {
        String mCad = arr[mFrente];
        if (mFrente == mFin)
        {
            mFrente = mFin = -1;
        } else if (mFrente == arr.length - 1)
        {
            mFrente = 0;
        } else
        {
            mFrente++;
        }
        return mCad;
    }
    
}
