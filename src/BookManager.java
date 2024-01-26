import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class BookManager {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayAllBooks() {
        System.out.println("All Books:");
        for (Book book : books) {
            book.displayInfo();
            System.out.println("---------------------");
        }
    }

    public void saveBooksToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Book book : books) {
                writer.println(book.getClass().getName());  // Zapisuje nazwę klasy
                writer.println(book.toString());
                if (book instanceof FictionBook) {
                    writer.println(((FictionBook) book).toString()); // Dodatkowe informacje dla FictionBook
                } else if (book instanceof NonFictionBook) {
                    writer.println(((NonFictionBook) book).toString()); // Dodatkowe informacje dla NonFictionBook
                }
                writer.println("-----"); // Separator między książkami
            }
            System.out.println("Book information has been saved to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readBooksFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals("FictionBook")) {
                    String title = reader.readLine();
                    String author = reader.readLine();
                    String genre = reader.readLine();
                    reader.readLine(); // Skip "-----"
                    addBook(new FictionBook(title, author, genre));
                } else if (line.equals("NonFictionBook")) {
                    String title = reader.readLine();
                    String author = reader.readLine();
                    String topic = reader.readLine();
                    reader.readLine(); // Skip "-----"
                    addBook(new NonFictionBook(title, author, topic));
                }
            }
            System.out.println("Book information has been read from the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}