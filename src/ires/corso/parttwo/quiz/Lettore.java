package ires.corso.parttwo.quiz;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Lettore
{
    private static ArrayList<String> readAFile(String path) throws IOException {
        Scanner fileIn = new Scanner(Paths.get(path));
        ArrayList<String> linee= new ArrayList<>();

        while (fileIn.hasNextLine()) {
            linee.add(fileIn.nextLine());
        }
        fileIn.close();
        return linee;
    }

    //Gestisce input utente
    //Si occupa di leggere da file le domande
    //Gestisce output utente
    public static Quiz CreateFromFile(String path) throws IOException
    {
        // 1. leggo contenuto del file
        ArrayList<String> linee= readAFile(path);

        // 2. looppone per creare il quiz
        Quiz q = new Quiz();
        for(String s: linee) {

            String[] domandeRisposte = s.split(";");
            //domandeRisposte[0] è sicuramente una domanda
            Domanda question = new Domanda(domandeRisposte[0]);
            for (int i = 1;i<domandeRisposte.length;i++){



            }
            // 1.  Da quante classi può ereditare una classe figlia?;A.  Quante se ne vuole;b.  Una;C. Due, una padre e una madre;


        }

        return null;
    }

    /*
Q02|Qual è l'ordine corretto delle fasi di trasformazione di un programma in "||||" software avendo adottato una soluzione ibrida?
A02.A|scrittura-compilazione-collegamento
A02.B|scrittura-compilazione-interpretazione
A02.C|scrittura-interpretazione




1.	Quali sono le componenti elementari di un programma?
A.	Istruzioni
B.	Costanti
C.	Espressioni
D.	Strutture dati
E.	Strutture di controllo
F.	Break point
G.	Variabili
H.	Strutture di verifica
I.	Compilatore

1.  Da quante classi può ereditare una classe figlia?;A.  Quante se ne vuole;b.  Una;C. Due, una padre e una madre;

2.	Qual è l'ordine corretto delle fasi di trasformazione di un programma in software avendo adottato una soluzione ibrida?
A.	scrittura-compilazione-collegamento
B.	scrittura-compilazione-interpretazione
C.	scrittura-interpretazione

3.	Quali tra le seguenti soluzioni generalmente offre una esecuzione del programma più lenta rispetto alle altre?
A.	compilazione
B.	interpretazione
C.	ibrido

4.	Quale tipologia di diagramma UML descrive al meglio le iterazioni tra gli utilizzatori di un programma e le sue funzionalità?
A.	Use case diagram
B.	Activity diagram
C.	Sequence diagram
D.	Class diagram
E.	State diagram

5.	Qual è la prima fase utile per la realizzazione di un programma?
A.	Raccolta dei requisiti
B.	Design
C.	Manutenzione


    */

}
