package ires.corso.parttwo.classes;

public class SecondoPiatto extends Pietanza
{
    private boolean conContorno;

    public boolean isConContorno() {
        return conContorno;
    }

    public void setConContorno(boolean conContorno) {
        this.conContorno = conContorno;
    }

    public SecondoPiatto(String nome, int porzioni, boolean contornoSiNo)
    {
        // 1. Invoco costruttore classe parent
        super(nome, porzioni);

        // 2. inizializzo variabili interne
        this.conContorno = contornoSiNo;

        // 3. Regola standard per il prezzo
        this.setPrice(contornoSiNo? 8.0 * porzioni: 6.0 * porzioni);
    }

    public void prettyPrint(){
        System.out.println("Sta arrivando il secondo . . . ");
        System.out.printf("Ecco servito %d di %s\n",this.porzioni ,this.nome);
        setArrivato(true);
    }
}