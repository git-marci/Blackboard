package ires.corso.partone;

public class BB210607 {

    public static void main(String[] args)
    {
        // OPERATORI
        // ---------
        System.out.println("test call"); // . ==> accede a un membro di classe/istanza

        int a = 1234;                    // (type) ==> casting
        long b = (long) a;               // = ==> assegna valore

        // +, -, *, /, %

        // ++, --
        int j = 0;
        j++;

        int i = 0;
        i += 123; // i = i + 1;

        // Operatori di confronto logico
        // >, <, >=, <=, ==, !=

        // Operatori su booleani
        // !, &&, ||
        boolean cond1 = true;
        boolean cond2 = false;
        boolean expr1 = !cond1;
        boolean expr2 = cond1 && cond2; // if(cond1 && cond2) {...} se la prima condizione è falsa, la seconda non viene considerata
        boolean expr3 = cond1 || cond2; // if(cond1 || cond2) {...} se la prima è vera è vera la seconda non viene considerata

        // Costrutto ternario
        int age = 18;
        String maggiorenne;

        boolean isMaggiorenne = (age > 18);
        maggiorenne = (age > 18) ? "maggiorenne": "minorenne"; // ELVIS

        String s = "test";
        if(s instanceof String) System.out.println("certo che è una stringa");

        // COSTRUTTI CONDIZIONALI e ITERATIVI
        String fg = "QUADRATO";

        switch(fg) {
            case "QUADRATO":
                System.out.println("sono un quadrato");
                break;
            case "TRIANGOLO":
                System.out.println("sono un triangolo");
                break;
            case "TRAPEZIO":
                System.out.println("sono un trapezio");
                break;
            default:
                System.out.println("non so chi sono");
                break;
        }

        // idem, con if + else if + else
        if(fg.equals("QUADRATO")) {
            System.out.println("sono un quadrato");
        }
        else if(fg.equals("TRIANGOLO")) {
            System.out.println("sono un triangolo");
        }
        else if(fg.equals("TRAPEZIO")) {
            System.out.println("sono un trapezio");
        }
        else {
            System.out.println("non so chi sono");
        }

        // WHILE/DO WHILE
        System.out.println("---------------------");
        int w = 0;

        // ...ciclo while con w
        while(w < 10) {
            System.out.println("Il valore di w ===> " + w);
            w++;
        }

        // do while...
        System.out.println("---------------------");
        int dw = 0;
        do {
            System.out.println("Il valore di dw ===> " + dw);
            dw++;
        } while (dw < 10);

        // Cicli for
        System.out.println("---------------------");
        for(int incr = 0; incr < 10; incr++) {
            System.out.println("Adesso ti dico il valore di incr... ");
            if(incr == 3) continue;
            System.out.println("Il valore di incr ===> " + incr);
            if(incr == 5) break;
        }

        for(int incr = 0; incr < 10; incr++) {
            System.out.println("Adesso ti dico il valore di incr... ");
            if(incr != 3) {
                System.out.println("Il valore di incr ===> " + incr);
            }
            if(incr == 5) break;
        }
    }
}
