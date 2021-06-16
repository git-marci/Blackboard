package ires.corso.parttwo.shop.casa;

import ires.corso.parttwo.shop.MovimentiMagazzino;
import ires.corso.parttwo.shop.VenditaDettaglio;

public class Giardinaggio
        extends Casa
        implements VenditaDettaglio, MovimentiMagazzino, PrezziCasaGenerale
{
    private int numItems = 1;

    public int getNumItems() {
        return numItems;
    }

    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }

    @Override
    public void registraCarico(int amount) {

    }

    @Override
    public double getItemPrice() {
        return getPrezzoCasaGenerale(this.getNumItems());
    }

    @Override
    public double getPrezzoArticoloCasa() {
        return 2500;
    }
}
