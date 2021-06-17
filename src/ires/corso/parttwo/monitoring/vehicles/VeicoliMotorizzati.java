package ires.corso.parttwo.monitoring.vehicles;

import ires.corso.parttwo.monitoring.PositionMonitor;

public abstract class VeicoliMotorizzati
        implements PositionMonitor.Monitorable
{
    private final String targa;

    public VeicoliMotorizzati(String targa) {
        this.targa = targa;
    }

    @Override
    public String whoAreYou() {
        return targa;
    }

    @Override
    abstract public String yourPosition();
}
