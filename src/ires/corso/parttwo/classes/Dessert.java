package ires.corso.parttwo.classes;

public class Dessert extends Pietanza
{
    // Gestione del flag per abilitare i dessert
    public static void activateDesserts(boolean flag) {
        isActive = flag;
    }

    public static Dessert orderDessert(String nome, int porzioni) {
        if(!isActive) {
            System.out.println("I dessert NON sono attivi: la caffetteria non ha ancora aperto");
            return null;
        }
        else {
            System.out.println("La caffetteria ha aperto: ok per il tuo dessert!");
            return new Dessert(nome, porzioni);
        }
    }

    // Costruttore privato
    private Dessert(String nome, int porzioni) {
        super(nome, porzioni);
        this.setPrice(3.0 * porzioni);

    }

    public void prettyPrint(){
        System.out.println("Sta arrivando il dessert . . .");
        System.out.printf("Ecco servito %d di %s\n",this.porzioni ,this.nome);
        setArrivato(true);
    }

    @Override
    public double acceptPayment(double dollars) {
        if(dollars >= price) {
            System.out.println("OVERRIDE: Tutto ok con la gelateria di fronte");
        }
        else {
            System.out.println("OVERRIDE: la gelateria si lamenterà");
        }
        return dollars - price;
    }
}