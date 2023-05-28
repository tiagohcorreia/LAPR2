package pt.ipp.isep.dei.esoft.project.domain.repository;

import pt.ipp.isep.dei.esoft.project.domain.model.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Place order to buy property repository.
 */
public class PlaceOrderToBuyPropertyRepository implements Serializable {

    /**
     * The constant orderList.
     */
    public static List<Order> orderList = new ArrayList<>();

    /**
     * Save order boolean.
     *
     * @param order the order
     * @return the boolean
     */
    public boolean saveOrder(Order order) {

        if (validateOrder(order)) {

            return addOrder(order);
        }
        return false;
    }

    /**
     * Add order boolean.
     *
     * @param order the order
     * @return the boolean
     */
    public boolean addOrder(Order order) {

        if (order != null && validateOrder(order)) {

            return this.orderList.add(order);
        }
        return false;
    }

    /**
     * Validate order boolean.
     *
     * @param order the order
     * @return the boolean
     */
    public boolean validateOrder(Order order) {

        for (Order order1 : orderList) {

            if (order.equals(order)) {

                return false;
            }
        }
        return true;
    }

    /**
     * Gets order list.
     *
     * @return the order list
     */
    public List<Order> getOrderList() {

        return new ArrayList<>(orderList);
    }

    /**
     * Gets orders list as string.
     *
     * @return the orders list as string
     */
    public String getOrdersListAsString() {

        StringBuilder stringBuilder = new StringBuilder();

        for (Order order : this.orderList) {

            stringBuilder.append("-").append(order.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    public void readObject() {

        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ser/order.ser"));
            ois.readObject();
            System.out.println(orderList);
            ois.close();

        } catch (IOException | ClassNotFoundException e) {

            e.printStackTrace();
        }
    }

    public void writeObject() {

        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ser/order.ser"));
            oos.writeObject(orderList);
            oos.close();

        } catch (IOException ioe) {

            ioe.printStackTrace();
        }
    }

}
