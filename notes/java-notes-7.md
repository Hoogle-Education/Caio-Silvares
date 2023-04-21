# Avançando em herança

## recap

```java
public class Animal {

  private String name;
  private int age;
  protected double size;

  // getters setters etc
  // toString
}

public class Feline extends Animal {

  public double jump() {
    return -1;
  }

}

public class Cat extends Feline {

  public String meow() {
    return "meow";
  }

  @Override
  public double jump() {
    return 1.5 * size;
  }
}

public class Guepard extends Feline {
  @Override
  public double jump() {
    return 2 * size;
  }
}
```

## Upcasting e Downcasting

```java
// Upcasting - é seguro
Animal a1 = new Cat();
Guepard g1 = new Guepard();
Pessoa p1 = new Aluno();
Aircraft air1 = new Plane();
Aircraft air2 = new Helicopter();

var a2 = (Animal) (new Cat()); // tbm upcasting

var numerador = 3.0;
var denominador = 2;
numerador / (double) denominador => 1

List<Animal> animals = new List<Animal>();
animals.add(a1);
animals.add(g1);
var animal = animals.get(0);



var position = animals.find(new Cat("garfield", 5, 1.3));

List<Cat> cats = animals
  .stream()
  .filter(a -> a istanceof Cat)
  .toList();
```

## Encapsulamento

|tipo|visibilidade|
|public| acessável em tudo|
|private| acessável somente na própria classe|
|protected| acessável na própria classe e nas classes filhas|
