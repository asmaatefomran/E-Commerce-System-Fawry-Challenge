import java.time.LocalDate;
import java.util.HashMap;

public class Storage {
    HashMap<String,Product> stock;
    public Storage() {
        stock = new HashMap<>();
    }
    public Storage(HashMap<String,Product> stock) {
        this.stock = stock;
    }
    public Product getProduct(String productName) {
        return stock.get(productName);
    }
    public void UpdateStockOfProduct(String itemName, int newQuantity) {
        if(stock.containsKey(itemName)) {
            stock.get(itemName).updateQuantity(newQuantity);
            System.out.println(itemName + " updated to " +  stock.get(itemName).getQuantity());
        }
        else{
           System.out.println("Item does not exist,Add this item first");
        }
    }
    //function overloading
    public void addProduct(String productName, Double price, int quantity, LocalDate expiryDate) {
        if(stock.containsKey(productName)) {
            System.out.println("Product already exists");
        }
        else{
            Product newProduct=new ExpirableProduct(productName, price, quantity, expiryDate);
            stock.put(productName, newProduct);
        }
    }
    public void addProduct(String productName, Double price, int quantity, Double weight) {
        if(stock.containsKey(productName)) {
            System.out.println("Product already exists");
        }
        else{
            Product newProduct=new ShippableProduct(productName, price, quantity, weight);
            stock.put(productName, newProduct);
        }
    }
    public void addProduct(String productName, Double price, int quantity, LocalDate expiryDate, Double weight) {
        if(stock.containsKey(productName)) {
            System.out.println("Product already exists");
        }
        else{
           Product newProduct=new ExpirableShippableProduct(productName, price, quantity, expiryDate,weight);
           stock.put(productName, newProduct);
        }
    }
    public void addProduct(String productName, Double price, int quantity) {
        if(stock.containsKey(productName)) {
            System.out.println("Product already exists");
        }
        else{
            Product newProduct=new Product(productName, price, quantity);
            stock.put(productName, newProduct);
        }
    }
    public boolean enoughStockForProduct(String productName,int quantity) {
        if(stock.containsKey(productName)) {
            if(stock.get(productName).getQuantity() >= quantity) {
                return true;
            }
        }
        return false;
    }
    public Double buyProduct(String productName, int quantity) {
        if(enoughStockForProduct(productName, quantity)) {
            stock.get(productName).setQuantity(stock.get(productName).getQuantity()-quantity);
            return stock.get(productName).getPrice()*quantity;
        }else{
            return 0.0;
        }
    }


}

