public class Product {
    private String name;
    private Double price;
    private int quantity = 0;
    public Product(String name, Double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    //getters & setters
    public String getName() {
        return name;
    }
    public Double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    //stock function
    public void updateQuantity(int quantity){
        this.quantity += quantity;
    }

}
