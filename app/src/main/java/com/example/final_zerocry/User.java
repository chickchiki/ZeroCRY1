package com.example.final_zerocry;

public class User
{
    private String minfo;
    private String mrole;
    private String mes;

    public User(String i,String ro,String re)
    {
        minfo=i;
        mrole=ro;
        mes=re;
    }
    public String getinfo()
    {
        return minfo;
    }
    public String getrole()
    {
        return mrole;
    }
    public String getres()
    {
        return mes;
    }

}