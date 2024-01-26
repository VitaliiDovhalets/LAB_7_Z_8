import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        BookManager bookManager = new BookManager();

        // Dodawanie kilku książek
        bookManager.addBook(new FictionBook("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "Fantasy"));
        bookManager.addBook(new NonFictionBook("Elon Musk", "Walter IsaacsonWalter Isaacson.", "Biography "));
        bookManager.addBook(new FictionBook("The Great Gatsby", "F. Scott Fitzgerald.", "Drama"));

        // Wyświetlanie informacji o wszystkich książkach
        bookManager.displayAllBooks();

        // Zapisywanie informacji o książkach do pliku
        bookManager.saveBooksToFile("books.txt");

        // Odczyt informacji o książkach z pliku
        BookManager newBookManager = new BookManager();
        newBookManager.readBooksFromFile("books.txt");

        // Wyświetlanie informacji o książkach po odczycie z pliku
        newBookManager.displayAllBooks();
    }
}