package ires.corso.parttwo;

import ires.corso.parttwo.calculator.NewCalc;
import ires.corso.parttwo.calculator.OldCalc;
import ires.corso.parttwo.calculator.SciCalc;
import ires.corso.parttwo.monitoring.PositionMonitor;
import ires.corso.parttwo.monitoring.vehicles.Automobile;
import ires.corso.parttwo.monitoring.vehicles.Camion;

import java.util.Arrays;

public class BB210617
{
    public static void main(String[] args)
    {
        // creo una bicicletta...
        // creo una barca...
        // ho un cane...
        // mio figlio...
        // una macchina...

        Automobile a = new Automobile("UD12345");
        PositionMonitor pma = new PositionMonitor(a);
        pma.displayPosition();

        Camion c = new Camion("TS12345");
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
