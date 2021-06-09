package ires.corso.partone;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class BB210608 {

    public enum NumeriNiki {
        N1,
        N2,
        N3,
        N4
    }

    public enum Giorno {
        LUNEDI,
        MARTEDI,
        MERCOLEDI,
        GIOVEDI,
        VENERDI,
        SABATO,
        DOMENICA
    }

    public enum StudenteIres {
        AGNESE,
        NIKI,
        GABRIELE1,
        GABRIELE2,
        ALESSANDRO
    }

    public static void draft()
    {
        double d = Double.parseDouble("1234");
        String str = "+234.58900";
        boolean isDouble = str.matches("[+-]?\\d+(\\.\\d+)?");
        if(isDouble) {
            System.out.println("OK è un double");
            double dParsed = Double.parseDouble(str);
            System.out.printf("Valore \\ double %f\n", dParsed);
        }
        else {
            System.out.println("NO! Non è un double");
        }

        // Regular expression: -? \d+ (\.\d+)?
        /*

        [abc123] ==> indica presenza di UNO qualsiasi tra i caratteri inclusi nelle []
        ? ==> opzionale
        + ==> una o più occorrenze
        * ==> zero o più occorrenze
        () ==> individua un gruppo (al quale poi si applicano +, *, ?...)

        Alcuni caratteri devono essere "escaped":
        \. ==> è il punto
        \d ==> una cifra (0, 1, 2, 3...)

        [+-]?  ==> può esserci o no il segno più/meno (opzionale)
        \d+ ==> uno o più caratteri numerici
        (\.\d+)? ==> opzionale, un gruppo formato dal punto e da uno o più caratteri numerici

        AMMISSIBILI
        34.56
        -12345.78
        -345
        34
         */

        // Enumerations
        Giorno g1 = Giorno.MERCOLEDI;
        Giorno g2 = Giorno.valueOf("MERCOLEDI");

        // Versione con array
        String[] dayArray = new String[7];
        dayArray[0] = "LUNEDI";
        dayArray[1] = "MARTEDI";
        dayArray[2] = "MERCOLEDI";
        dayArray[3] = "GIOVEDI";
        dayArray[4] = "VENERDI";

        String varGiorno; // ...è una qualsiasi STRINGA
        varGiorno = "PIPPOFRANCO";

        Giorno varGiornoEnum = Giorno.MARTEDI;

        switch(g2) {
            case LUNEDI:
                System.out.println("Siamo di Lunedi");
                break;
            case MARTEDI:
                System.out.println("Siamo di Martedi");
                break;
            case MERCOLEDI:
                System.out.println("Siamo di Mercoledi");
                break;
        }

        // Giorno g3 = Giorno.valueOf("il mio compleanno");

        // Altro esempio
        StudenteIres si;

        System.out.print("\nDimmi chi sei: ");
        Scanner in = new Scanner(System.in);
        si = StudenteIres.valueOf(in.nextLine());

        switch(si) {
            case AGNESE:
                System.out.println("Tu sei Agnese");
                break;
            case NIKI:
                System.out.println("Tu sei Niki");
                break;
            case ALESSANDRO:
                System.out.println("Tu sei Alessandro");
                break;
            default:
                System.out.println("Non ti conosco");
                break;
        }

        // DATE (Localdate)
        LocalDate now = LocalDate.now();
        System.out.println("Data corrente ==> " + now);

        LocalDate anotherBirthday = LocalDate.of(2000, Month.APRIL, 25);
        // ERRORE ==> LocalDate birthday = LocalDate.of(2000, 234, 25);

        LocalDate oneDayAgo = LocalDate.now().minus(1, ChronoUnit.DAYS);
        LocalDate oneMonthAgo = LocalDate.now().minus(1, ChronoUnit.MONTHS);

        // API + fragile
        /*
        LocalDate oneDayAgoMM = LocalDate.now().minus(1, "DAYS");
        LocalDate oneMonthAgoMM = LocalDate.now().minus(1, "MONTHS");

        Facciamo delle costanti...

        ...in un punto "globale"...
        String GIORNI = "DAYS";
        String MESI = "MONTHS";

        ...e localmente
        LocalDate oneDayAgoMM = LocalDate.now().minus(1, GIORNI); <== faccio rif. alla costante

        ...però siccome il secondo parametro è una stringa, io potrei anche scrivere:
        LocalDate oneDayAgoMM = LocalDate.now().minus(1, "PIPPOFRANCO"); <== errore!!!
        */

        // Time
        LocalTime ltNow = LocalTime.now();
        System.out.println("Sono le ore: " + ltNow);
        LocalTime twoThirty = LocalTime.of(14, 30);
        LocalTime sevenThirty = twoThirty.plus(5, ChronoUnit.HOURS);

        // Modifiche in cascata
        LocalTime quattroEDiciassette = (twoThirty.plusHours(1)).plusMinutes(17);

        // Equivalente
        LocalTime treEMEzza = twoThirty.plusHours(1);
        LocalTime quattroEDic = treEMEzza.plusMinutes(47);

        // Esempio di formattazione
        LocalDate nowFrmt = LocalDate.now();
        String sfrm1 = nowFrmt.format(DateTimeFormatter.ISO_DATE);
        System.out.println("La data di oggi formattata: " + sfrm1);
        String sfrm2 = nowFrmt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("La data di oggi ri-formattata: " + sfrm2);

        Period p = Period.of(1, 6, 15);
        LocalDate dpp = nowFrmt.plus(p);
    }

    public static void main(String[] args)
    {
        loopTestTwo();
    }

    public static void loopTestOne()
    {
        /*

            Input number of rows : 10
            1
            12
            123
            1234
            12345

            VARIAZIONE:
            1
            2 3
            4 5 6
            7 8 9 10

         */
        int i, j, n;
        int incr = 1;

        System.out.print("Input number of rows : ");
        Scanner theScan = new Scanner(System.in);
        n = theScan.nextInt();

        for(i = 1; i <= n; i++) {
            // System.out.println("Sono alla riga ==> " + i);
            for(j = 1; j <= i; j++) {
                //System.out.print(j);
                System.out.print(incr + " ");
                incr++;
            }
            System.out.println("");
        }
    }

    public static void loopTestTwo()
    {
        /*
        Input number of rows (half of the diamond) : 7 ==> total size = 13

        1° problema:
              *
             ***
            *****
           *******
          *********
         ***********
        *************
    -----------------------
        2° problema
         ***********
          *********
           *******
            *****
             ***
              *

            // Davide: un boolean che dice se +/-, loop unico?
            // Davide: meglio 2 loop, uno cresce l'altro diminuisce
            // Alessio: tutte le righe hanno 13 caratteri
            // GGrieco: Ogni sequenza aumenta di 2 numero asterischi
            // GMoreale: incremento/decremento numero di spazi


        ANALISI: d = 7

        ------*             6 spazi, 1 stella      i = 1
        -----***            5 spazi, 3 stelle      i = 2
        ----*****           4 spazi, 5 stelle      i = 3
        ---*******          3 spazi, 7 stelle      i = 4
        --*********         ...                    ...
        -***********        ...                    ...
        *************       0 spazi, 13 stelle     i = 7

        */

        int i, j, d;

        // d viene in input
        d = 7;

        // LOOP ORIGINALE
        for(i = 1; i <= d; i++)
        {
            // Stampo gli spazi
            int numSpaces = d - i;
            for(j = 1; j <= numSpaces; j++) {
                System.out.print(" ");
            }

            // Stampo le stelle
            int numStars = (2 * i) - 1;
            for(j = 1; j <= numStars; j++) {
                System.out.print("*");
            }

            System.out.println("");
        }

        for(i = d - 1; i >= 1; i--)
        {
            // Stampo gli spazi
            int numSpaces = d - i;
            for(j = 1; j <= numSpaces; j++) {
                System.out.print(" ");
            }

            // Stampo le stelle
            int numStars = (2 * i) - 1;
            for(j = 1; j <= numStars; j++) {
                System.out.print("*");
            }

            System.out.println("");
        }

        // METTO IN EVIDENZA LA STAMPA
        System.out.println("");
        System.out.println("------------------------------------------");
        for(i = 1; i <= d; i++)
        {
            int numSpaces = d - i;
            int numStars = (2 * i) - 1;
            printDiamondStars(numSpaces, numStars);
        }

        for(i = d - 1; i >= 1; i--)
        {
            int numSpaces = d - i;
            int numStars = (2 * i) - 1;
            printDiamondStars(numSpaces, numStars);
        }

        // METTO IN EVIDENZA LA STAMPA E DEFINIZIONE SPAZI/STELLE
        System.out.println("");
        System.out.println("------------------------------------------");
        for(i = 1; i <= d; i++)
            computeAndPrintDiamondLine(i, d);

        for(i = d - 1; i >= 1; i--)
            computeAndPrintDiamondLine(i, d);

        // ONLY 1 LOOP
        System.out.println("");
        System.out.println("------------------------------------------");
        int doubleDim = d * 2;
        for(i = 1; i <= doubleDim - 1; i++) {
            int pattern = (i > d)? doubleDim - i: i;
            computeAndPrintDiamondLine(pattern, d);
        }

    }

    public static void computeAndPrintDiamondLine(int lineIndex, int diamondSize) {
        int numSpaces = diamondSize - lineIndex;      // Numero di spazi
        int numChars = lineIndex * 2 - 1;             // Numero di caratteri <> ""
        printDiamondStars(numSpaces, numChars);
    }

    public static void printDiamondStars(int spaces, int stars) {
        int j;
        for(j = 1; j <= spaces; j++) System.out.print(" ");
        for(j = 1; j <= stars; j++) System.out.print("*");
        System.out.print("\n");
    }

    /*
        VARIAZIONE: per d = 7

              1
             212
            32123
           4321234
          543212345
         65432123456
        7654321234567
         65432123456
          543212345
           4321234
            32123
             212
              1
     */
}
