package ires.corso.parttwo;

import java.util.Arrays;

public class BB210616 {
    public static int a;

    public static class TestObj {
        final private String constProperty;
        private String testString;

        public TestObj(String s, String cs) {
            testString = s;
            constProperty = cs;
        }

        public String getTestString() {
            return testString;
        }

        public void setTestString(String testString) {
            this.testString = testString;
        }

        public String toString() {
            return "[CONTENT: " + testString + ", " + constProperty + "]";
        }
    }

    public static void main(String[] args) {
        // Come si passano gli argomenti nelle funzioni
        //
        // ==> tipi di dati primitivi: passaggio per "VALORE"
        //     - è come nel metodo se ricevessimo una COPIA del valore originale
        //     - la variabile originale NON viene modificata
        int myInt = 100;

        testOne(myInt);
        System.out.println("Quanto vale myInt ==> " + myInt);

        int myComputedValue;
        myComputedValue = testTwo(myInt); // Dobbiamo scrivere esplicitamente che "riceviamo" un valore "modificato"
        myInt = testTwo(myInt); // Si può fare ma attenzione: cambiamo il "senso" di una variabile, usato specie nei loop
        System.out.println("Quanto vale myComputedValue ==> " + myComputedValue);

        int i, j, k; // sono "interi di servizio" di solito usato senza significato particolare

        // ==> Stringhe
        //     - sono oggetti ma in Java nei metodi un oggetto viene passato come COPIA (valore) della reference
        //     - in un metodo possiamo modificare l'oggetto al quale punta la reference ma esternamente rimane invarata
        String s = "Marcello";
        String sObj = new String("Marcello");
        testThree(s);
        System.out.println("Quanto vale s ==> " + s);
        testThree(sObj);
        System.out.println("Quanto vale sObj ==> " + sObj);

        // ==> Objects
        //     - in Java un oggetto viene passato come COPIA (valore) della reference
        //     - se modifichiamo l'oggetto cui punta la reference, nel chiamante non abbiamo side effects
        //     - però attenzione: possiamo MODIFICARE L'OGGETTO ATTRAVERSO I SUOI METODI!!!
        TestObj to1 = new TestObj("Java", "MM");
        TestObj to2 = new TestObj("C++", "MM");

        System.out.println("Cosa contiene to1 prima del metodo ==> " + to1.getTestString());
        System.out.println("Cosa contiene to2 prima del metodo ==> " + to2.getTestString());
        testFour(to1, to2);
        System.out.println("Cosa contiene to1 DOPO il metodo ==> " + to1.getTestString());
        System.out.println("Cosa contiene to2 DOPO il metodo ==> " + to2.getTestString());

        // ==> Array
        //     - in Java un array è un oggetto
        //     - vale quanto visto a proposito degli oggetti: si passa una copia del valore della reference
        //     - ma... gli elementi?
        int[] intArr = {1, 2, 3};
        System.out.println("Array prima del metodo 5: " + Arrays.toString(intArr));
        testFive(intArr);
        System.out.println("Array dopo il metodo 5: " + Arrays.toString(intArr));

        System.out.println("Array prima del metodo 6: " + Arrays.toString(intArr));
        testSix(intArr);
        System.out.println("Array dopo il metodo 6: " + Arrays.toString(intArr));

        // ==> Array di OGGETTI
        //     - posso agganciare ad una posizione dell'array una nuova ISTANZA!
        TestObj[] toArr = {new TestObj("UNO", "MM"), new TestObj("DUE", "MM")};
        System.out.println("Array di oggetti prima del metodo 7: " + Arrays.toString(toArr));
        testSeven(toArr);
        System.out.println("Array di oggetti DOPO il metodo 7: " + Arrays.toString(toArr));
    }

    // Funzione che modifica il valore di un argomento di tipo primitivo: no "side effetcs"
    public static void testOne(int a) {
        int internalInt = a; // copia di inizializzazione, poi si modifica internalInt
        internalInt = 200; // OK!

        // NO!
        a = 200; // scrittura "impropria": non si devono modificare gli argomenti di un metodo...
    }

    public static int testTwo(int a) {
        int internalInt = a;

        // Mettiamoci un po' di "logica"
        internalInt = internalInt * 2;

        // Modo giusto di propagare le modifiche all'esterno: dichiaro un tipo
        // del risultato e lo offro al chiamante come risultato della funzione
        return internalInt;
    }

    public static void testThree(String s) {
        System.out.println("-- Inizialmente s NEL METODO vale ==> " + s);
        s = new String("Ires"); // NON FARE!
        System.out.println("-- Alla fine s NEL METODO vale ==> " + s);
    }

    public static void testFour(TestObj o1, TestObj o2) {
        o1.setTestString("MODIFICA");
        o2.setTestString("FINALE");
    }

    public static void testFive(int[] arr) {
        arr = new int[]{4, 5, 6}; // uso IMPROPRIO di un argomento di funzion, ma NO side effects...
    }

    public static void testSix(int[] arr) {
        arr[0] = 4;
        arr[1] = 5;
        arr[2] = 6;
    }

    public static void testSeven(TestObj[] arr) {
        arr[0] = new TestObj("TRE", "IRES");
        arr[1] = new TestObj("QUATTRO", "IRES");
    }
}
