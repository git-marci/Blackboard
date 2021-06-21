package ires.corso.parttwo;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class BB210621
{
    public static void main(String[] args) {

    }

    public static void readAFile() throws IOException {
        String wd = System.getProperty("user.dir");
        System.out.println(wd);

        Scanner fileIn = new Scanner(Paths.get("C:\\temp\\newScanFile.txt"));
        while (fileIn.hasNextLine()) {
            String data = fileIn.nextLine();
            System.out.println(data);
        }
        fileIn.close();
    }

    public static void JavaQuiz()
    {
        // Implementare un programma in Java che:
        // 1. legge da file una serie di domande con risposte multiple (contrassegnate da lettera) e la risposta
        //    corretta per ciascuna domanda: nota, le domande saranno sul linguaggio java
        // 2. utilizzando una classe QUIZ che contiene ("aggregation") istanze di una classe ANSWER, costruisce una
        //    struttura di oggetti che rappresenta il questionario
        // 3. implementi il loop di risoluzione del quiz, accettando risposte da un utente che lancia il programma,
        //    dichiarando il suo nome e cognome
        // 4. alla fine, visualizza il punteggio totale ottenuto come somma dei punti/totale dei punti

        // NOTA:
        // -----
        // - il numero di risposte giuste può essere > 1
        // - il numero di risposte a una domanda può variare idefinitamente
        // - il numero di domande deve essere variabile
    }
}
