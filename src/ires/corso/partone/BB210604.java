package ires.corso.partone;

// Riferimenti bibliografici:
// https://www.amazon.it/OCA-Java-Programmer-Certification-Guide/dp/1617293253
// https://www.amazon.it/gp/product/B07G8DHTSZ/ref=dbs_a_def_rwt_bibl_vppi_i0
// https://www.amazon.it/Thinking-Java-Advanced-Features-Updated-ebook/dp/B00QL7C4F0/ref=sr_1_1?__mk_it_IT=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=eckel+thinking+in+java&qid=1622814860&s=digital-text&sr=1-1
//
// JLS + Tutorial (Oracle):
// https://docs.oracle.com/javase/specs/jls/se16/html/index.html
// https://docs.oracle.com/javase/tutorial/java/index.html
//
// Esercizi:
// https://codingbat.com/java
//
public class BB210604
{
    public static void main(String[] args)
    {
        int a = Integer.parseInt("-123");
        int b = 234;
        boolean intBool = (a == b);

        // String s1 = "Marcello";
        // String s1 = new String("Marcello");
        // String s2 = s1; // la "reference" s2 PUNTA alla stessa istanza dell'oggetto String puntata da s1

        String s1; // reference "vuota"
        String s2; // reference "vuota"

        s1 = "Marcello"; // ==> in realtà equivale a: s1 = new String("Marcello") <== CONSTRUCTOR
        s2 = s1; // le due references PUNTANO alla stessa ISTANZA di String

        boolean b1 = (s2 == s1); // otteniamo TRUE

        s1 = new String("Ires"); // Prima istanza di String contenente "Ires"
        s2 = new String("Ires"); // Seconda istanza di String contenente "Ires"
        boolean b2 = (s2 == s1);    // otteniamo FALSE
        boolean b3 = s1.equals(s2); // otteniamo TRUE

        System.out.println("carattere scelto: " + s1.charAt(2));
        String s3 = s1.concat(s2);
        System.out.println("concatenazione: " + s3);
        if(s1.endsWith("es")) System.out.println("Termino con 'es'");

        String spl1 = "I am learning Java";
        String[] splArray = spl1.split(" ");
        System.out.println(splArray[0] + "|" + splArray[1] + "|" + splArray[2] + "|" + splArray[3]);

        String mn = "MARCELLO";
        int address = 111;
        String sf = String.format("Mi chiamo %s e abito al numero %d", mn, address);
        System.out.println(sf);
    }
}
