import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //assuming this part will be done by the owner of the e-commerce
        Storage storage = new Storage();
        //adding expirable product and shippable product and expirable&shippable product and digital product
        storage.addProduct("Milk",15.5,5, LocalDate.of(2025,7,20),1.0);
        storage.addProduct("Uber Gift Card",500.0, 3,LocalDate.of(2026,7,20));
        storage.addProduct("TV",25000.0, 3,4.5);
        storage.addProduct("DigitalBook",300.75,6);

        //updating the quantity of existing
        storage.UpdateStockOfProduct("Milk",6);

    }
}
