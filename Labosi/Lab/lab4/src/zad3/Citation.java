package zad3;

/**
 *
 * @author Matija
 */
abstract class Citation {

    private Person[] authors;
    private String title;
    private int year;

    public Citation(Person[] authors, String title, int year) {
        this.authors = authors;
        this.title = title;
        this.year = year;
    }

    public Person[] getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public abstract int getPagesCount();
}

class Book extends Citation {

    private String publisher;
    private String address;
    private int pagesCount;

    public Book(Person[] authors, String title, int year, String publisher, String address, int pagesCount) {
        super(authors, title, year);
        this.publisher = publisher;
        this.address = address;
        this.pagesCount = pagesCount;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public int getPagesCount() {
        return pagesCount;
    }

}

class InCollection extends Book {

    private String booktitle;
    private Person[] editors;
    private int startPage;
    private int endPage;

    public InCollection(Person[] authors, String title, int year, String publisher,
            String address, String booktitle, Person[] editors, int startPage, int endPage) {
        super(authors, title, year, publisher, address, endPage - startPage);
        this.booktitle = booktitle;
        this.editors = editors;
        this.startPage = startPage;
        this.endPage = endPage;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public Person[] getEditors() {
        return editors;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

}
