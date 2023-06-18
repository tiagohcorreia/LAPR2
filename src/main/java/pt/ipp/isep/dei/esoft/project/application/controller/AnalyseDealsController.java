package pt.ipp.isep.dei.esoft.project.application.controller;

import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import pt.ipp.isep.dei.esoft.project.domain.model.Order;
import pt.ipp.isep.dei.esoft.project.domain.model.Property;
import pt.ipp.isep.dei.esoft.project.domain.repository.PurchaseOrderRepository;
import pt.ipp.isep.dei.esoft.project.domain.repository.Repositories;

import java.util.List;

import org.apache.commons.math3.stat.regression.SimpleRegression;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class AnalyseDealsController {

        @FXML
        private TableView<PropertyData> table;

        @FXML
        private TableColumn<PropertyData, String> propertyColumn;

        @FXML
        private TableColumn<PropertyData, Double> salePriceColumn;

        @FXML
        private TableColumn<PropertyData, Double> forecastPriceSLRColumn;

        @FXML
        private TableColumn<PropertyData, Double> forecastPriceMLRColumn;
    @FXML
    private void handleMinimizeButtonClick(ActionEvent event) {
        Stage stage = (Stage) table.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void handleCloseButtonClick(ActionEvent event) {
        Stage stage = (Stage) table.getScene().getWindow();
        stage.close();
    }

        private List<Order> housesAndApartmentsList;

        Repositories repositories = Repositories.getInstance();
        PurchaseOrderRepository purchaseOrderRepository = repositories.getPurchaseOrderRepository();

        public static class PropertyData {
            private final StringProperty property;
            private final DoubleProperty salePrice;
            private final DoubleProperty forecastPriceSLR;
            private final DoubleProperty forecastPriceMLR;

            public PropertyData(String property, double salePrice, double forecastPriceSLR, double forecastPriceMLR) {
                this.property = new SimpleStringProperty(property);
                this.salePrice = new SimpleDoubleProperty(salePrice);
                this.forecastPriceSLR = new SimpleDoubleProperty(forecastPriceSLR);
                this.forecastPriceMLR = new SimpleDoubleProperty(forecastPriceMLR);
            }


            public StringProperty propertyProperty() {
                return property;
            }

            public String getProperty() {
                return property.get();
            }

            public void setProperty(String value) {
                property.setValue(value);
            }

            public DoubleProperty salePriceProperty() {
                return salePrice;
            }

            public DoubleProperty forecastPriceSLRProperty() {
                return forecastPriceSLR;
            }

            public DoubleProperty forecastPriceMLRProperty() {
                return forecastPriceMLR;
            }
        }

        public void initialize() {
            propertyColumn.setCellValueFactory(new PropertyValueFactory<>("property"));
            salePriceColumn.setCellValueFactory(new PropertyValueFactory<>("salePrice"));
            forecastPriceSLRColumn.setCellValueFactory(new PropertyValueFactory<>("forecastPriceSLR"));
            forecastPriceMLRColumn.setCellValueFactory(new PropertyValueFactory<>("forecastPriceMLR"));
        }

        public List<Order> getApartmentsAndHouses() {
            List<Order> orderList = purchaseOrderRepository.getAll();
            List<Order> housesAndApartmentsList = purchaseOrderRepository.getAll();
            for (Order order : orderList) {
                if (order.getAnnouncementDTO().getProperty().getClass().toString().equals("House") ||
                        order.getAnnouncementDTO().getProperty().getClass().toString().equals("Apartment")) {
                    housesAndApartmentsList.add(order);
                }
            }
            return housesAndApartmentsList;
        }

        @FXML
        private void calculateSimpleLinearRegression() {
            ObservableList<PropertyData> data = FXCollections.observableArrayList();

            List<Order> housesAndApartmentsList = getApartmentsAndHouses();
            SimpleRegression regression = new SimpleRegression();

            for (Order order : housesAndApartmentsList) {
                regression.addData(order.getAnnouncementDTO().getProperty().getArea(), order.getOrderAmount());
            }

            double slope = regression.getSlope();
            double intercept = regression.getIntercept();

            for (Order order : housesAndApartmentsList) {
                Property property = order.getAnnouncementDTO().getProperty();
                double salePrice = order.getAnnouncementDTO().getPrice();
                double forecastPriceSLR = slope * property.getArea() + intercept;
                double forecastPriceMLR = 0.0;

                PropertyData propertyData = new PropertyData(property.toString(), salePrice, forecastPriceSLR, forecastPriceMLR);
                data.add(propertyData);
            }

            table.setItems(data);
        }

        @FXML
        private void calculateMultilinearRegression() {
            ObservableList<PropertyData> data = FXCollections.observableArrayList();
            OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
            double[][] predictors = new double[housesAndApartmentsList.size()][5];
            double[] salePrices = new double[housesAndApartmentsList.size()];

            for (int i = 0; i < housesAndApartmentsList.size(); i++) {
                Order order = housesAndApartmentsList.get(i);
                Property property = order.getAnnouncementDTO().getProperty();
                double salePrice = order.getAnnouncementDTO().getPrice();

                predictors[i][0] = property.getArea();
                predictors[i][1] = property.getCityCentreDistance();
                predictors[i][2] = property.getNumberOfBedrooms();
                predictors[i][3] = property.getNumberOfBathrooms();
                predictors[i][4] = property.getNumberOfParkingSpaces();
                salePrices[i] = salePrice;
            }

            regression.newSampleData(salePrices, predictors);
            double[] coefficients = regression.estimateRegressionParameters();

            for (int i = 0; i < housesAndApartmentsList.size(); i++) {
                Order order = housesAndApartmentsList.get(i);
                Property property = order.getAnnouncementDTO().getProperty();
                double salePrice = order.getAnnouncementDTO().getPrice();
                double[] predictor = predictors[i];
                double forecastPriceMLR = calculateMultilinearForecastPrice(predictor, coefficients);
                double forecastPriceSLR = 0.0;

                PropertyData propertyData = new PropertyData(property.toString(), salePrice, forecastPriceSLR, forecastPriceMLR);
                data.add(propertyData);
            }

            table.setItems(data);
        }

        private double calculateMultilinearForecastPrice(double[] predictor, double[] coefficients) {
            double forecastPriceMLR = 0.0;

            for (int i = 0; i < predictor.length; i++) {
                forecastPriceMLR += predictor[i] * coefficients[i];
            }

            return forecastPriceMLR;
        }
    }
