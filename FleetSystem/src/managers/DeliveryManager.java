package src.managers;

import src.models.Delivery;
import src.utils.LinkedList;
import src.utils.FileUtils;
import java.util.List;

public class DeliveryManager {
    private LinkedList<Delivery> deliveryQueue;
    private List<Delivery> deliveries;

    public DeliveryManager() {
        this.deliveryQueue = new LinkedList<>();
        this.deliveries = FileUtils.loadDeliveries("../data/deliveries.txt"); // Load deliveries from file
        for (Delivery delivery : deliveries) {
            deliveryQueue.add(delivery);
        }
    }

    public void addDelivery(Delivery delivery) {
        deliveryQueue.add(delivery);
        deliveries.add(delivery);
        FileUtils.saveDeliveries("../data/deliveries.txt", deliveries); // Save to file
        System.out.println("Delivery added: " + delivery);
    }

    public void completeDelivery() {
        Delivery completedDelivery = deliveryQueue.remove();
        if (completedDelivery != null) {
            deliveries.remove(completedDelivery);
            FileUtils.saveDeliveries("../data/deliveries.txt", deliveries); // Save to file
            System.out.println("Delivery completed: " + completedDelivery);
        } else {
            System.out.println("No deliveries to complete.");
        }
    }

    public void displayDeliveries() {
        // logic to print all deliveries
    }
}
