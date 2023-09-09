package com.trendyol.shipment;

import java.util.List;

import static com.trendyol.shipment.ShipmentSizeAncestor.findAncestorShipmentSize;

public class Basket {

    public static final int BASKET_THRESHOLD_COUNT = 3;
    public static final int BASKET_EMPTY_COUNT = 0;

    private List<Product> products;

    public ShipmentSize getShipmentSize() {

        ShipmentSize calculatedShipmentSize = null;

        for (var shipmentSize : ShipmentSize.values()) {
            long foundedShipmentSizeCountInProductList = getProducts().stream()
                    .filter((product -> product.getSize() == shipmentSize)).count();

            if (foundedShipmentSizeCountInProductList == BASKET_EMPTY_COUNT)
                continue;

            calculatedShipmentSize = shipmentSize;

            if (foundedShipmentSizeCountInProductList < BASKET_THRESHOLD_COUNT)
                continue;

            return findAncestorShipmentSize(calculatedShipmentSize);
        }

        return calculatedShipmentSize;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
