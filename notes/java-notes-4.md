# POO

## Motivação

```java
public static void main(String[] args) {

  int quantidadeDeAlunos = 100;

  String[] nomes = new String[quantidadeDeAlunos];
  String[] cpfs = new String[quantidadeDeAlunos];
  int[] idades = new int[quantidadeDeAlunos];
  double[] notas = new double[quantidadeDeAlunos];

}
```

**trocar duas variáveis:**

```java
int a = 2, b = 3; // a = 2, b = 3
int aux = a; // aux =2
a = b; // a = 3 , b = 3 , aux = 2
b = aux;
```

## Começando POO

```java
public class Carro {

  // atributos
  public String marca;
  public String placa;
  public int ano;
  public int farol; // 0, 1, 2, 3
  public double combustivel;
  public boolean estaLigado;
  private double eficienciaPorLitro = 2;

  // construtor: método chamado na criação do objeto
  public Carro (String marca, String placa, int ano) {
    this.marca = marca;
    this.placa = placa;
    this.ano = ano;
    this.estaLigado = false;
    this.combustivel = 0;
  }

  // métodos
  public void ligar() {
    if(combustivel < 0)
      return;

    estaLigado = true;

    if(farol == 0)
      farol = 1;
  }

  public void desligar() {
    estaLigado = false;
  }

  public void aumentarFarol() {
    farol++;
    if(farol > 3) farol = 3;
  }

  public void abaixarFarol() {
    farol--;
    if(farol < 0) farol = 0;
  }

  public void abastecer(double combustivel) {
    this.combustivel += combustivel;
  }

  public double calculaGastoDeCombustivel(double distancia) {
    return distancia*eficienciaPorLitro;
  }
}
```

```java
public static void main(String[] args) {
  Carro carro1 = new Carro(); // construção, utilização
  carro1.estaLigado = true;
}
```
