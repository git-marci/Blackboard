package ires.corso.parttwo.geometric.builder;

import ires.corso.parttwo.geometric.shape.Square;

import java.util.Scanner;

public class ConsoleGeometricShapeBuilder extends AbstractGeometricShapeBuilder
{
    private Scanner in;

    public ConsoleGeometricShapeBuilder() {
        in = new Scanner(System.in);
    }

    @Override
    public String askForAString(String label) {
        System.out.println(label);
        return in.nextLine();
    }

    @Override
    public double askForADouble(String label) {
        System.out.println(label);
        return in.nextDouble();
    }

    @Override
    public int askForAnInt(String label) {
        System.out.println(label);
        return in.nextInt();
    }

    @Override
    public void publishMessage(String s) {
        System.out.println(s);
    }
}
