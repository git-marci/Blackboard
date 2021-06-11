package ires.corso.parttwo.classes;

public class Pietanza
{
    // Variabile static ==> ereditata dalle classi figlie
    static boolean isActive = false;

    protected String nome;
    protected int porzioni;
    protected boolean arrivato = false;
    protected double price = 0.0;

    protected Pietanza(String nome, int porzioni) {
        setNome(nome);
        setPorzioni(porzioni);
        arrivato = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPorzioni() {
        return porzioni;
    }

    public void setPorzioni(int porzioni) {
        this.porzioni = porzioni;
    }

    public boolean isArrivato() {
        return arrivato;
    }

    public void setArrivato(boolean arrivato) {
        this.arrivato = arrivato;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double acceptPayment(double dollars) {
        if(dollars >= price) {
            System.out.println("OK pagamento accettato");
        }
        else {
            System.out.println("I soldi non bastano");
        }
        return dollars - price;
    }
}
