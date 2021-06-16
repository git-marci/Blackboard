package ires.corso.parttwo.intf;

public interface ExampleInterface
{
    int intMethod(int i);

    String stringMethod(String s);

    default void testDefaultMethod() {
        System.out.println("DEFAULT METHOD");
    }
}
