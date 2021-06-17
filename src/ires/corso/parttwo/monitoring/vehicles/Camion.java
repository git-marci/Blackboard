package ires.corso.parttwo.monitoring.vehicles;

public class Camion
        extends VeicoliMotorizzati
{
    public Camion(String targa) {
        super(targa);
    }

    @Override
    public String yourPosition() {
        return "[POSIZIONE DEL CAMION]";
    }
}
