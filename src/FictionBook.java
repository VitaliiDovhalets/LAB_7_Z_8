class FictionBook extends Book {
    private String genre;

    public FictionBook(String title, String author, String genre) {
        super(title, author);
        this.genre = genre;
    }

    @Override
    public void displayInfo() {
        System.out.println("Fiction Book Info:\n" + this);
        System.out.println("Genre: " + genre);
    }
}