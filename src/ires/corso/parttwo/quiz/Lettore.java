package ires.corso.parttwo.quiz;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Lettore {
    private static ArrayList<String> readAFile(String path) throws IOException {
        Scanner fileIn = new Scanner(Paths.get(path));
        ArrayList<String> linee = new ArrayList<>();

        while (fileIn.hasNextLine()) {
            linee.add(fileIn.nextLine());
        }
        fileIn.close();
        return linee;
    }

    //Gestisce input utente
    //Si occupa di leggere da file le domande
    //Gestisce output utente
    public static Quiz CreateFromFile(String path) throws IOException {
        // 1. leggo contenuto del file
        ArrayList<String> linee = readAFile(path);

        // 2. looppone per creare il quiz
        Quiz q = new Quiz();
        for (String s : linee) {

            String[] domandeRisposte = s.split(";");
            //domandeRisposte[0] è sicuramente una domanda
            Domanda question = new Domanda(domandeRisposte[0]);

            //dichiaro le variabili per il loop che verranno inserite nella map delle risposte
            char indicecorrente;
            String testorisposta;

            for (int i = 1; i < domandeRisposte.length; i++) {
                indicecorrente = domandeRisposte[i].charAt(0);
                testorisposta = Character.toUpperCase(indicecorrente) + domandeRisposte[i].substring(1);
                if (Character.isLowerCase(indicecorrente)) {
                    question.addIndiceRispostaGiusta(indicecorrente);
                }
                question.addRisposta(indicecorrente, new Risposta(testorisposta));
            }
            q.addDomanda(question);
        }

        return q;
    }
}