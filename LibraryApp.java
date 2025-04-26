import java.util.*;
class Book
{
    private String title;
    private boolean isAvailable;
    public Book(String title)
{
        this.title = title;
        this.isAvailable = true;
    }
    public String getTitle()
{
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrowBook() {
        if (isAvailable)
{
            isAvailable = false;
            System.out.println(title + " has been borrowed.");
        }
else
{
            System.out.println(title + " is currently not available.");
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println(title + " has been returned.");
    }
}

public class LibraryApp {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
        System.out.println(b.getTitle() + " has been added to the library.");
    }

    public void borrowBook(String title)
{
        for (Book b : books)
{
            if (b.getTitle().equals(title) && b.isAvailable()) {
                b.borrowBook();
                return;
            }
        }
        System.out.println("Book not found or unavailable.");
    }

    public void returnBook(String title)
{
        for (Book b : books) {
            if (b.getTitle().equals(title) && !b.isAvailable()) {
                b.returnBook();
                return;
            }
        }
        System.out.println("Invalid return attempt.");
    }

    public void displayBooks()
{
        System.out.println("\n Books Tile \t\t Status:");
        for (Book b : books)
{
           
System.out.printf("\n %20s",b.getTitle());
System.out.printf("\t %b",b.isAvailable());
           
        }
    }
static int menu()
{
Scanner sc = new Scanner(System.in);
System.out.println("\n Enter 1. Add \n 2. Display
\n 3. borrow\n 4. return \n. 5. quit\n Enter choice: ");
return sc.nextInt();

}
    public static void main(String[] args)
{
Scanner sc = new Scanner(System.in);
        LibraryApp library = new LibraryApp();
int ch;
String tit="";
while(true)
{
ch = menu();
switch(ch)
{
case 1:
System.out.println("enter book name :");
tit = sc.next();
Book b1 = new Book(tit);
library.addBook(b1);
break;
case 2:
library.displayBooks();
break;
case 3:
System.out.println("enter title :");
tit = sc.next();
library.borrowBook(tit);
break;
case 4:
System.out.println("enter title :");
tit = sc.next();
library.returnBook(tit);
break;
case 5:
System.exit(0);
default:
System.out.println("invalid choice");


}
}

       
    }
}

