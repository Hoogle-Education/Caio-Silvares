package model;

import java.util.Objects;

public class Client {

    private int securityNumber;
    private String name;
    private boolean blocked;

    public Client(int securityNumber, String name) {
        this.securityNumber = securityNumber;
        this.name = name;
        this.blocked = true;
    }

    public int getSecurityNumber() {
        return securityNumber;
    }

    public String getName() {
        return name;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void unblock() {
        this.blocked = false;
    }

    public void block() {
        this.blocked = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (securityNumber != client.securityNumber) return false;
        return Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        int result = securityNumber;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "securityNumber=" + securityNumber +
                ", name='" + name + '\'' +
                '}';
    }
}
