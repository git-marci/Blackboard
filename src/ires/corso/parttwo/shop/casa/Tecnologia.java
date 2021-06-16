package ires.corso.parttwo.shop.casa;

import ires.corso.parttwo.shop.MovimentiMagazzino;
import ires.corso.parttwo.shop.VenditaDettaglio;

public class Tecnologia
        extends Casa
        implements VenditaDettaglio, MovimentiMagazzino, PrezziCasaGenerale
{
    @Override
    public void registraCarico(int amount) {

    }

    @Override
    public double getItemPrice() {
        return 0;
    }

    @Override
    public double getPrezzoArticoloCasa() {
        return 0;
    }
}
