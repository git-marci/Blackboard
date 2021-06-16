package ires.corso.parttwo.shop.medicina;

import ires.corso.parttwo.shop.ControlloPrescrizione;
import ires.corso.parttwo.shop.MovimentiMagazzino;
import ires.corso.parttwo.shop.VenditaDettaglio;

public class Garze
        extends Medicina
        implements VenditaDettaglio
{
    @Override
    public double getItemPrice() {
        return 0;
    }
}
