package model;

public class Account {

  private static int count = 1;

  private int id;
  private String holder;
  private double balance;
  private boolean active;

  public Account(String holder) {
    this.id = count++;
    this.holder = holder;
    this.balance = 0;
    this.active = true;
  }

  public int getId() {
    return id;
  }

  public String getHolder() {
    return holder;
  }

  public double getBalance() {
    return balance;
  }

  public boolean isActive() {
    return active;
  }

  // depositar
  public void deposit(double amount) {
    balance += amount;
  }

  // sacar
  public boolean withdraw(double amount) {
    if (balance < amount)
      return false;

    if (!isActive())
      return false;

    balance -= amount;
    return true;
  }

  // transferir
  public boolean transfer(double amount, Account destination) {
    if (!this.withdraw(amount))
      return false;

    destination.deposit(amount);
    return true;
  }

}