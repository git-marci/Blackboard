package ires.corso.parttwo;

import ires.corso.parttwo.classes.Person;

public class BB210611
{
    public static void main(String[] args)
    {
        // - inserire user + password
        // - mi collego a un sistema di autenticazione
        // - ottengo un oggetto Person che mi rappresenta
        // - utilizzo questo oggetto per chiamare altri servizi
        // Esempio: cashWithdrawal(Person p, Amopunt a)

        Person p1 = Person.getANewPerson("Marcello", "123");
        //Person p3 = new Person();
        //Person p1 = new Person("Marcello");
        //p1.name = "Marcello";
        //p1.aVeryStrangeSetName("Marcello");

        Person p2 = Person.getANewPerson("Fabiola", "456");
        //Person p2 = new Person("Fabiola");
        //p2.name = "Fabiola";
        //p2.aVeryStrangeSetName("Fabiola");

        Person p3 = Person.getANewPerson("Daniele", "789");

        System.out.println("Prima persona: " + p1.unconventionlGetName());
        System.out.println("Seconda persona: " + p2.unconventionlGetName());
    }
}
