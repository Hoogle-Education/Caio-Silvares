# OOP

## Classe

* molde
* novo tipo de variável
* fábrica de objetos

uma classe é composta por:

* tem (atributos)
* fazer (métodos)

## Objeto

* fruto do molde
* variável com as características do molde

```java
public class Pessoa {

  // atributos
  public String name;
  public int age;
  public double heigth;

  // métodos
  public void makeBirthday() {
    age++;
  }

}
```

chamando isto em outro lugar:

```java
Pessoa maria = new Pessoa();
Pessoa teste = maria;

// cuidado!
maria.name = "Maria"
teste.name = "nome alterado";

// a saída para o maria.nome será "nome alterado"
```

# Vetores

## gambiarra para adicionar no final

método para adicionar um elemento no final do atributo vetor.

```java
public void add(int element) {

  int originalSize = array.length;
  int[] oldElements = array;
  array = new int[originalSize + 1];

  for(int i = 0; i < originalSize; i++){
    array[i] = oldElements[i];
  }

  array[array.length - 1] = element;
}
```

```
element = 4;
originalSize = 3;
oldElements = [1, 2, 3]
array = [1, 2, 3, 4]
```