package com.example.appcotizacion;
/*
Encinas Balderas Juan Angel
Clase Cotizacion en Java
*/

public class Cotizacion {
    private int id;
    private int plazo;
    private String descripcion;
    private float precio;
    private float porcentajeP;

    public Cotizacion() {
    }

    public Cotizacion(int id, int plazo, String descripcion, float precio, float porcentajeP) {
        this.id = id;
        this.plazo = plazo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.porcentajeP = porcentajeP;
    }

    public Cotizacion(Cotizacion cotizacion) {
        this.id = cotizacion.id;
        this.plazo = cotizacion.plazo;
        this.descripcion = cotizacion.descripcion;
        this.precio = cotizacion.precio;
        this.porcentajeP = cotizacion.porcentajeP;
    }

    public void imprimirCotizacion(){
        System.out.println("Número de cotización: " + this.getId() +
                "\nDescripción: " + this.getDescripcion() +
                "\nPrecio: " + this.getPrecio() +
                "\nPorcentaje Pago Inicial: " + this.getPorcentajeP() +
                "\nPlazo: " + this.getPlazo() +
                "\nPago Inicial: " + this.calcularPagoInicial() +
                "\nTotal a fin: " + this.calcularTotal() +
                "\nPago Mensual: " + this.calcularMensualidad());
    }

    public float calcularPagoInicial(){
        return this.getPrecio() * (this.getPorcentajeP()/100);
    }

    public float calcularTotal(){
        return this.getPrecio() - this.calcularPagoInicial();
    }

    public float calcularMensualidad(){
        return this.calcularTotal() / this.getPlazo();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlazo() {
        return this.plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getPorcentajeP() {
        return this.porcentajeP;
    }

    public void setPorcentajeP(float porcentaje_pago) {
        this.porcentajeP = porcentaje_pago;
    }

}