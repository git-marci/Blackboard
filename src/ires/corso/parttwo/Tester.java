package ires.corso.parttwo;

import ires.corso.parttwo.geometric.shape.*;
import ires.corso.parttwo.geometric.builder.*;

public class Tester
{
    public static void main(String[] args)
    {
        //ConsoleGeometricShapeBuilder cgsb = new ConsoleGeometricShapeBuilder();
        WebGeometricShapeBuilder cgsb = new WebGeometricShapeBuilder();
        Square sq = cgsb.buildASquare();

        MasterShape ms = (MasterShape) sq;
        //MasterShape ms2 = new MasterShape(); NO! MasterShape è abstract!!!

        double a = sq.computeArea();

        cgsb.publishMessage(String.format("L'area del quadrato ==> %f\n", a));
    }
}
