package service;

import exceptions.ClientNotFoundException;
import model.Client;
import model.Request;

import java.util.List;

public class RequestService {

    private List<Client> clients;

    public void processRequest(Request request)
            throws ClientNotFoundException {
        switch (request.getOperationStatusCode()) {
            case REGISTER -> registerClient(request.getRequestBody());
            case UNBLOCK -> unblockClient(request.getRequestBody());
        }
    }

    private void unblockClient(String requestBody)
            throws ClientNotFoundException {

        String[] bodyValues = requestBody.split(" ");
        Client clientDataToFind = parseClientFromAttributes(bodyValues);
        Client clientToUnblock = clients.stream()
                .filter(c -> c.equals(clientDataToFind))
                .findFirst()
                .orElseThrow(ClientNotFoundException::new);

        clientToUnblock.unblock();
    }

    private void registerClient(String requestBody) {
        String[] bodyValues = requestBody.split(" ");
        Client clientToRegister = parseClientFromAttributes(bodyValues);
        clients.add(clientToRegister);
    }

    private Client parseClientFromAttributes(String[] requestAttributes) {
        String name = requestAttributes[0];
        int securityNumber = Integer.parseInt(requestAttributes[1]);
        return new Client(securityNumber, name);
    }

}
