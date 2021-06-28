package ires.corso.parttwo.todo;

public class Sketch
{
    // TO DO List
    // - Funzione principale: mantenere una lista delle "cose da fare", completa dello stato di ciascuna di esse
    // - lo "stato" deve comprendere almeno: DA_FARE, IN_ESECUZIONE, COMPLETATA, ANNULLATA
    // - le proprietà di un "TO DO" sono almeno: id, titolo, descrizione, data di inserimento,
    //   data di consegna, priorità, stato

    // Tra un'esecuzione e l'altra del programma, lo stato delle issues deve essere salvato.

    // Le operazioni che devono essere possibili sono molteplici...
    // ------------------------------------------------------------
    // Davide ==> cambiare lo stato
    // Stefano ==> Aggiungere e togliere cose da fare
    // Alessandro ==> modificare i dati di un to do: data consegna, priorità, titolo, descrizione
    // Niki ==> report delle cose da fare su .txt, ordinato per priorità
    // Alberto ==> oppure report ordinato a video per data di scadenza
    // Marcello ==> funzione di filtro

    // Descrizione di massima del funzionamento
    // ----------------------------------------
    // Niki: entro nel programma, c'è un titolo con delle istruzioni eseguibili (menu) e ogni volta che ho finito di
    //       eseguire una istruzione il menu ricompare
    // Agnese: questo è il menu
    //         01. Aggiungere un TO DO
    //         02. Visualizzare lista TO DO
    //         03. Rimuovere un TO DO
    //         04. Modificare un TO DO
    //         05. Stampare la lista (export su file)
    //         06. Importare TO DO da file
    //         07. Uscita dal programma
    // Stefano: usiamo 3 livelli
    //         01. Visualizza
    //             01. Per priorità
    //             02. Per data
    //             03. Per stato
    //         02. Aggiungi, Rimuovi, Modifica
    //             01. Aggiungi (titolo, descrizione, data consegna, priorità)
    //             02. Rimuovi (si passa: id)
    //             03. Modifica (si passa: id, data di consegna, priorità, stato)
    //         03. Import/Export
    //             01. Export su file
    //             02. Import da file
    //         04. Uscita

    // Provate a fare un'ipotesi delle classi a supporto:
    // --------------------------------------------------
    // - una classe rappresenta l'utente
    // - una classe rappresenta un "to-do" (1 to-do = 1 cosa da fare)
    // - un'altra classe deve rappresentare il menu/le azioni effettivamente eseguibili
    // - "quizmanager" diventa ==> "todolist-manager"
    // - pensate bene a un gestore dell'input/output (cfr. la classe "lettore" di quiz)

    // Per l'analisi:
    //
    // GRUPPO 1: Agnese, Fabiola, Veronica
    //         01. Visualizza
    //             01. Per priorità *
    //             02. Per data **
    //             03. Per stato ***
    //
    // GRUPPO 2: Davide, Alberto, Stefano
    //         02. Aggiungi, Rimuovi, Modifica
    //             01. Aggiungi (titolo, descrizione, data consegna, priorità) *
    //             02. Rimuovi (si passa: id) **
    //             03. Modifica (si passa: id, data di consegna, priorità, stato) ***
    //
    // GRUPPO 3: Niki, Gabriele G., Gabriele M.
    //         03. Import/Export
    //             01. Export su file *
    //             02. Import da file **
    //         04. Uscita ***
    //
    // GRUPPO 4: Daniele, Alessandro, Alessio
    //         - Gestione persistenza su file *
    //         - Gestione del MENU (come si mostrano/lanciano i vari comandi) **
}
