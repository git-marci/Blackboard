package ires.corso.parttwo.shop.casa;

public interface PrezziCasaGenerale
{
    double getPrezzoArticoloCasa();

    default double getPrezzoCasaGenerale(int numItems) {
        return numItems * getPrezzoArticoloCasa();
    }
}
