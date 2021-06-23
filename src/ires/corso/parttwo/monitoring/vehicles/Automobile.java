package ires.corso.parttwo.monitoring.vehicles;

public class Automobile
        extends VeicoliMotorizzati
{
    public Automobile(String targa, String numTelaio) {
        super(targa,numTelaio);
    }

    @Override
    public String yourPosition() {
        return "[POSIZIONE DELL'AUTOMOBILE]";
    }
}
