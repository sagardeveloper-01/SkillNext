import java.util.*;

class Book {
    private String title;
    private int totalCopies;
    private int borrowedCopies;

    public Book(String title) {
        this.title = title;
        this.totalCopies = 1;
        this.borrowedCopies = 0;
    }

    public String getTitle() {
        return title;
    }

    public int getAvailableCopies() {
        return totalCopies - borrowedCopies;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void addCopy() {
        totalCopies++;
    }

    public boolean borrowBook() {
        if (getAvailableCopies() > 0) {
            borrowedCopies++;
            System.out.println(title + " has been borrowed.");
            return true;
        } else {
            System.out.println(title + " is currently not available.");
            return false;
        }
    }

    public boolean returnBook() {
        if (borrowedCopies > 0) {
            borrowedCopies--;
            System.out.println(title + " has been returned.");
            return true;
        } else {
            System.out.println("No borrowed copies to return for " + title + ".");
            return false;
        }
    }
}

public class LibraryApp1 {
    private Map<String, Book> books = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    public void addBook(String title) {
        String key = title.toLowerCase();
        if (books.containsKey(key)) {
            books.get(key).addCopy();
            System.out.println("Another copy of \"" + title + "\" has been added.");
        } else {
            books.put(key, new Book(title));
            System.out.println("\"" + title + "\" has been added to the library.");
        }
    }

    public void borrowBook(String title) {
        Book book = books.get(title.toLowerCase());
        if (book != null) {
            book.borrowBook();
        } else {
            System.out.println("Book not found.");
        }
    }

    public void returnBook(String title) {
        Book book = books.get(title.toLowerCase());
        if (book != null) {
            book.returnBook();
        } else {
            System.out.println("Book not found.");
        }
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }

        System.out.println("\nTitle\t\tTotal\tAvailable");
        for (Book book : books.values()) {
            System.out.printf("%-8s\t%5d\t%5d\n", book.getTitle(), book.getTotalCopies(), book.getAvailableCopies());
        }
    }

    private int menu() {
        while (true) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Add Book");
                System.out.println("2. Display Books");
                System.out.println("3. Borrow Book");
                System.out.println("4. Return Book");
                System.out.println("5. Quit");
                System.out.print("Choice: ");
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public void start() {
        while (true) {
            try {
                int choice = menu();
                switch (choice) {
                    case 1:
                        System.out.print("Enter book name: ");
                        String addTitle = sc.nextLine().trim();
                        if (!addTitle.isEmpty()) addBook(addTitle);
                        else System.out.println("Title cannot be empty.");
                        break;
                    case 2:
                        displayBooks();
                        break;
                    case 3:
                        System.out.print("Enter book name to borrow: ");
                        String borrowTitle = sc.nextLine().trim();
                        if (!borrowTitle.isEmpty()) borrowBook(borrowTitle);
                        else System.out.println("Title cannot be empty.");
                        break;
                    case 4:
                        System.out.print("Enter book name to return: ");
                        String returnTitle = sc.nextLine().trim();
                        if (!returnTitle.isEmpty()) returnBook(returnTitle);
                        else System.out.println("Title cannot be empty.");
                        break;
                    case 5:
                        System.out.println("Exiting program.");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please select 1 to 5.");
                }
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new LibraryApp1().start();
    }
}

