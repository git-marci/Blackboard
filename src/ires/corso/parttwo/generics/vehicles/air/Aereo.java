package ires.corso.parttwo.generics.vehicles.air;

public class Aereo extends VolanteMotorizzato
{
    public void cabra() {
        System.out.println("CABRATA");
    }

    public void picchia() {
        System.out.println("PICCHIATA");
    }

    @Override
    public void motoriOn() {
        System.out.println("ACCENDO I REATTORI");
    }

    @Override
    public void motoriOff() {
        System.out.println("SPENGO I REATTORI");
    }
}
