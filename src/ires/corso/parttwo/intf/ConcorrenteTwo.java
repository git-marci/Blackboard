package ires.corso.parttwo.intf;

public class ConcorrenteTwo
        extends MasterChef
        implements ExampleInterface
{
    @Override
    public void cookMeAPizza() {
        System.out.println("OK ti cucino la pizza: sono il CONCORRENTE DUE!!!");
    }

    @Override
    public int intMethod(int i) {
        System.out.println("Sono CONCORRENTE DUE!!! e ricevo " + i);
        return i;
    }

    @Override
    public String stringMethod(String s) {
        System.out.println("Sono CONCORRENTE DUE!!! e ricevo  " + s);
        return s;
    }
}

