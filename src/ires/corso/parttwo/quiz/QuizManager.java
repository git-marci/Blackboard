package ires.corso.parttwo.quiz;

import java.io.IOException;
import java.util.Iterator;

public class QuizManager {

    public static void main(String[] args) throws IOException {
      //1 Chiede all'utente l'autenticazione
      //2 Chiede all'utente quale quiz vuole fare
      //3 Riceve risposta utente e istanzia il quiz corretto
        //4 Loop del quiz
        //5 Mostra il punteggio
        //6 Chiede se uscire o farne un altro
        Quiz q = Lettore.CreateFromFile("provaQuiz.txt");
        //q.printQuiz();
        Iterator<Domanda> itr = q.getQuizIterator();
        while(itr.hasNext()) {
            Domanda domanda = itr.next();
            Lettore.printToScreen(domanda.prettyPrint());
            do {
                String s = Lettore.askForInput("Specifica quali sono le risposte giuste separandole con una virgola (es A,B) " +
                        "oppure un # per uscire");
                if (s.equals("#"))
                    break;
                else{
                    String[] arrStr = s.split(",");
                }
            } while(true);
        }
    }
}
