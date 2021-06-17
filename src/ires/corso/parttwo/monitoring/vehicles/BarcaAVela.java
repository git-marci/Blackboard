package ires.corso.parttwo.monitoring.vehicles;

import ires.corso.parttwo.monitoring.PositionMonitor;

public class BarcaAVela
        extends VeicoliNonMotorizzati
        implements PositionMonitor.Monitorable
{
    public BarcaAVela(String nickName) {
        super(nickName);
    }

    @Override
    public String whoAreYou() {
        return nickName;
    }

    @Override
    public String yourPosition() {
        return "[POSIZIONE DELLA BARCFAA A VELA]";
    }
}
