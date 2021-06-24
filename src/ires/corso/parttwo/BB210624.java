package ires.corso.parttwo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BB210624
{
    // I/O
    public static void main(String[] args) {
        try {
            copyBytes();
        }
        catch(Exception e) {
            System.out.println("Si è verificata un'eccezione...");
        }
        System.out.println("...ma ho ancora il tempo di salutarti");
    }

    // Usando i byte streams
    public static void copyBytes() throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("xanadu.txt");
            out = new FileOutputStream("outagain.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        }
        catch(Exception e) {
            // Gestione dell'eccezione: log su file/su console
        }
        finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
