class NonFictionBook extends Book {
    private String topic;

    public NonFictionBook(String title, String author, String topic) {
        super(title, author);
        this.topic = topic;
    }

    @Override
    public void displayInfo() {
        System.out.println("Non-Fiction Book Info:\n" + this);
        System.out.println("Topic: " + topic);
    }
}