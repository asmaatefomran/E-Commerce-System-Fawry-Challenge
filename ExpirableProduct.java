import java.time.LocalDate;

public class ExpirableProduct extends Product implements Expirable {
     private LocalDate expiryDate;
     ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate){
         super(name,price,quantity);
         this.expiryDate = expiryDate;
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
        return false;
    }

}
