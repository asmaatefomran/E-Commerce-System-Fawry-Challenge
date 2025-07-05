import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cart {
    boolean isEnough,isExpire;
    Double sum;
    String log;
    List<Product> products;
    Storage storage;
    public Cart(Storage storage) {
        products = new ArrayList<Product>();
        sum=0.0;
        isEnough=false;
        isExpire=false;
        log="";
        this.storage=storage;
    }
    public void addProduct(String pname, int quantity) {
        Product p = storage.getProduct(pname);
        if (p == null) {
            log += "Product " + pname + " not found in storage\n";
            return;
        }

        boolean isExpired = (p instanceof Expirable) && ((Expirable)p).isExpired();

        if (isExpired) {
            log += p.getName() + " is expired and cannot be added\n";
        } else if (quantity > p.getQuantity()) {
            log += p.getName() + " is not enough to add. Available: " + p.getQuantity() + "\n";
        } else {
            log += quantity+ "x    " + p.getName() + "      " + p.getPrice() * quantity + '\n';
            sum += p.getPrice() * quantity;
            storage.buyProduct(pname, quantity);
            products.add(p);
        }
    }
    public void printTheLog() {
        System.out.println(log);
    }
    public void checkout(Customer customer) {
        if (products.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        double shippingFee = 0;
        List<ShippableItem> itemsToShip = new ArrayList<>();
        HashMap<String, Integer> productCount = new HashMap<>();
        for (Product p : products) {
            productCount.put(p.getName(), productCount.getOrDefault(p.getName(), 0) + 1);
        }

        for (String name : productCount.keySet()) {
            Product p = storage.getProduct(name);
            int qty = productCount.get(name);
            double total = p.getPrice() * qty;

            if (p instanceof Shippable) {
                double weight = ((Shippable) p).getweight();
                itemsToShip.add(new ShippableItem(p.getName(), qty, weight));
            }
        }
        System.out.println("** Checkout receipt **");
        printTheLog(); //has the small errors and the reciet
        System.out.println("----------------------");

        if (!itemsToShip.isEmpty()) {
            shippingFee = 30;
            ShippingService.ship(itemsToShip);
            System.out.println("----------------------");
        }

        double totalAmount = sum + shippingFee;

        if (!customer.hasEnough(totalAmount)) {
            System.out.println("Error: Insufficient balance.");
            return;
        }

        customer.pay(totalAmount);


        System.out.printf("Subtotal %.0f\n", sum);
        System.out.printf("Shipping %.0f\n", shippingFee);
        System.out.printf("Amount %.0f\n", totalAmount);
        System.out.printf("Balance %.0f\n", customer.getBalance());
    }

}
