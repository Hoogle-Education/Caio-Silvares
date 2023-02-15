package util;

import java.util.ArrayList;
import java.util.List;

public class MinhaLista {

    private List<Double> numbers;

    public MinhaLista() {
        numbers = new ArrayList<>();
    }

    public void add(double newElement) {
        numbers.add(newElement);
    }

    private void iterate(int startPosition) {
        for(int i = startPosition; i<= numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
    }

    public void iterate(){
        iterate(0);
    }

}
