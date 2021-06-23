package ires.corso.parttwo.monitoring.vehicles;

public class Camion
        extends VeicoliMotorizzati
{
    public Camion(String targa, String numTelaio) {
        super(targa, numTelaio);
    }

    @Override
    public String yourPosition() {
        return "[POSIZIONE DEL CAMION]";
    }
}
