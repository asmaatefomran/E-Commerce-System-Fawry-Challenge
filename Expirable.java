import java.time.LocalDate;

public interface Expirable {
    public LocalDate getExpiryDate();
    public void setExpiryDate(LocalDate expiryDate);
    public boolean isExpired();

}
