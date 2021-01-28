package com.ns.WeatherAppication.service;

public class Singleton {
    private static Singleton abc=null;
    public static Singleton getInstance()
    {
        if(abc==null)
            abc=new Singleton();
        return abc;
    }
}
class A
{
    Singleton s=Singleton.getInstance();
}
class B
{
    Singleton b=new Singleton();
}