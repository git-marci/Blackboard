package ires.corso.partone;

import java.util.Arrays;
import java.util.Scanner;

public class BB210609
{
    public static void main(String[] args) {
        testInputString();
    }

    public static void testInputString()
    {
        Scanner inputScan = new Scanner(System.in);

        // Array inizialization
        int[] theIntArray = {1, 2, 3, 4, 5};
        String[] theStringArray = {"ciao", "bene", "fine"};

        arrayTest(new int[]{1, 2, 3, 4, 5});

        // Test
        System.out.println("Inserisci una stringa numerica: ");
        System.out.print("==>");
        String s = inputScan.nextLine().trim();
        int theInt;

        if(isNumeric(s)) {
            theInt = Integer.parseInt(s);
            System.out.printf("Hai inserito il numero %d\n", theInt);
        }
        else
            System.out.println("Avevo detto un numero, pazienza...");
        System.out.println("FINE");
    }

    public static void arrayTest(int[] theArg) {
        // non fa niente...
        for(int i = 0; i < theArg.length; i++)
            System.out.printf("elemento %d = %d\n", i, theArg[i]);
    }

    public static boolean isNumeric(String s) {
        int j;
        boolean res = true;

        // Controllo che la lunghezza sia > 0
        if(s.length() == 0) return false;

        // Con loop for
        for(j = 0; j < s.length(); j++) {
            if(!Character.isDigit(s.charAt(j))) {
                res = false;
                break;
            }
        }

        // In alternativa
        /*
        j = 0;
        res = true;
        while(res && (j >= 0) && (j < s.length())) {
            res = Character.isDigit(s.charAt(j));
            j++;
        }
        */

        return res;
    }
}
