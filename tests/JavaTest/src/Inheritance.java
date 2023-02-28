public class Inheritance {
    public static void main(String[] args) {
        Apple a = new Apple();
    }
}

// ordem:
// 1. Construtor
// 2. chama a Super();
// 3. variáveis estáticas do construtor
// 4. atributos normais
// 5. finaliza o construtor
class Apple extends Fruit {
    static Print mp = new Print("Boskop!");
    Print mp2 = new Print("Gala!");
    public Apple() {
        // chamou a Fruit() 1 super();
        // mp -> static
        // atributos normais
        System.out.print("Jonagold!");
    }
}
class Fruit extends Edible {
    Print mp2 = new Print("Banana!");
    public Fruit() {
        // chamar a Editable()
        System.out.print("Cherry!");
    }
}
class Edible {
    static Print mp = new Print("Edible!");
}
class Print {
    public Print(String msg) {
        System.out.print(msg);
    }
}