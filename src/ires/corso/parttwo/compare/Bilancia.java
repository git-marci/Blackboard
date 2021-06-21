package ires.corso.parttwo.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class Bilancia
{
    public static void main(String[] args)
    {
        Mela m1 = new Mela(150);
        Mela m2 = new Mela(250);

        Mela m3 = new MelaFuji();

        System.out.println("Il peso della terza mela è: " + m3.getGrammi());
        System.out.println("Il risultato del confronto tra la prima e la seconda mela è: " + m1.compareTo(m2));

        ArrayList test = new ArrayList();
        test.add(m1);
        test.add("Marcello");

        ArrayList<Mela> am = new ArrayList<>();
        am.add(m1);
        am.add(m2);
        am.add(m3);

        am.set(10, m1);

        Collections.sort(am);

        // 0 Accesso posizionale
        System.out.println("\nPOSIZIONALE");
        for(int i = 0; i < am.size(); i++) {
            System.out.println("Il peso della mela list è: " + am.get(i).getGrammi());
        }

        // 1. For con variabile specifica (di tipo Mela)
        System.out.println("\nFOR enhanced CON VARIABILE MELA");
        for(Mela m: am) {
            System.out.println("Il peso della mela è: " + m.getGrammi());
        }

        // 2. Iterator
        System.out.println("\nITERATOR");
        Iterator<Mela> im = am.iterator();
        while(im.hasNext()) {
            System.out.println("Il peso della mela è: " + im.next().getGrammi());
        }

        // 3. Loop con LAMBDA expression (Java 1.8)
        System.out.println("\nLAMBDA Expression");
        am.forEach(m -> {System.out.println("il peso della mela è: " + m.getGrammi());});
    }
}
