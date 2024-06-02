package src;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static BookManager bookManager = new BookManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    listBooks();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("[1] Add book");
        System.out.println("[2] Remove book");
        System.out.println("[3] Update book");
        System.out.println("[4] List books");
        System.out.println("[5] Exit");
    }

    private static void addBook() {
        System.out.println("Enter title:");
        String title = scanner.nextLine();
        System.out.println("Enter author:");
        String author = scanner.nextLine();
        System.out.println("Enter ISBN:");
        String isbn = scanner.nextLine();
        System.out.println("Enter year:");
        int year = Integer.parseInt(scanner.nextLine());
        Book book = new Book(title, author, isbn, year);
        bookManager.addBook(book);
        System.out.println("Book added.");
    }

    private static void removeBook() {
        System.out.println("Enter ISBN of the book to remove:");
        String isbn = scanner.nextLine();
        Book bookToRemove = null;
        for (Book book : bookManager.getBooks()) {
            if (book.getIsbn().equals(isbn)) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove != null) {
            bookManager.removeBook(bookToRemove);
            System.out.println("Book removed.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void updateBook() {
        System.out.println("Enter ISBN of the book to update:");
        String isbn = scanner.nextLine();
        Book bookToUpdate = null;
        for (Book book : bookManager.getBooks()) {
            if (book.getIsbn().equals(isbn)) {
                bookToUpdate = book;
                break;
            }
        }
        if (bookToUpdate != null) {
            System.out.println("Enter new title:");
            String title = scanner.nextLine();
            System.out.println("Enter new author:");
            String author = scanner.nextLine();
            System.out.println("Enter new ISBN:");
            String newIsbn = scanner.nextLine();
            System.out.println("Enter new year:");
            int year = Integer.parseInt(scanner.nextLine());
            Book newBook = new Book(title, author, newIsbn, year);
            bookManager.updateBook(bookToUpdate, newBook);
            System.out.println("Book updated.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void listBooks() {
        List<Book> books = bookManager.getBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
