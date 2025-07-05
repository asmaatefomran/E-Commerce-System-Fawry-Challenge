import java.time.LocalDate;

public class ExpirableShippableProduct extends Product implements Shippable, Expirable{
    private LocalDate expiryDate;
    private Double Weight;
    ExpirableShippableProduct(String name, double price, int quantity, LocalDate expiryDate,Double weight){
        super(name,price,quantity);
        this.expiryDate = expiryDate;
        this.Weight = weight;
    }
    @Override
    public LocalDate getExpiryDate(){
        return expiryDate;
    }
    @Override
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }
    @Override
    public Double getweight(){
        return Weight ;
    }
    @Override
    public void setweight(Double weight){
        this.Weight = weight;
    }
    //TODO: shipping service
    @Override
    public void ship(){
        System.out.println("ShippableProduct");
    }
}
