package ires.corso.parttwo.monitoring.vehicles;

import ires.corso.parttwo.monitoring.PositionMonitor;

public abstract class VeicoliMotorizzati
        implements PositionMonitor.Monitorable
{
    private final String targa;
    private final String numTelaio;

    public VeicoliMotorizzati(String targa, String numTelaio) {
        this.targa = targa;
        this.numTelaio = numTelaio;
    }

    // Restituisce targa
    public String getTarga() {
        return targa;
    }

    // Restituisce numero telaio
    public String getNumTelaio() {
        return numTelaio;
    }

    @Override
    public String whoAreYou() {
        return targa;
    }

    @Override
    abstract public String yourPosition();
}
