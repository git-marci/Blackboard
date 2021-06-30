package ires.corso.partthree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BB210630
{
    public static void main(String[] args)
    {
        List<String> theDishes = new ArrayList<>();
        theDishes.add("Porchetta");
        theDishes.add("Carbonara");
        theDishes.add("Diavola");

        // trasformiamo l'arraylist in uno stream
        Stream<String> dishStream = theDishes.stream();
        Stream<Long> dishNameLength = dishStream.map(s -> Long.valueOf(s.length()));

        // Pensate a
        // - un serbatoio (= la Collection a cui si applica il metodo stream()
        // - dei filtri (= metodo .filter dell'interfaccia Stream)
        // - degli iniettori di additivi (= metodo .map dell'interfaccia Stream)
        // - un rubinetto finale (operazioni terminali come forEach o reduce)

        // Qui devo effettivamente "estrarre" i valori dello stream,
        // quindi lo stream è aperto e i valori estratti dall'arraylist
        // sono prima processati con map e poi stampati a schermo
        dishNameLength.forEach(l -> System.out.println("La lunghezza del nome del piatto è: " + l));

        // NON FUNZIONA! Lo stream (serbatoio) è già stato "svuotato"
        // dishNameLength.forEach(l -> System.out.println("TI RIPETO che la lunghezza del nome del piatto è: " + l));
        theDishes
                .stream()
                .map(s -> Long.valueOf(s.length()))
                .map(l -> l * l)
                .forEach(l -> System.out.println("Il quadrato della lunghezza del nome del piatto è: " + l));

        List<Long> theDishNameLengthList = theDishes
                .stream()
                .map(s -> Long.valueOf(s.length()))
                .collect(Collectors.toList());
    }
}
