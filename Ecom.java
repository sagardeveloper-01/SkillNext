import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private String name;
    private double price;

    Product(String n, double p) {
        this.name = n;
        this.price = p;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setPrice(double p) {
        this.price = p;
    }
}

class ShoppingCart {
    ArrayList<Product> cart = new ArrayList<>();

    public void addProduct(Product p) {
        for(Product p : cart){
            if(b.getName().equals(p.getName())){
                System.out.println("Duplicates Product found");
                b.setPrice(b.getPrice()+p.getPrice());
                System.out.println("Product price updated");
                return;
            }
        }
        cart.add(p);
        System.out.println("Product added to the cart");
    }

    public void removeProduct(String name) {
        for (Product p : cart) {
            if (p.getName().equals(name)) {
                cart.remove(p);
                System.out.println("Product removed from cart");
                return;
            }
        }
        System.out.println("Given name " + name + " not found in cart");
    }

    public void displayCart() {
        if (cart.size() == 0) {
            System.out.println("No product available in the cart");
            return;
        }
        for (Product p : cart) {
            System.out.println(p.getName() + " - Rs. " + p.getPrice());
        }
    }

    public void checkout() {
        double total = 0.0;
        for (Product p : cart) {
            total += p.getPrice();
        }
        if (total >= 100000.0) {
            total -= total * 0.1;
            System.out.println("10% discount applied!");
        }
        System.out.println("Total cost to be paid: Rs. " + total);
    }
}

public class Ecom {
    static int menu() {
        System.out.println("1. Add product \n 2.remove \n 3.Display \n 4.Checkout \n 5.exit \n Enter your choice");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        int ch = 0;
        String name = "";
        Scanner sc = new Scanner(System.in);

        while (true) {
            ch = menu();
            switch (ch) {
                case 1:
                    System.out.print("Enter Product name: ");
                    name = sc.next();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    Product p = new Product(name, price);
                    cart.addProduct(p);
                    break;
                case 2:
                    System.out.print("Enter Product name to remove: ");
                    name = sc.next();
                    cart.removeProduct(name);
                    break;
                case 3:
                    cart.displayCart();
                    break;
                case 4:
                    cart.checkout();
                    break;
                case 5:
                    System.out.println("Thank you for using the E-commerce system!");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
