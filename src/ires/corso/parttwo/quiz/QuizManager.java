package ires.corso.parttwo.quiz;

import java.io.IOException;
import java.util.Iterator;

public class QuizManager
{
    public static void main(String[] args) throws IOException
    {
        //1 Chiede all'utente l'autenticazione
        //2 Chiede all'utente quale quiz vuole fare
        //3 Riceve risposta utente e istanzia il quiz corretto
        //4 Loop del quiz
        //5 Mostra il punteggio
        //6 Chiede se uscire o farne un altro

        Quiz q = Lettore.CreateFromFile("provaQuiz.txt");
        //q.printQuiz();

        boolean quit = false; // uscita dal quiz
        boolean answered = false; // riposta ad una data domanda

        Iterator<Domanda> itr = q.getQuizIterator();
        while(itr.hasNext() && !quit) {
            Domanda domanda = itr.next();
            Lettore.printToScreen("\n--------------------------------------------------------------------------------");
            Lettore.printToScreen(domanda.prettyPrint());
            answered = false;
            do {
                Lettore.printToScreen("\nSpecifica quali sono le risposte giuste separandole con una virgola");
                Lettore.printToScreen("ad esempio: \"A,B\", oppure inserisci un # per uscire.");
                String s = Lettore.askForInput("La tua risposta ==>");
                if (s.equals("#"))
                    quit = true;
                else {
                    String[] arrStr = s.split(",");
                    if(arrStr.length > 0) {
                        boolean stringCheck = true;
                        for(int i = 0; i < arrStr.length; i++) {
                            String l = arrStr[i];
                            if(l.length() != 1 || !Character.isLetter(l.charAt(0))) {
                                Lettore.printToScreen("Inserisci solo lettere maiuscole, senza altri caratteri...");
                                stringCheck = false;
                                break;
                            }
                        }
                        answered = stringCheck;
                    }
                    else {
                        Lettore.printToScreen("Inserisci lettere maiuscole separate da virgole...");
                    }
                }
            } while(!quit && !answered);
        }
        if(quit) {
            Lettore.printToScreen("Hai abbandonato il quiz! Peccato...");
        }
        else {
            // calcoliamo il punteggio
        }
    }
}
