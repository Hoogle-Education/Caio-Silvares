# Melhorando POO

```java
public class Carro {

  // atributos
  private String marca;
  private String placa;
  private int ano;
  private int farol; // 0, 1, 2, 3
  private double combustivel;
  private boolean estaLigado;
  private double eficienciaPorLitro = 2;

  // construtor: método chamado na criação do objeto
  public Carro (String marca, String placa, int ano) {
    this.marca = marca;
    this.placa = placa;
    this.ano = ano;
    this.estaLigado = false;
    this.combustivel = 0;
  }

  // getter and setter
  public String getMarca() {
    return marca;
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
