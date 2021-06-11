package ires.corso.parttwo.classes;

public class Person
{
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
}

