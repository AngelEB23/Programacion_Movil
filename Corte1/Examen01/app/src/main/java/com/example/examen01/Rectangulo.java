package com.example.examen01;

public class Rectangulo {

    private float base;
    private float altura;

    public Rectangulo(){

    }
    public Rectangulo(float base, float altura){
        this.base = base;
        this.altura = altura;
    }

    public float calculoArea(){
        return (this.base * this.altura);
    }

    public float calculoPerimetro(){
        return ((this.altura * 2) + (this.base * 2));
    }
}
