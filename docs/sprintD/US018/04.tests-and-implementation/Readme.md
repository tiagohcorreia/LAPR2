# US 018 - Analyse the deals made, based on the characteristics of the property using simple liner regression and multilinear regression

# 4. Tests 

**Test 1:** Check if filters by houses and apartments orders 

	@Test
    void getApartmentsAndHouses() {
        List<Order> expectedHouseAndApartmentsList = new ArrayList<>();
        pt.ipp.isep.dei.esoft.project.domain.model.Order orderHouse1 = new Order(123,DTOHouse);
        pt.ipp.isep.dei.esoft.project.domain.model.Order orderApartment1 = new Order(123,DTOApartment);
        expectedHouseAndApartmentsList.add(orderHouse1);
        expectedHouseAndApartmentsList.add(orderApartment1);

        List<Order> result= analyseDealsController.getApartmentsAndHouses();

        assertEquals(expectedHouseAndApartmentsList, result);


    }



*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)


## Class AnalyseDealsController 

```java
package pt.ipp.isep.dei.esoft.project.application.controller;

import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import pt.ipp.isep.dei.esoft.project.domain.model.Order;
import pt.ipp.isep.dei.esoft.project.domain.model.Property;
import pt.ipp.isep.dei.esoft.project.domain.repository.PurchaseOrderRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;

import java.util.List;

import org.apache.commons.math3.stat.regression.SimpleRegression;


public class AnalyseDealsController {
    Repositories repositories = Repositories.getInstance();
    PurchaseOrderRepository purchaseOrderRepository= repositories.getPurchaseOrderRepository();

    public List<Order> getApartmentsAndHouses() {
        List<Order> orderList = purchaseOrderRepository.getAll();
        List<Order> housesAndApartmentsList = purchaseOrderRepository.getAll();
        for (Order order : orderList) {
            if (order.getAnnouncementDTO().getProperty().getClass().toString().equals("House") || order.getAnnouncementDTO().getProperty().getClass().toString().equals("Apartment")) {
                housesAndApartmentsList.add(order);
            }
        }
        return housesAndApartmentsList;
    }

    private void simpleLinearRegression(int choice) {
        List<Order> housesAndapartmentsList = getApartmentsAndHouses();
        SimpleRegression regression = new SimpleRegression();
        if (choice ==1){
            for (Order order : housesAndapartmentsList) {
                regression.addData(order.getAnnouncementDTO().getProperty().getArea(), order.getOrderAmount());
            }
        } else if (choice==2) {
            for (Order order : housesAndapartmentsList) {
                regression.addData(order.getAnnouncementDTO().getProperty().getCityCentreDistance(), order.getOrderAmount());
            }
        }else if (choice==3) {
            for (Order order : housesAndapartmentsList) {
                regression.addData(order.getAnnouncementDTO().getProperty().getNumberOfBedrooms(), order.getOrderAmount());
            }
        }else if (choice==4) {
            for (Order order : housesAndapartmentsList) {
                regression.addData(order.getAnnouncementDTO().getProperty().getNumberOfBathrooms(), order.getOrderAmount());
            }
        }else if (choice==5) {
            for (Order order : housesAndapartmentsList) {
                regression.addData(order.getAnnouncementDTO().getProperty().getNumberOfParkingSpaces(), order.getOrderAmount());
            }
        }
        double slope = regression.getSlope();
        double intercept = regression.getIntercept();
    }

    public void performMultilinearRegression() {
        List<Order> apartmentsAndHousesList = getApartmentsAndHouses();
        double[] areas = new double[apartmentsAndHousesList.size()];
        double[] distances = new double[apartmentsAndHousesList.size()];
        int[] bedrooms = new int[apartmentsAndHousesList.size()];
        int[] bathrooms = new int[apartmentsAndHousesList.size()];
        int[] parkingSpaces = new int[apartmentsAndHousesList.size()];
        double[] salePrices = new double[apartmentsAndHousesList.size()];

        for (int i = 0; i < apartmentsAndHousesList.size(); i++) {
            Order order = apartmentsAndHousesList.get(i);
            Property property = order.getAnnouncementDTO().getProperty();
            areas[i] = property.getArea();
            distances[i] = property.getCityCentreDistance();
            bedrooms[i] = property.getNumberOfBedrooms();
            bathrooms[i] = property.getNumberOfBathrooms();
            parkingSpaces[i] = property.getNumberOfParkingSpaces();
            salePrices[i] = order.getAnnouncementDTO().getPrice();
        }

        double[] coefficients = calculateMultilinearRegression(areas, distances, bedrooms, bathrooms, parkingSpaces, salePrices);

    }



    private double[] calculateMultilinearRegression(double[] areas, double[] distances, int[] bedrooms, int[] bathrooms, int[] parkingSpaces, double[] salePrices) {
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[][] predictors = createPredictorMatrix(areas, distances, bedrooms, bathrooms, parkingSpaces);
        regression.newSampleData(salePrices, predictors);
        return regression.estimateRegressionParameters();
    }

    private double[][] createPredictorMatrix(double[] areas, double[] distances, int[] bedrooms, int[] bathrooms, int[] parkingSpaces) {
        int n = areas.length;
        double[][] predictors = new double[n][5];

        for (int i = 0; i < n; i++) {
            predictors[i][0] = areas[i];
            predictors[i][1] = distances[i];
            predictors[i][2] = bedrooms[i];
            predictors[i][3] = bathrooms[i];
            predictors[i][4] = parkingSpaces[i];
        }

        return predictors;
    }
}


```



# 6. Integration and Demo 

* A new option on the Employee menu options was added.

* Some demo purposes some tasks are bootstrapped while system starts.


# 7. Observations

Platform and Organization classes are getting too many responsibilities due to IE pattern and, therefore, they are becoming huge and harder to maintain. 

Is there any way to avoid this to happen?





