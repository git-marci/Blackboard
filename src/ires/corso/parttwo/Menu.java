package ires.corso.parttwo;

import ires.corso.parttwo.classes.Dessert;
import ires.corso.parttwo.classes.Pietanza;
import ires.corso.parttwo.classes.PrimoPiatto;
import ires.corso.parttwo.classes.SecondoPiatto;

import java.util.Scanner;

public class Menu
{
    public static void main(String[] args)
    {
        // ### PRIMO PIATTO
        PrimoPiatto pastaColPomodoro = new PrimoPiatto("Pasta col pomodoro",2, true, false);
        System.out.println("Sono il primo piatto ==> " + pastaColPomodoro.getNome());
        pastaColPomodoro.prettyPrint();
        System.out.println("");

        // AMBIVALENZA DELLE ISTANZE...
        //Pietanza pt1 = (Pietanza) pastaColPomodoro; // il casting esplicito non serve...
        Pietanza pt1 = pastaColPomodoro;
        System.out.println("Sono LA PIETANZA ==> " + pt1.getNome());
        System.out.println("Pasta col pomodoro: hai il parmigiano ? ==> " + pastaColPomodoro.isConParmigiano());
        // pt1.isConParmigiano() <=== NO! pt1 è una reference a PIETANZA
        pt1.setNome("Pasta alla carbonara");
        System.out.println("Sono il piatto ==> " + pastaColPomodoro.getNome());

        // ### SECONDO PIATTO
        System.out.println();
        SecondoPiatto tagliataDiManzo = new SecondoPiatto("Tagliata di manzo",1, false);
        tagliataDiManzo.prettyPrint();

        Pietanza pt2 = (Pietanza) tagliataDiManzo;
        System.out.println("Sono il piatto ==> " + pt2.getNome());
        System.out.println("Tagliata di manzo: hai il contorno ? ==> " + tagliataDiManzo.isConContorno());

        // ### DESSERT
        System.out.println();
        //Dessert tortaAlCioccolato = new Dessert("Torta al cioccolato",2);
        Dessert tortaAlCioccolato = Dessert.orderDessert("Torta al cioccolato",2);
        Dessert.activateDesserts(true);
        tortaAlCioccolato = Dessert.orderDessert("Torta al cioccolato",2);
        tortaAlCioccolato.prettyPrint();

        Pietanza pt3 = (Pietanza) tortaAlCioccolato;

        // Esempio di override
        System.out.println("");
        System.out.println("--------------------------------------------");
        System.out.println("Hai magnato eh? E ora devi pagare...");

        Pietanza[] ilConto = new Pietanza[3];
        /*
        ilConto[0] = pt1; <== setto gli elementi dell'array usando le references alle variabili "cast"
        ilConto[1] = pt2;
        ilConto[2] = pt3;
        */

        // ...ma in realtà posso direttamente assegnare le istanze delle classi "figlie" di Pietanza!
        ilConto[0] = pastaColPomodoro; // PrimoPiatto
        ilConto[1] = tagliataDiManzo; // SecondoPiatto
        ilConto[2] = tortaAlCioccolato; // Dessert

        // Calcoliamo il totale da pagare
        double theSum = 0.0;
        for(int i = 0; i < ilConto.length; i++) {
            theSum += ilConto[i].getPrice();
        }

        // Chiediamo il pagamento
        System.out.printf("Il conto è di %f dollari: quanti ne hai a disposizione?\n", theSum);
        Scanner in = new Scanner(System.in);
        double theMoney = in.nextDouble();

        // Paghiamo tutto
        double theRest = theMoney;
        for(int i = 0; i < ilConto.length; i++) {
            theRest = ilConto[i].acceptPayment(theRest);
        }

        // controllo finale
        if(theRest >= 0)
            System.out.println("Tutto ok, grazie!");
        else
            System.out.println("Qui abbiamo un problema...");
    }
}