package ires.corso.parttwo.advanced;

public class Staff extends Person
{
    @Override
    public String eatSomething() {
        System.out.println("Sono lo staff e mangio al ristorante");
        return null;
    }

    @Override
    public String drink() {
        return null;
    }

    @Override
    public String moveToSchool() {
        return null;
    }
}
