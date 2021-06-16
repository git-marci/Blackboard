package ires.corso.parttwo.shop.casa;

import ires.corso.parttwo.shop.MovimentiMagazzino;
import ires.corso.parttwo.shop.VenditaDettaglio;

public class Condizionatori
        extends Casa
        implements VenditaDettaglio, MovimentiMagazzino
{
    @Override
    public void registraCarico(int amount) {

    }

    @Override
    public double getItemPrice() {
        return 1500;
    }
}
