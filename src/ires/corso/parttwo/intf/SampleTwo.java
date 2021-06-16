package ires.corso.parttwo.intf;

public class SampleTwo
        extends MasterOne
        implements ExampleInterface
{
    @Override
    public void saySomething() {
        System.out.println("SampleTwo says something...");
    }

    @Override
    public int intMethod(int i) {
        System.out.println("Sono un'istanza di SampleTwo e ricevo " + i);
        return i;
    }

    @Override
    public String stringMethod(String s) {
        System.out.println("Sono un'istanza di SampleTwo e ricevo " + s);
        return s;
    }
}
