package ires.corso.parttwo.intf;

public class SampleOne
        extends MasterOne
        implements ExampleInterface
{
    @Override
    public void saySomething() {
        System.out.println("SampleOne says something...");
    }

    @Override
    public int intMethod(int i) {
        System.out.println("Sono un'istanza di SampleOne e ricevo " + i);
        return i;
    }

    @Override
    public String stringMethod(String s) {
        System.out.println("Sono un'istanza di SampleOne e ricevo " + s);
        return s;
    }

    @Override
    public void testDefaultMethod() {
        System.out.println("OVERRIDE DEL DEFAULT");
    }
}
