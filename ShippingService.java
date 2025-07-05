import java.util.List;

public class ShippingService {
    public static void ship(List<ShippableItem> items) {
        if (items.isEmpty()) return;

        System.out.println("** Shipment notice **");
        double totalWeight = 0.0;

        for (ShippableItem item : items) {
            System.out.println(item.quantity + "x " + item.name + " " + (item.totalWeight * 1000) + "g");
            totalWeight += item.totalWeight;
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}
