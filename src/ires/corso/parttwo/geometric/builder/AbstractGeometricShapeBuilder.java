package ires.corso.parttwo.geometric.builder;

import ires.corso.parttwo.geometric.shape.Square;
import ires.corso.parttwo.geometric.shape.Triangle;

public abstract class AbstractGeometricShapeBuilder
{
    public abstract String askForAString(String label);
    public abstract double askForADouble(String label);
    public abstract int askForAnInt(String label);

    public abstract void publishMessage(String s);

    public final Square buildASquare() {
        double side = askForADouble("Inserisci il lato del quadrato:");

        // controllo se i dati inseriti sono ok...

        Square sq = new Square(side);
        return sq;
    }

    public final Triangle buildATriangle() {
        // Chiedi che TIPO di triangolo
        // Chiedi in input i dati
        // costruisci il triangolo
        return new Triangle();
    }

    /*
    public Trapezium buildATrapezium() {

    }
     */
}
