package food.service;

import food.model.Discountable;
import food.model.FoodOrder;

/**
 * Service class that contains the business logic for processing a
 * FoodOrder: computing the discount, delivery charge and the final
 * payable amount, and printing a formatted bill.
 */
public class OrderService {

    /**
     * Returns the discount amount for the given order (0 if the order
     * does not implement Discountable).
     */
    public double getDiscount(FoodOrder order) {
        if (order instanceof Discountable) {
            return ((Discountable) order).applyDiscount();
        }
        return 0.0;
    }

    /**
     * Computes the final payable amount = bill amount - discount + delivery charge.
     */
    public double calculateFinalAmount(FoodOrder order) {
        double discount = getDiscount(order);
        double deliveryCharge = order.calculateDeliveryCharge();
        return (order.getAmount() - discount) + deliveryCharge;
    }

    /**
     * Prints a nicely formatted bill for the given order.
     */
    public void displayBill(FoodOrder order) {
        double discount = getDiscount(order);
        double deliveryCharge = order.calculateDeliveryCharge();
        double finalAmount = calculateFinalAmount(order);

        System.out.println("---------------------------------------------------");
        System.out.println("Order ID        : " + order.getOrderId());
        System.out.println("Customer Name   : " + order.getCustomerName());
        System.out.println("Order Type      : " + order.getOrderType());
        System.out.println("Restaurant      : " + FoodOrder.getRestaurantName());
        System.out.printf ("Order Amount    : Rs. %.2f%n", order.getAmount());
        System.out.printf ("Discount Applied: Rs. %.2f%n", discount);
        System.out.printf ("Delivery Charge : Rs. %.2f%n", deliveryCharge);
        System.out.printf ("Final Payable   : Rs. %.2f%n", finalAmount);
        System.out.println("---------------------------------------------------");
    }
}
