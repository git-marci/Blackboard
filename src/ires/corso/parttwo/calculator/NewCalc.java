package ires.corso.parttwo.calculator;

public class NewCalc
        implements SciCalc
{
    @Override
    public void doTheCalc() {
        System.out.println("NEW CALC running...");
        System.out.println("The result is 200");
    }
}
