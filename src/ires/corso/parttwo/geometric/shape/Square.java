package ires.corso.parttwo.geometric.shape;

public class Square extends MasterShape
{
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double computeArea() {
        return side * side;
    }
}
