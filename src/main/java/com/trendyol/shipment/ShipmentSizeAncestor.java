package com.trendyol.shipment;


public class ShipmentSizeAncestor {

    public static final int ANCESTOR_INDEX = 1;

    public static ShipmentSize findAncestorShipmentSize(ShipmentSize shipmentSize) {
        ShipmentSize[] shipmentSizeList = ShipmentSize.values();

        for (int i = 0; i < shipmentSizeList.length - ANCESTOR_INDEX; i++) {
            if (shipmentSizeList[i] == shipmentSize) {
                return shipmentSizeList[i + ANCESTOR_INDEX];
            }
        }

        return shipmentSizeList[shipmentSizeList.length - 1];
    }
}
