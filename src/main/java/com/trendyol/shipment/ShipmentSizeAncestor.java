package com.trendyol.shipment;

class ShipmentSizeAncestor {
    static ShipmentSize findAncestorShipmentSize(ShipmentSize shipmentSize){
        switch (shipmentSize) {
            case SMALL:
                return ShipmentSize.MEDIUM;
            case MEDIUM:
                return ShipmentSize.LARGE;
            default:
                return ShipmentSize.X_LARGE;
        }
    }
}

