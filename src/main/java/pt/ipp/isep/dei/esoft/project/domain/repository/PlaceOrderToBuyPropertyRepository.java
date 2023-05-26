package pt.ipp.isep.dei.esoft.project.domain.repository;

import pt.ipp.isep.dei.esoft.project.domain.model.Order;

import java.util.ArrayList;
import java.util.List;

public class PlaceOrderToBuyPropertyRepository {

    public static List<Order> orderList = new ArrayList<>();

    public boolean saveOrder(Order order) {

        if(validateOrder(order)) {

            return addOrder(order);
        }
        return false;
    }

    public boolean addOrder(Order order) {

        if(order != null && validateOrder(order)) {

            return this.orderList.add(order);
        }
        return false;
    }

    public boolean validateOrder(Order order) {

        for(Order order1: orderList) {

            if(order.equals(order)) {

                return false;
            }
        }
        return true;
    }

    public List<Order> getOrderList() {

        return new ArrayList<>(orderList);
    }

    public String getOrdersListAsString() {

        StringBuilder stringBuilder = new StringBuilder();

        for(Order order: this.orderList) {

            stringBuilder.append("-").append(order.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

}
