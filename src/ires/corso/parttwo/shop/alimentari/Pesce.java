package ires.corso.parttwo.shop.alimentari;

import ires.corso.parttwo.shop.GestioneAlimentari;
import ires.corso.parttwo.shop.NormativePesca;
import ires.corso.parttwo.shop.VenditaDettaglio;

public class Pesce
        extends Alimentari
        implements GestioneAlimentari, VenditaDettaglio, NormativePesca
{
    @Override
    public double getItemPrice() {
        return this.getAlimentariPrice();
    }
}
