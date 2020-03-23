package zad3;

class Person {

    String name;
    String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        Person ws = new Person("Walter", "Savitch");
        Person km = new Person("Kenrick", "Mock");

        Book book = new Book(new Person[]{ws, km}, "Absolute Java", 2015, "Pearson", "PEL, Edinburgh Gate, Harlow, Essex CM20 2JE, England", 1296);

        System.out.println(book.getPagesCount()); //1296

        Person gb = new Person("Gilad", "Bracha");
        Person mo = new Person("Martin", "Odersky");
        Person ds = new Person("David", "Stoutamire");
        Person pw = new Person("Philip", "Wadler");

        Person bfb = new Person("Bjorn", "Freeman-Benson");
        Person cc = new Person("Craig", "Chambers");

        InCollection inCollection = new InCollection(new Person[]{gb, mo, ds, pw},
                "Making the future safe for the past: Adding genericity to the Java programming language", 1998, "ACM",
                "ACM, 2 Penn Plaza, Suite 701, New York, NY 10121-0701",
                "Proceedings of the 13th ACM SIGPLAN conference on Object-oriented programming, systems, languages and applications", new Person[]{bfb, cc}, 183, 200);

        System.out.println(inCollection.getPagesCount());//17

        System.out.println(book.getAddress());
        System.out.println(book.getAuthors());
        System.out.println(book.getClass());
        System.out.println(book.getPublisher());
        System.out.println(book.getYear());

    }
}
