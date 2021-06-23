package ires.corso.parttwo.quiz;

import java.util.ArrayList;
import java.util.Iterator;

public class Quiz
{
    //Raccoglie insieme di domande (class Domanda)e risposte corrette;
    //Tiene il loop per l'esecuzione del quiz;
    //All'interno del loop confronto l'input con i dati della domanda
    private ArrayList<Domanda> domande = new ArrayList<>();

    public void addDomanda(Domanda dom){
        domande.add(dom);
    }

    public void printQuiz(){
        for(Domanda d: domande){
            System.out.println(d.prettyPrint());
        }
    }

    public void printQuestion(int i){
        if (i < domande.size())
            System.out.println(domande.get(i).prettyPrint());
        else
            System.out.println("Indice fuori scala");
    }

    public Iterator<Domanda> getQuizIterator(){
        return domande.iterator();
    }

}
//commento