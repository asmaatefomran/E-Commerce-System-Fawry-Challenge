public class ShippableProduct extends Product implements Shippable{
    private Double Weight;
    //servise var
    public ShippableProduct(String name, double price, int quantity,Double Weight) {
        super(name, price, quantity);
        this.Weight = Weight;
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
