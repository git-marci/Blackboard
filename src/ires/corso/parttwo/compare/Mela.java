package ires.corso.parttwo.compare;

public class Mela
        extends AbstractFruit
        implements Comparable<Mela>
{
    //private final int grammi;
    protected int grammi;

    public int getGrammi() {
        return grammi;
    }

    public Mela() {
        grammi = 100;
    }

    public Mela(int g) {
        grammi = g;
    }

    public int compareTo(Mela m) {
        return this.grammi - m.grammi;
    }
}
