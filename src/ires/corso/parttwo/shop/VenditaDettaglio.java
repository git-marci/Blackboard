package ires.corso.parttwo.shop;

public interface VenditaDettaglio
{
    double getItemPrice();

    default void vendiACliente() {
        System.out.println("- Devi pagare: " + getItemPrice());
    }
}
