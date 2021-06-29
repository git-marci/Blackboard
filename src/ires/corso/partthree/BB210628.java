package ires.corso.partthree;

import java.io.*;

public class BB210628
{
    public static void main(String[] args)
    {
        // Tips for using exceptions...

        // 1. Le eccezioni non sostituiscono i semplici controlli del codice...
        //    (non si può pensare di gestire tutto con le eccezioni, perchè da un punto di vista
        //    delle performance COSTANO)
        //
        //    Esempio:
        String s = null;

        // Se posso risolvere con un controllo nel codice...
        if(s != null)
            System.out.println("Lunghezza della stringa = " + s.length());
        else
            System.out.println("...ah la stringa è nulla!");

        // allora non NON GESTIRE CON EXCEPTION...
        try {
            System.out.println("Lunghezza della stringa = " + s.length());
        }
        catch(NullPointerException npe) {
            System.out.println("...ah la stringa è nulla!");
        }

        // 2. Evitare "micromanagement" delle exceptions...
        //    (= non usare un blocco try/catch per ciascuno statement)
        //    Piuttosto, usare catch separati per eccezioni di tipo diverso!

        // 3. DO NOT SHUT UP EXCEPTIONS!!!

        // Cosa da NON fare...
        try {
            // do something
        }
        catch(Exception e) {} // Non si fa niente...

        // 4. Propagare eccezioni non è necessariamente IL MALE!
    }

    // Try/catch/finally CLASSIC
    private void copyLinesClassic() throws IOException
    {
        // try/catch/finally
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("xanadu.txt"));
            outputStream = new PrintWriter(new FileWriter("lines.txt"));

            String l;
            while ((l = inputStream.readLine()) != null) {
                System.out.println(l);
                outputStream.println(l);
            }
        }
        catch(IOException iox) {
            // ...
            throw iox;
        }
        finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    // Try with resources
    private void copyLinesNew() throws IOException
    {
        try(BufferedReader inputStream = new BufferedReader(new FileReader("xanadu.txt"));
            PrintWriter outputStream = new PrintWriter(new FileWriter("lines.txt")))
        {
            String l;
            while ((l = inputStream.readLine()) != null) {
                System.out.println(l);
                outputStream.println(l);
            }
        }
        catch(IOException iox) {
            // ...
            throw iox;
        }
        finally {
            // posso fare altre cose...
        }
    }
}
