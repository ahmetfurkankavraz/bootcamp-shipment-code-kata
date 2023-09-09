package com.trendyol.shipment;

import java.util.Arrays;
import java.util.List;

public class Basket {

    public static final int BASKET_THRESHOLD_COUNT = 3;
    public static final int BASKET_EMPTY_COUNT = 0;

    private List<Product> products;

    public ShipmentSize getShipmentSize() {

        ShipmentSize selectedShipmentSize = null;

        for (var shipmentSize : ShipmentSize.values()) {
            long shipmentSizeCount = products.stream().filter(
                    (product -> product.getSize() == shipmentSize)).count();

            if (shipmentSizeCount == BASKET_EMPTY_COUNT)
                continue;

            selectedShipmentSize = shipmentSize;

            if (shipmentSizeCount < BASKET_THRESHOLD_COUNT)
                continue;

            switch (shipmentSize) {
                case SMALL:
                    selectedShipmentSize = ShipmentSize.MEDIUM;
                    break;
                case MEDIUM:
                    selectedShipmentSize = ShipmentSize.LARGE;
                    break;
                case LARGE:
                    selectedShipmentSize = ShipmentSize.X_LARGE;
                    break;
            }
            return selectedShipmentSize;
        }

        return selectedShipmentSize;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
