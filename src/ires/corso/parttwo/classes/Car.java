package ires.corso.parttwo.classes;

public class Car implements Vehicle
{
    @Override
    public void Spostati(int km) {
        System.out.printf("Mi sposto di %d km\n", km);
    }
}
