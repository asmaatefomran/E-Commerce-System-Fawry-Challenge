public class ShippableItem {
    String name;
    int quantity;
    double totalWeight; // in KG

    public ShippableItem(String name, int quantity, double weightPerUnit) {
        this.name = name;
        this.quantity = quantity;
        this.totalWeight = quantity * weightPerUnit;
    }
}
