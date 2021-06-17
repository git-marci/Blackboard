package ires.corso.parttwo.monitoring.vehicles;

public class Automobile
        extends VeicoliMotorizzati
{
    public Automobile(String targa) {
        super(targa);
    }

    @Override
    public String yourPosition() {
        return "[POSIZIONE DELL'AUTOMOBILE]";
    }
}
