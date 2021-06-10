package ires.corso.parttwo;

import ires.corso.parttwo.classes.Animale;
import ires.corso.parttwo.classes.Customer;

public class BB210610
{
    public static void main(String[] args)
    {
        animalTest();
    }

    public static void animalTest()
    {
        Animale a1 = new Animale("leone");
        Animale a2 = new Animale();
    }

    public static void customerTest() {
        System.out.printf("\n==> ADESSO abbiamo %d customers\n\n", Customer.howManyCustomers());

        Customer cs1 = new Customer("Boris", "Johnson");
        //cs1.id = 111; // non posso, è PRIVATE
        //cs1.setId(1);
        //cs1.setName("Boris");

        // A cosa serve counter?
        System.out.printf("\n==> ADESSO abbiamo %d customers\n\n", Customer.howManyCustomers());

        Customer cs2 = Customer.giveMeANewCustomer("Tilda", "Swinson");
        //cs2.setId(2);
        //cs2.setName("Johnson");

        // A cosa serve counter?
        System.out.printf("\n==> ADESSO abbiamo %d customers\n\n", Customer.howManyCustomers());

        // stampo le caratteristiche degli oggetti
        /*
        System.out.printf("Sono l'oggetto 1:\n- il mio id ==> %d\n- il mio nome ==> %s\n\n", cs1.getId(), cs1.getName());
        System.out.printf("Sono l'oggetto 2:\n- il mio id ==> %d\n- il mio nome ==> %s\n\n", cs2.getId(), cs2.getName());
         */
        System.out.println(cs1.getInfo());
        System.out.println(cs2.getInfo());
    }
}
