package ires.corso.parttwo.monitoring.beings;

import ires.corso.parttwo.monitoring.PositionMonitor;

import java.util.Locale;

public abstract class Animali
        implements PositionMonitor.Monitorable
{
    protected abstract String getName();
    protected abstract String getPosition();

    @Override
    public String whoAreYou() {
        return getName();
    }

    @Override
    public String yourPosition() {
        return "[POSIZIONE DEL CANE: " + getPosition().toUpperCase() + "]";
    }
}
