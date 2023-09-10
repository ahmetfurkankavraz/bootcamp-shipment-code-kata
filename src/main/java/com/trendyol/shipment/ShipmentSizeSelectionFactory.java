package com.trendyol.shipment;

import java.util.List;

public class ShipmentSizeSelectionFactory {
    public static ShipmentSizeSelection getShipmentSizeSelection(Basket basket) {
        return new ShipmentSizeSelectionImpl(basket);
    }
}
