import model.Account;

public class App {
    public static void main(String[] args) {

        Account acc = new Account("Joao");
        Account acc2 = new Account("Maria");

        acc.deposit(200);
        System.out.println("after deposit 200: " + acc.getBalance());

        acc.withdraw(125);
        System.out.println("after withdraw 125: " + acc.getBalance());

        acc.deposit(240);
        System.out.println("after deposit 240: " + acc.getBalance());

        acc.transfer(95, acc2);
        System.out.println("after transfer 95: " + acc.getBalance());
        System.out.println("after recieve 95: " + acc2.getBalance());

    }
}
