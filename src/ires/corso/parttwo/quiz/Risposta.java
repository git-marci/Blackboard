package ires.corso.parttwo.quiz;

public class Risposta {
    //risposte ad ogni domanda;
    private String testo; //AGGIUNGERE FINAL A QUESTA PROPERTY RENDEVA LA CLASSE INACCESSIBILE DALLE ALTRE
    public Risposta(String risp){
        this.testo = risp;
    }

    public String getTesto() {
        return testo;
    }
}
