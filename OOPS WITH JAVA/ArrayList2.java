import java.util.*;

public class ArrayList2 {

    public static void addProduct(List<String> cart, String product) {
        cart.add(product);
    }

    public static void removeProduct(List<String> cart, String product) {
        cart.remove(product);
    }

    public static int countProduct(List<String> cart, String product) {
        int count = 0;
    for (String item : cart) {
        if (item.equals(product)) {
            count++;
        }
    }
    return count;
    }

    public static void displayCart(List<String> cart) {
        for (int i = 0; i < cart.size(); i++) {
            System.out.print(cart.get(i));
            if (i < cart.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

        List<String> cart = new ArrayList<>();

        addProduct(cart, "Laptop");
        addProduct(cart, "Mouse");
        addProduct(cart, "Keyboard");
        addProduct(cart, "Mouse");
        addProduct(cart, "Mouse");

        System.out.println("Cart:");
        displayCart(cart);

        System.out.println("Mouse quantity: " + countProduct(cart, "Mouse"));

        removeProduct(cart, "Mouse");

        System.out.println("After removing one Mouse:");
        displayCart(cart);
    }
} 