package ires.corso.parttwo.monitoring;

import java.time.LocalTime;

public class PositionMonitor
{
    public interface Monitorable
    {
        int a = 123; // public, static, final

        String whoAreYou();
        String yourPosition();

        default String whatTimeIsIt() {
            LocalTime lt = LocalTime.now();
            return lt.toString();
        }

        // Invocabile sull'interfaccia
        static int giveMeTheA() {
            return a;
        }
    }

    private final Monitorable monitored;

    public PositionMonitor(Monitorable m) {
        this.monitored = m;
    }

    public void displayPosition() {
        System.out.println("################################################################################################");
        System.out.println("- La posizione di " + monitored.whoAreYou() +
                           " alle ore " + monitored.whatTimeIsIt() +
                           " ==> " + monitored.yourPosition());
        System.out.println("################################################################################################");
    }
}
