package com.trendyol.shipment;

import java.util.List;

public class ShipmentSizeSelectionFactory {
    public static ShipmentSizeSelection getShipmentSizeSelection(List<Product> productList) {
        return new ShipmentSizeSelectionImpl(productList);
    }
}
