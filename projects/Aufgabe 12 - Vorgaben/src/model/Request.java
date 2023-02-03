package model;

import exceptions.InvalidRequestException;
import model.enums.OperationStatusCode;

import java.util.Optional;

public class Request {

    private int requestCode;
    private String requestBody;
    private OperationStatusCode operationStatusCode;
    private Optional<Client> client = Optional.empty();
    private Optional<TradingOperation> tradingOperation = Optional.empty();

    public Request(int requestCode)
        throws InvalidRequestException {
        this.requestCode = requestCode;
        switch (requestCode) {
            case 0 -> operationStatusCode = OperationStatusCode.REGISTER;
            case 1 -> operationStatusCode = OperationStatusCode.UNBLOCK;
            case 2 -> operationStatusCode = OperationStatusCode.DELETE;
            case 3 -> operationStatusCode = OperationStatusCode.SALES_PRICE;
            case 4 -> operationStatusCode = OperationStatusCode.PUCHARSES_PRICE;
            case 5 -> operationStatusCode = OperationStatusCode.INVENTORY;
            case 6 -> operationStatusCode = OperationStatusCode.BUY;
            case 7 -> operationStatusCode = OperationStatusCode.SELL;
            default -> throw new InvalidRequestException();
        }
    }

    public OperationStatusCode getOperationStatusCode() {
        return operationStatusCode;
    }

    public String getRequestBody() {
        return requestBody;
    }
    public Optional<Client> getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = Optional.of(client);
    }

    public Optional<TradingOperation> getTradingOperation() {
        return tradingOperation;
    }

    public void setTradingOperation(TradingOperation tradingOperation) {
        this.tradingOperation = Optional.of(tradingOperation);
    }


}
