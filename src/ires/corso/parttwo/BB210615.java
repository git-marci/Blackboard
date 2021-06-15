package ires.corso.parttwo;

import java.util.Arrays;
import java.util.Objects;

public class BB210615
{
    public static class Minimal {
        private String test;

        public Minimal(String s) {
            test = s;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Minimal minimal = (Minimal) o;
            return Objects.equals(test, minimal.test);
        }

        @Override
        public int hashCode() {
            return Objects.hash(test);
        }
    }

    public static void main(String[] args)
    {
        int[] intArr1 = {1, 2, 3, 4, 5};
        String[] strArr1 = {"java", "test", "ires", "corso"};

        System.out.println("Hai inserito questo array (no metodo toString!): " + intArr1.toString());
        System.out.println("Hai inserito questo array di int: " + Arrays.toString(intArr1));
        System.out.println("Hai inserito questo array di stringhe: " + Arrays.toString(strArr1));

        // OVERLOAD vs. OVERRIDE
        // - overload ==> in una stessa classe, metodi diversi hanno lo STESSO NOME ma argomenti/risultato di tipo diverso
        // - @Override ==> in una classe "figlia" un metodo con LA STESSA FIRMA, ereditato dalla classe superiore,
        //                 ha un'implementazione "custom" che SCAVALCA l'implementazione ereditata

        int[] intArrCopy1 = Arrays.copyOf(intArr1, 3);
        int[] intArrCopy2 = Arrays.copyOf(intArr1, 10);

        System.out.println("Hai creato questa copia (1): " + Arrays.toString(intArrCopy1));
        System.out.println("Hai creato questa copia (2): " + Arrays.toString(intArrCopy2));

        int[] intArrRange = Arrays.copyOfRange(intArrCopy2, 3, 7);
        System.out.println("Hai creato questo range dalla copia (2): " + Arrays.toString(intArrRange));

        // "old style"
        int[] oldStyleCopy = new int[intArr1.length];
        System.arraycopy(intArr1, 0, oldStyleCopy, 0, intArr1.length);
        System.out.println("Ai bei tempi si faceva così: " + Arrays.toString(oldStyleCopy));

        // Confronto di arrays
        // - dati primitivi
        int a, b;
        a = 1;
        b = 1;

        if(a == b)
            System.out.printf("I due valori %d e %d sono uguali!\n", a, b);
        else
            System.out.printf("I due valori %d e %d sono DIFFERENTI...\n", a, b);

        // - stringhe (sono oggetti PARTICOLARI in Java)
        String s1 = "Marcello"; // dichiarazione con "string literal"
        String s2 = "Marcello";

        if(s1 == s2)
            System.out.printf("I due valori %s e %s sono uguali!\n", s1, s2);
        else
            System.out.printf("I due valori %s e %s sono DIFFERENTI...\n", s1, s2);

        // ...ma si DEVE fare:
        if(s1.equals(s2))
            System.out.printf("I due valori %s e %s sono uguali (con equals)!\n", s1, s2);
        else
            System.out.printf("I due valori %s e %s sono DIFFERENTI (con equals)...\n", s1, s2);

        // ...per riscoprire la natura di "Oggetto" della String, dichiarare esplicitamente la sua istanza:
        String s3 = new String("Marcello");
        String s4 = new String("Marcello");

        if(s3 == s4)
            System.out.printf("I due valori (creati con new) %s e %s sono uguali!\n", s3, s4);
        else
            System.out.printf("I due valori (creati con new) %s e %s sono DIFFERENTI...\n", s3, s4);

        // ...ma si DEVE fare:
        if(s3.equals(s4))
            System.out.printf("I due valori (creati con new) %s e %s sono uguali (con equals)!\n", s3, s4);
        else
            System.out.printf("I due valori (creati con new) %s e %s sono DIFFERENTI (con equals)...\n", s3, s4);

        // - oggetti
        Minimal m1 = new BB210615.Minimal("Marcello");
        Minimal m2 = new BB210615.Minimal("Marcello");
        Minimal m3 = m1;

        if(m1 == m2)
            System.out.println("I due oggetti " + m1 + " e " + m2 + " sono uguali (==)");
        else
            System.out.println("I due oggetti " + m1 + " e " + m2 + " sono DIFFERENTI (!=)");

        if(m1 == m3)
            System.out.println("I due oggetti " + m1 + " e " + m3 + " sono uguali (==)");
        else
            System.out.println("I due oggetti " + m1 + " e " + m3 + " sono DIFFERENTI (!=)");

        // Test con metodo equals
        if(m1.equals(m2))
            System.out.println("I due oggetti " + m1 + " e " + m2 + " sono uguali (equals)");
        else
            System.out.println("I due oggetti " + m1 + " e " + m2 + " sono DIFFERENTI (equals)");

        // - array
        String[] planes1 = new String[] { "A320", "B738", "A321", "A319", "B77W", "B737", "A333", "A332" };
        String[] planes2 = new String[] { "A320", "B738", "A321", "A319", "B77W", "B737", "A333", "A332" };
        //String[] planes2 = planes1;

        if(planes1 == planes2)
            System.out.println("I due array " + planes1 + " e " + planes2 + " sono uguali (==)");
        else
            System.out.println("I due array " + planes1 + " e " + planes2 + " sono DIFFERENTI (!=)");

        // NON FUNZIONA! NON IMPLEMENTATO
        if(planes1.equals(planes2))
            System.out.println("I due array " + planes1 + " e " + planes2 + " sono uguali (equals)");
        else
            System.out.println("I due array " + planes1 + " e " + planes2 + " sono DIFFERENTI (equals)");

        // Utilizzare invece ==> Arrays.equals/Arrays.deepEquals
        if(Arrays.deepEquals(planes1, planes2))
            System.out.println("I due array " + planes1 + " e " + planes2 + " sono uguali (Arrays.equals)");
        else
            System.out.println("I due array " + planes1 + " e " + planes2 + " sono DIFFERENTI (Arrays.equals)");
    }

    public static int testOverload(int i) {
        return i;
    }

    public static String testOverload(String s) {
        return s;
    }

    /* THE SORTING GAME */

    /*
        GRUPPO ALFA: Agnese, Niki, Davide               ==>
        GRUPPO BETA: Stefano, Veronica, Gabriele G.     ==>
        GRUPPO GAMMA: Alessandro, Alberto, Fabiola      ==>
        GRUPPO DELTA: Daniele, Gabriele M., Alessio     ==>
    */

    // 4 progetti sul mio github

    // Requisiti
    // -------------------------------------------------------------------
    // Implementare il gioco "SORTING GAME" in Java.
    // Il gioco funziona così:
    // 1. Stampa l'intestazione del gioco, invitando il giocatore ad inserire una serie di numeri separati da spazi
    // 2. Chiede in input una sola linea di testo, che poi analizza per trasformarla in un vettore di interi
    // 3. Nella costruzione bisogna verificare che:
    //    - non siano stati inseriti caratteri non numerici ==> se sì, uscire con un messaggio adeguato
    //    - non siano stati inseriti duplicati ==> se sì, uscire con un messaggio adeguato (non impl.)
    //    - il vettore non sia già ordinato ==> se sì, uscire con un messaggio adeguato
    // 4. Costruisce un vettore che aggiunge ai numeri dati in input una stringa "X", che rappresenta la posizione vuota
    // 5. Si porta in un loop nel quale ad ogni passo:
    //    5.a - viene stampato l'array corrente
    //    5.b - il giocatore può specificare quale numero intende scambiare con la "X"
    //    5.c - se il numero richiesto non esiste, si stampa un messaggio e il loop ricomincia (5.a)
    //    5.d - se il giocatore inserisce una "q" o una "Q", il loop finisce
    //    5.e - se il giocatore inserisce un carattere non numerico, si stampa un messaggio e il loop ricomincia (5.a)
    //    5.f - dopo la scelta del giocatore, la X e il numero richiesto sono scambiati: se il vettore risulta fatto da numeri
    //          ordinati con la "X" in fondo, il gioco è risolto e il loop finisce, altrimenti riprende da 5.a
    // 6. Se il loop è finito in 5.d (abbandono), stampare un messaggio che notifica all'utente che ha abbandonato il gioco
    // 7. Se il loop è finito in 5.f,(risolto) congratularsi con il giocatore e dire in quante mosse è stato risolto

}
