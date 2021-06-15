package ires.corso.parttwo.geometric.builder;

import java.util.Scanner;

public class WebGeometricShapeBuilder extends AbstractGeometricShapeBuilder
{
    private Scanner in;

    public WebGeometricShapeBuilder() {
        in = new Scanner(System.in);
    }

    @Override
    public String askForAString(String label) {
        System.out.print("[SONO NEL WEB] ");
        System.out.println(label);
        return in.nextLine();
    }

    @Override
    public double askForADouble(String label) {
        System.out.print("[SONO NEL WEB] ");
        System.out.println(label);
        return in.nextDouble();
    }

    @Override
    public int askForAnInt(String label) {
        System.out.print("[SONO NEL WEB] ");
        System.out.println(label);
        return in.nextInt();
    }

    @Override
    public void publishMessage(String s) {
        System.out.print("[SONO NEL WEB] ");
        System.out.println(s);
    }
}
