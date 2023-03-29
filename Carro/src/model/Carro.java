package model;

public class Carro {

    // atributos
    private String marca;
    private String placa;
    private String apelido;
    private int ano;
    private int farol;
    private double combustivel;
    private boolean ligado;
    private double eficienciaPorLitro = 2;

    // construtor: método chamado na criação do objeto
    public Carro (String marca, String placa, int ano) {
        this.marca = marca;
        this.placa = placa;
        this.ano = ano;
        this.ligado = false;
        this.combustivel = 0;
    }

    public Carro(String marca, String placa, String apelido, int ano) {
        this.marca = marca;
        this.placa = placa;
        this.apelido = apelido;
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }

    public String getPlaca() {
        return placa;
    }

    public int getAno() {
        return ano;
    }

    public int getFarol() {
        return farol;
    }

    public double getCombustivel() {
        return combustivel;
    }

    public boolean isLigado() {
        return ligado;
    }

    public double getEficienciaPorLitro() {
        return eficienciaPorLitro;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    // métodos
    public void ligar() {
        if(combustivel <= 0)
            return;

        ligado = true;

        if(farol == 0)
            farol = 1;
    }

    public void desligar() {
        ligado = false;
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
