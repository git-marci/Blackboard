package ires.corso.parttwo.geometric.shape;

public class Triangle extends MasterShape
{
    @Override
    public double computeArea() {
        return 0;
    }

    // Metodi di validazione dei parametri inseriti per la creazione del triangolo
    public static boolean validParameters(double a, double b, double c) {
        return true;
    }
}
