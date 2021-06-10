package ires.corso.partone;

import java.util.Arrays;
import java.util.Scanner;

public class BB210609
{
    public static void main(String[] args) {
        sortingGame();
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

    public static void sortingGame()
    {
        System.out.println("Inserisci un array (numeri separati da uno spazio, esempio: 1 2 3 ...)");
        System.out.print("==>");
        Scanner in = new Scanner(System.in);
        String nl = in.nextLine();
        String[] strArr = nl.split(" ");

        // Costruisco array di interi a partire dall'input
        int[] intArr = new int[strArr.length];
        /*
        for(int j = 0; j < strArr.length; j++) {
            System.out.printf("Elemento %d-esimo dell'array ==> %s\n", j + 1, strArr[j]);
            intArr[j] = Integer.parseInt(strArr[j]);
        }
         */

        // Ordino l'array
        int[] sortArr = Arrays.copyOf(intArr, intArr.length);
        Arrays.sort(sortArr);
        /*
        for(int j = 0; j < sortArr.length; j++) {
            System.out.printf("Elemento %d-esimo dell'array ordinato ==> %d\n", j + 1, sortArr[j]);
        }
         */

        // Verifico che l'array sia ordinato
        if(Arrays.equals(sortArr,intArr)) {
            System.out.println("L'array è già ordinato, non c'è nemmeno gusto a giocare con te...");
            return;
        }

        // Costruisco l'array per giocare
        String[] gameArray = new String[strArr.length + 1];
        for(int j = 0; j < strArr.length; j++)
            gameArray[j] = strArr[j];
        gameArray[gameArray.length - 1] = "X";

        // Game loop
        int indexX = gameArray.length - 1;
        boolean finished = false;
        printGameArray(gameArray);
        while(!finished) {
            System.out.print("- Dimmi l'indice del numero da spostare (q o Q per uscire): ");
            String nextCommand = in.nextLine();
            if(nextCommand.equals("q") || nextCommand.equals("Q")) {
                finished = true;
            }
            else {
                int index = Integer.parseInt(nextCommand);
                String elemToMove = gameArray[index];
                gameArray[indexX] = elemToMove;
                gameArray[index] = "X";
                indexX = index;
                printGameArray(gameArray);

                // MANCA: verifica che l'array sia ordinato...
            }
        }
    }

    public static void printGameArray(String[] gArr) {
        System.out.print("[ ");
        for(int j = 0; j < gArr.length; j++) {
            System.out.printf("%s ", gArr[j]);
        }
        System.out.print("]\n");
    }
}
