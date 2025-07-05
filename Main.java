import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();

        // Adding products(this will be the role of the owner of the store
        storage.addProduct("Cheese", 100.0, 5, LocalDate.of(2025, 7, 20), 0.2);
        storage.addProduct("Biscuits", 150.0, 3, LocalDate.of(2025, 7, 10), 0.7);
        storage.addProduct("TV", 25000.0, 3, 5.0);
        storage.addProduct("Scratch Card", 50.0, 10);
        storage.addProduct("ExpiredMilk", 40.0, 5, LocalDate.of(2024, 1, 1), 1.0); // expired

        // this is the user
        Customer customer = new Customer("Asmaa", 500.0);

        // Cart
        Cart cart = new Cart(storage);
        cart.addProduct("Cheese", 2);
        cart.addProduct("Biscuits", 1);
        cart.addProduct("Scratch Card", 1);
        cart.addProduct("ExpiredMilk", 1); // should log expired
        // Checkout
        cart.checkout(customer);
    }
}
