package ires.corso.parttwo.classes;

public class PrimoPiatto extends Pietanza
{
    public static final int BEST_NUM_SPAGHETTI = 100; // Costante

    // ...include "gratis" tutto ciò che è definito in Pietanza
    private boolean conParmigiano = false;
    private boolean inBrodo = false;

    public boolean isConParmigiano() {
        return conParmigiano;
    }

    public void setConParmigiano(boolean conParmigiano) {
        this.conParmigiano = conParmigiano;
    }

    public boolean isInBrodo() {
        return inBrodo;
    }

    public void setInBrodo(boolean inBrodo) {
        this.inBrodo = inBrodo;
    }

    public PrimoPiatto(String nome,int porzioni, boolean parmigianoSiNo, boolean inBrodoSiNo)
    {
        // Chiamata "normale" a un metodo: è il costruttore della classe PARENT
        super(nome, porzioni);

        // Regola standard per il prezzo
        this.setPrice(5.0 * porzioni);

        // Compito standard di un costruttore: inizializzazione delle variabili interne
        this.conParmigiano = parmigianoSiNo;
        this.inBrodo = inBrodoSiNo;
    }

    public void prettyPrint(){
        System.out.println("Sta arrivando il primo . . .");
        System.out.printf("Ecco servito %d di %s\n", this.porzioni, this.getNome());
        setArrivato(true);
    }

    @Override
    public double acceptPayment(double dollars) {
        if(dollars >= price) {
            System.out.println("OVERRIDE: La gastronomia nostra fornitrice è contenta");
        }
        else {
            System.out.println("OVERRIDE: la gastronomia si lamenterà");
        }
        return dollars - price;
    }

    @Override
    public String getNome() {
        return ("PRIMO PIATTO: " + super.getNome());
    }
}