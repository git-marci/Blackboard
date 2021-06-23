package ires.corso.parttwo.quiz;

import java.util.ArrayList;

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
    private ArrayList<Risposta> risposte= new ArrayList<>();
    private Risposta rispostaGiusta;

    public Domanda(String text) {
        this.testDomanda = text;
    }

    public void addRisposta(String risposta){

    }
}
