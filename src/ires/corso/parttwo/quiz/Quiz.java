package ires.corso.parttwo.quiz;

import java.util.ArrayList;

public class Quiz
{
    //Raccoglie insieme di domande (class Domanda)e risposte corrette;
    //Tiene il loop per l'esecuzione del quiz;
    //All'interno del loop confronto l'input con i dati della domanda
    ArrayList<Domanda> domande = new ArrayList<>();

    public void addDomanda(Domanda dom){
        domande.add(dom);
    }

    public void printQuiz(){
        for(Domanda d: domande){
            System.out.println(d.prettyPrint());
        }
    }

}
//commento