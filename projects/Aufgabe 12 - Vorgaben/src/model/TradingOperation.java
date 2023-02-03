package model;

import model.enums.OperationMode;

public class TradingOperation {

    private OperationMode operationMode;
    private long itemCode;

    public TradingOperation(OperationMode operationMode, long itemCode) {
        this.operationMode = operationMode;
        this.itemCode = itemCode;
    }
}
