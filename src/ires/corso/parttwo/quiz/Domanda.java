package ires.corso.parttwo.quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Domanda
{
    //Rappresenta una domanda del quiz;
    // Raccolta totale delle possibili risposte di una domanda;
    // Stringa con le lettere delle risposte corrette
    // Detiene la logica di confronto tra risposte giuste e sbagliate
    //Validazione input utente fatte con regex
    //Metodo che accetta input utente
    private int indexDomanda;
    private String testDomanda;
    private Map<Character, Risposta> risposte = new TreeMap<>();
    private ArrayList<Character> indiciRisposteGiuste= new ArrayList<>();
    private Risposta rispostaGiusta;

    public Domanda(String text) {
        this.testDomanda = text;
    }

    public void addIndiceRispostaGiusta(Character indice){
        indiciRisposteGiuste.add(indice);
    }
    public void addRisposta(Character key, Risposta risp){
        risposte.put(key, risp);

    }
    public String prettyPrint(){
        StringBuilder sb = new StringBuilder();
        sb.append(testDomanda);
        sb.append("\n");
        for(Risposta r:risposte.values()) {
            sb.append(r.getTesto());
            sb.append("\n");
        }
        return sb.toString();
    }

    //algoritmo di confronto tra risposte utente e risposte giuste
    public RispostaUtente submitAnswer(String[] arrStr){

      return null;
    }
}
