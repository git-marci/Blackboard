package ires.corso.parttwo;

import ires.corso.parttwo.calculator.NewCalc;
import ires.corso.parttwo.calculator.OldCalc;
import ires.corso.parttwo.calculator.SciCalc;
import ires.corso.parttwo.monitoring.PositionMonitor;
import ires.corso.parttwo.monitoring.vehicles.Automobile;
import ires.corso.parttwo.monitoring.vehicles.Camion;
import ires.corso.parttwo.monitoring.vehicles.VeicoliMotorizzati;

import java.util.Arrays;

public class BB210617
{
    private static BB210617 innerInstance;

    private BB210617() {}

    public static BB210617 getInstance() {
        if(innerInstance == null)
            innerInstance = new BB210617();
        return innerInstance;
    }

    public static void main(String[] args)
    {
        // creo una bicicletta...
        // creo una barca...
        // ho un cane...
        // mio figlio...
        // una macchina...
        int theA = PositionMonitor.Monitorable.giveMeTheA();

        Automobile a = new Automobile("UD12345", "XYZ1234");
        PositionMonitor pma = new PositionMonitor(a);
        pma.displayPosition();

        Camion c = new Camion("TS12345", "XYZ0987654");
        PositionMonitor pmc = new PositionMonitor(c);
        pmc.displayPosition();

        // Old and new calc
        SciCalc sc = getTheCalc();
        sc.doTheCalc();
    }

    /*
    // Implementazione 1
    public static SciCalc getTheCalc() {
        return new OldCalc();
    }
    */

    // Implementazione 2
    public static SciCalc getTheCalc() {
        return new NewCalc();
    }
}
