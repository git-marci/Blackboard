package ires.corso.parttwo.classes;

public class Person
{
    public static Person getAPersonDeep(String name)
    {
        Person p = new Person(name);

        Document doc = null;
        // Ricerca documenti della persona su database...
        // 1. apro conn. con DB
        // 2. cerco nella tabella documenti
        // 3. recupero documento presente per il nome passato in input
        // 4. aggancio il documento con il setter

        p.setIdDocument(doc);
        return p;
    }

    public static Person getAPersonWithDocument(String name, Document doc) {
        Person p = new Person(name);
        p.setIdDocument(doc);
        return p;
    }

    public static Person getANewPerson(String usr, String pwd)
    {
        // ...Controllo se usr/password sono corretti
        if(usr.equals("Marcello") || usr.equals("Fabiola")) {
            return new Person(usr);
        }
        else {
            System.out.println("Non sei autorizzato ad usare questo software");
            return null;
        }
    }

    //public String name;
    private String name;
    private Document idDocument;
    //protected String name;

    /*
    public Person () {
        // non fare niente
    }
    */

    private Person (String name) {
        this.name = name;
    }

    public void PrettyPrint() {
        System.out.println("Il mio nome è: " + this.name);
    }

    // METODO GETTER ==> restituisce il valore di una variabile "interna" private
    public String unconventionlGetName() {
        return name;
    }

    // METODO SETTER ==> imposta il valore di una variabile "interna" private
    /*
    public void aVeryStrangeSetName(String name) {
        this.name = name;
    }
    */

    private void setIdDocument(Document idDocument) {
        this.idDocument = idDocument;
    }

    // Relazione di dipendenza: USA la classe Car
    public void moveByCar(int distance, Car c) {
        c.Spostati(distance);
    }

    public Car chooseACar() {
        // vado in un negozio e mi compro una macchina...
        return new Car();
    }
}

