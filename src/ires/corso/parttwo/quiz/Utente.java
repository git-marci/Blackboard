package ires.corso.parttwo.quiz;

public class Utente {
    //mantiene l'identità dell' utente
    //gli permette di eseguire un quiz;
    //raccolta delle risposte dell'utente;
    private final String id;
    private int score;

    public Utente(String id){
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getId() {
        return id;
    }
}
