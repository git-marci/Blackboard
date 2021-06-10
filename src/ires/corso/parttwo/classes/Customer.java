package ires.corso.parttwo.classes;

// Una classe può avere al suo interno...
public class Customer
{
    // Membri STATIC
    // - sono variabili della CLASSE: ce n'è una sola copia
    // - gli oggetti possono vederle
    // - dall'esterno sono visibili se sono "public"
    private static long counter = 0;

    // Esempio: costanti per definire "graduatoria" dei clienti
    private static final String CUSTOMER_PREMIUM = "PREMIUM";
    private static final String CUSTOMER_NORMAL = "NORMAL";
    private static final String CUSTOMER_BAD = "BAD";

    // Quanti customer abbiamo?
    public static long howManyCustomers() {
        return counter;
    }

    // creao altri customers
    public static Customer giveMeANewCustomer(String name, String surname) {
        System.out.println("Sto creando un nuovo customer...");
        String sid = String.format("%d", ++counter);
        return new Customer(sid, name, surname);
    }

    // ----------------------------------

    // Variabili di ISTANZA
    // - se NON sono static, allora sono variabili degli oggetti creati con questa classe
    // - ogni oggetto ne ha la propria copia "personale"
    // - dall'esterno sono visibili se "public"
    // - di solito si usano getter/setter

    //private long id;
    private String stringId;
    private String name;
    private String surname;
    private String level;

    private Customer(String stringId, String name, String surname) {
        this.stringId = stringId;
        this.name = name;
        this.surname = surname;
        this.level = CUSTOMER_NORMAL;
    }

    public Customer(String name, String surname)
    {
        this.stringId = String.format("%d", ++counter);

        //this.stringId = String.format("%d", ++counter);
        // ...equivale a:
        // {
        //      counter = counter + 1
        //      this.stringId = String.format("%d", counter);
        // }

        //this.stringId = String.format("%d", counter++);
        // ...equivale a:
        // {
        //      this.stringId = String.format("%d", counter);
        //      counter = counter + 1
        // }

        this.name = name;
        this.surname = surname;
        this.level = CUSTOMER_NORMAL;
    }

    // Metodi getter/setter

    // id
    public long getId() {
        long id = Long.parseLong(stringId);
        return id;
    }
    /*
    public void setId(long id) {
        if(id > 0) {
            //this.id = id;
            this.stringId = String.format("%d", id);
        }
        else
            System.out.println("Niente da fare: mi devi dare un id > 0"); // Dovrebbe essere una exception!
    }
    */

    // name
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        if(name.length() > 0)
            this.name = name;
        else
            System.out.println("Voglio un nome di lunghezza > 0");
    }

    // surname
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        if(surname.length() > 0)
            this.surname = surname;
        else
            System.out.println("Voglio un cognome di lunghezza > 0");
    }

    // esempio di metodo che sfrutta le variabili interne per dare informazioni sull'oggetto
    public String getInfo() {
        return ("Mi chiamo: " + name + " " + surname + " e sono di livello: " + level);
    }
    public String getInfo(String msg) {
        return ("Mi chiamo: " + name + " " + surname + " e sono di livello: " + level + " e ti dico: " + msg);
    }

}
