package ires.corso.parttwo;

import ires.corso.parttwo.io.ThePrinter;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

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
            copyLines(); // <== UTILIZZIAMO QUESTO COME "VECCHIO INPUT"
            copyStreams(); // <== NUOVO INPUT (Java 8)
        }
        catch(IOException | SQLException e) {
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
        catch(IOException e) {
            // Gestione dell'eccezione: log su file/su console
            // poi la rilancio...
            throw e;
        }
        finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            }
            catch(IOException e) {
            }
            // Gestione deve essere fatta, altrimenti l'eccezione è "silenziata" senza risolverla!
        }
    }

    // Usando character streams
    public static void copyCharacters() throws IOException {
        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            /*
                FileReader ==> InputStreamReader ==> Reader
                │
                └──> utilizza FileInputStream al suo interno

                FileWriter ==> OutputStreamWriter ==> Writer
                │
                └──> utilizza FileOutputStream al suo interno

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

    /* Java 8 */
    public static void copyStreams() throws SQLException
    {
        ThePrinter tp = new ThePrinter();

        try {
            List<String> list = Files.readAllLines(Paths.get("xanadu.txt"));
            Iterator<String> is = list.iterator();
            while(is.hasNext()) {
                tp.printSomething(is.next());
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        catch(NullPointerException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        catch(ArithmeticException e) {
            e.printStackTrace();
        }

        // read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get("xanadu.txt"))) {
            stream.map(String::toUpperCase)
                  .filter(s -> !s.startsWith("I"))
                  .forEach(tp::printSomething);
                  //.forEach(System.out :: println);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        if(true) throw new SQLException();
    }

    /* Java NIO - non-blocking reading  */
    public static void readNIOFile() throws IOException {
        BufferedReader reader = null;
        try {
            Path inputFile = Paths.get("xanadu.txt");
            reader = Files.newBufferedReader(inputFile, Charset.defaultCharset());
            String lineFromFile = "";
            while ((lineFromFile = reader.readLine()) != null) {
                System.out.println(lineFromFile);
            }
        } catch (IOException e){
            System.out.println(e);
        } finally {
            if(reader != null)
                reader.close();
        }
    }

    /* Java NIO - non-blocking writing */
    public static void writeFile() throws IOException {
        BufferedWriter writer = null;
        try {
            Path outputFile = Paths.get("niooutput.txt");
            writer = Files.newBufferedWriter(outputFile, Charset.defaultCharset());
            StringBuilder message = new StringBuilder("This is a message going into the file.");
            writer.append(message);
        } catch (IOException e){
            System.out.println(e);
        } finally {
            if(writer != null)
                writer.close();
        }
    }
}
