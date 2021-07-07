package ires.corso.partfour;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

class Vegetable {
    private String _name;
    private Float _weight;

    public Vegetable() {
    }

    public Vegetable(String name, Float weight) {
        _name = name;
        _weight = weight;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public Float getWeight() {
        return _weight;
    }

    public void setWeight(Float weight) {
        this._weight = weight;
    }

    public void greeting() {
        System.out.println("Ciao vegetables! Sono " + getName());
    }

    public void greetFriend(String friend) {
        System.out.println("Ciao caro amico vegetable " + friend + "! Sono sempre " + getName());
    }
}

public class BB210707
{
    public static void main(String[] args)
            throws NoSuchMethodException,
                    InstantiationException,
                    IllegalAccessException,
                    InvocationTargetException
    {
        Vegetable v = new Vegetable("carota", 1.0f);

        // In un altro punto del codice...

        Class vClass = v.getClass();
        System.out.println(vClass.getName());

        if (v.getClass() == Vegetable.class) {
            System.out.println("v è un'istanza della classe Vegetable");
        }

        Object obj = vClass.getConstructor().newInstance();
        Vegetable v2 = (Vegetable)obj;
        v2.setName("zucchina");
        v2.setWeight(2.0f);

        System.out.println("Nuovo vegetable: " + v2.getName());

        Method m1 = Vegetable.class.getMethod("greeting");
        Object res = m1.invoke(v2);
        res = m1.invoke(v);

        Method m2 = Vegetable.class.getMethod("greetFriend");
        res = m2.invoke(v2, "Stefano");
        res = m2.invoke(v, "Davide");

    }
}

class TestRunner implements Runnable
{
    @Override
    public void run() {

        // Altri calcoli

        synchronized(this)
        {
            System.out.println("Thread " + Thread.currentThread().getName() + " - Premi invio");
            Scanner in = new Scanner(System.in);
            in.nextLine();
            System.out.println("OK invio premuto");
        }
    }
}

class InTest
{
    public static void main(String[] args)
    {
        TestRunner r = new TestRunner();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
    }
}