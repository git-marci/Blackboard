package ires.corso.parttwo.shop.alimentari;

import ires.corso.parttwo.shop.GestioneAlimentari;
import ires.corso.parttwo.shop.VenditaDettaglio;
import ires.corso.parttwo.shop.alimentari.Alimentari;

public class Carne
        extends Alimentari
        implements GestioneAlimentari, VenditaDettaglio
{
    @Override
    public double getItemPrice() {
        return this.getAlimentariPrice();
    }
}
