package com.trendyol.shipment;

import java.util.List;

public class ShipmentSizeSelectionImpl implements ShipmentSizeSelection {

    private static final int BASKET_THRESHOLD_COUNT_FOR_ANCESTOR_CALCULATION = 3;
    private static final int BASKET_ZERO_SHIPMENT_SIZE_COUNT = 0;
    private static final int ANCESTOR_INDEX = 1;

    private final List<Product> productList;

    ShipmentSizeSelectionImpl(List<Product> productList) {
        this.productList = productList;
    }

    public ShipmentSize calculateShipmentSize() {
        ShipmentSize calculatedShipmentSize = null;

        for (ShipmentSize shipmentSize : ShipmentSize.values()) {
            long shipmentSizeCountFrequency = findShipmentSizeCountInProducts(shipmentSize);
            if (shipmentSizeCountFrequency == BASKET_ZERO_SHIPMENT_SIZE_COUNT)
                continue;

            calculatedShipmentSize = shipmentSize;

            if (shipmentSizeCountFrequency >= BASKET_THRESHOLD_COUNT_FOR_ANCESTOR_CALCULATION)
                return findAncestorShipmentSize(calculatedShipmentSize);
        }

        return calculatedShipmentSize;
    }

    private long findShipmentSizeCountInProducts(ShipmentSize shipmentSize) {
        return productList.stream()
                .filter((product -> product.getSize() == shipmentSize))
                .count();
    }

    private ShipmentSize findAncestorShipmentSize(ShipmentSize shipmentSize) {
        ShipmentSize[] shipmentSizeList = ShipmentSize.values();

        for (int i = 0; i < shipmentSizeList.length - ANCESTOR_INDEX; i++) {
            if (shipmentSizeList[i] == shipmentSize) {
                int indexOfAncestor = i + ANCESTOR_INDEX;
                return shipmentSizeList[indexOfAncestor];
            }
        }

        return shipmentSizeList[shipmentSizeList.length - 1];
    }
}
