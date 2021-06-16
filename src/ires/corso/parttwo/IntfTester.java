package ires.corso.parttwo;

import ires.corso.parttwo.intf.*;

public class IntfTester
{
    public static void main(String[] args)
    {
        // Prima gerarchia VERTICALE
        SampleOne so = new SampleOne();
        SampleTwo st = new SampleTwo();

        so.intMethod(200);
        so.testDefaultMethod();
        st.testDefaultMethod();

        ExampleInterface eiVar;
        eiVar = (ExampleInterface)so;
        eiVar.intMethod(400);

        MasterOne[] moArray = new MasterOne[] {so, st};
        for(int i = 0; i < moArray.length; i++) {
            moArray[i].saySomething();
        }

        // Seconda gerarchia VERTICALE
        ConcorrenteOne co = new ConcorrenteOne();
        ConcorrenteTwo ct = new ConcorrenteTwo();

        MasterChef[] mcArray = new MasterChef[] {co, ct};
        for(int i = 0; i < mcArray.length; i++) {
            mcArray[i].cookMeAPizza();
        }

        // "Gerarchia" ORIZZONTALE
        ExampleInterface[] eiArray = new ExampleInterface[] {so, st, co, ct};
        for(int i = 0; i < eiArray.length; i++) {
            eiArray[i].intMethod(100);
            eiArray[i].stringMethod("TEST");
        }
    }
}
