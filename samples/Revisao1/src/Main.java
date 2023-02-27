import model.BasicEmployee;
import model.Employee;
import model.ManagerEmployee;
import model.ServiceEmployee;


public class Main {
    public static void main(String[] args) {

//        MinhaLista lista = new MinhaLista();
//        lista.add(1);
//        lista.add(2);
//        lista.add(3);
//        lista.iterate();

        Employee emp1 = new BasicEmployee("pedro", "pedro", 25);
        Employee emp2 = new ServiceEmployee("lucas", "pedro", 25);
        Employee emp3 = new ManagerEmployee("beatriz", "pedro", 25);

        tryGivePromotion(emp2, emp3);
        tryGivePromotion(emp2, emp1);

        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);

    }

    private static void tryGivePromotion(Employee toPromote, Employee toBePromoted) {
        try {
            toPromote.upgrade(toBePromoted);
        } catch (Exception exception) {
            System.err.println(exception);
        }
    }
}