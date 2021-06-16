package ires.corso.parttwo.shop.medicina;

import ires.corso.parttwo.shop.ControlloPrescrizione;
import ires.corso.parttwo.shop.VenditaDettaglio;

public class Farmaci
        extends Medicina
        implements VenditaDettaglio, ControlloPrescrizione
{
    @Override
    public double getItemPrice() {
        return 0;
    }
}
