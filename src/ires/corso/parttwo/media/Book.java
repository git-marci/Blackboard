package ires.corso.parttwo.media;

import java.util.Objects;

public class Book implements Cloneable
{
    // Variabili "immutable"
    // - questo accorgimento (la parola "final") va benissimo
    //   quando le properties di una classe contengono p.es.
    //   la "identità" di un oggetto e non devono essere
    //   modificate nel corso del funzionamento del programma
    // - questo tipo di classe è anche chiamato "value object"
    private final String author;
    private final String title;
    private final String isbn;
    //private final int numPages;
    public int numPages;

    public Book(String author, String title, String isbn, int numPages) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.numPages = numPages;
    }

    @Override
    public boolean equals(Object o)
    {
        // 1. verifico che l'oggetto da confrontare non sia lo
        //    stesso sul quale invoco il metodo equals
        if (this == o) return true;

        // 2. verifichiamo che non sia nullo e che la classe
        //    dell'oggetto passato sia la stessa dell'oggetto
        //    sul quale invochiamo il metodo
        if (o == null || getClass() != o.getClass()) return false;

        // 3. Esegue il downcasting da Object a Book
        Book book = (Book) o;

        // 4. Verifica uguaglianza delle properties
        boolean result = false;
        result = (getNumPages() == book.getNumPages()) &&
                 (getAuthor().equals(book.getAuthor())) &&
                 (getTitle().equals(book.getTitle())) &&
                 (getIsbn().equals(book.getIsbn()));

        // 5. Restituisce risultato
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthor(), getTitle(), getIsbn(), getNumPages());
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", numPages=" + numPages +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Book book = new Book(this.author, this.title, this.isbn, this.numPages);
        return book;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNumPages() {
        return numPages;
    }

    // Questi metodi alterano lo stato dell'oggetto,
    // perchè cambiano il valore di una sua proprietà.
    private int pagineLette;

    public void startReading() {
        pagineLette = 0;
    }
    public void finishReading() {
        pagineLette = numPages;
    }
}
