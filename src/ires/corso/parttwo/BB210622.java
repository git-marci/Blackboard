package ires.corso.parttwo;

import ires.corso.parttwo.classes.Car;
import ires.corso.parttwo.media.Book;

public class BB210622
{
    public static void main(String[] args)
    {
        Book b1 = new Book("Flaubert", "L'educazione sentimentale", "isbn12345", 600);
        Book b2 = new Book("Flaubert", "Madame Bovary", "isbn34567", 550);
        Book b3 = new Book("Kafka", "Il processo", "isbn876543", 300);

        // sempre false: b1 e b2 puntano a istanze diverse della classe Book
        System.out.println("b1 == b2? ==> " + (b1 == b2));

        // sempre false: b1 e b1Copy puntano a istanze diverse della classe Book
        Book b1Copy = new Book("Flaubert", "L'educazione sentimentale", "isbn12345", 600);
        System.out.println("b1 == b1Copy? ==> " + (b1 == b1Copy));
        System.out.println("b1.equals(b1Copy)? ==> " + (b1.equals(b1Copy)));

        // Otteniamo: java.lang.NullPointerException
        /*
        Book b4 = null;
        b4.equals(b1Copy);
         */

        int hashB1 = b1.hashCode();
        System.out.println("hashcode di b1 ==> " + hashB1);
        b1.numPages = 100; // modifica "forzata" per verificare che l'hash sia differente
        int hashB1After = b1.hashCode();
        System.out.println("hashcode di b1  DOPO modifica ==> " + hashB1After);

        // Stringbuilder
        StringBuilder sb = new StringBuilder();
        StringBuilder sbEx = new StringBuilder("Marcello");
        System.out.println(sbEx.toString());
        sbEx.append(" Mauro");
        System.out.println(sbEx.toString());
    }
}
