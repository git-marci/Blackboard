package ires.corso.parttwo;

import java.io.*;

public class BB210624
{
    // I/O
    public static void main(String[] args)
    {
        // Esempio di input da Console
        /*
        Console c = System.console();
        c.printf("- Inserisci la tua login:\n");
        String s = c.readLine();
        c.writer().println("- Buongiorno " + s);
        c.writer().println();
        */

        System.out.println("Inizio programma di I/O");
        try {
            // copyBytes(); NO!
            // copyCharacters(); NO!
            copyLines(); // <== UTILIZZIAMO QUESTO!
        }
        catch(Exception e) {
            System.out.println("Si è verificata un'eccezione...");
        }
        System.out.println("Fine del programma");
    }

    // Usando i byte streams
    public static void copyBytes() throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            /*
                FileInputStream ==> eredita da InputStream, classe root per gli stream di bytes in input
                FileOutputStream ==> eredita da OutputStream, classe root per gli stream di bytes in output
            */
            in = new FileInputStream("xanadu.txt");
            out = new FileOutputStream("outagain.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        }
        /*
        catch(Exception e) {
            // Gestione dell'eccezione: log su file/su console
        }
         */
        finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    // Usando character streams
    public static void copyCharacters() throws IOException {
        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            /*
                FileReader ==> InputStreamReader ==> Reader
                |
                |--> utilizza FileInputStream al suo interno

                FileWriter ==> OutputStreamWriter ==> Writer
                |
                |--> utilizza FileOutputStream al suo interno

                Reader e Writer sono due classi astratte, root rispettivamente
                delle classi di lettura/scrittura di Character
             */
            inputStream = new FileReader("xanadu.txt");
            outputStream = new FileWriter("characteroutput.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                System.out.println(c);
                outputStream.write(c);
            }
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

    // Usando oggetti "buffered" che ragionano per linee di testo...
    public static void copyLines() throws IOException
    {
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
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
