package com.example.appdestinofeliz;
/*
Encinas Balderas Juan Angel
Clase boleto en Java
*/

public class Boleto {
    private int id, tipoViaje;
    private String nombre, destino, fecha;
    private float precio;

    public Boleto(){
    }

    public Boleto(int id, int tipo, String nombre, String destino, String fecha, float precio) {
        this.id = id;
        this.tipoViaje = tipo;
        this.nombre = nombre;
        this.destino = destino;
        this.fecha = fecha;
        this.precio = precio;
    }

    public Boleto(Boleto boleto) {
        this.id = boleto.id;
        this.tipoViaje = boleto.tipoViaje;
        this.nombre = boleto.nombre;
        this.destino = boleto.destino;
        this.fecha = boleto.fecha;
        this.precio = boleto.precio;
    }

    public void imprimirBoleto(int edad) {
        System.out.println("No. Boleto: " + this.getId() +
                "\nNombre cliente: " + this.getNombre() +
                "\nDestino: " + this.getDestino() +
                "\nTipo viaje: " + this.getTipoViaje() +
                "\nPrecio: " + this.getPrecio() +
                "\nFecha: " + this.getFecha() +
                "\n ====================== Importe ====================== \n\n" +
                "Subtotal: " + this.mostrarPrecio() +
                "Impuesto 16%: " + this.mostrarIVA() +
                "Descuento: " + this.mostrarDescuento(edad) +
                "Total a pagar: " + this.mostrarTotal(edad));
    }

    public float mostrarPrecio() {
        if(this.getTipoViaje() == 1)
            return this.getPrecio();

        return (float) (this.getPrecio() * 1.8);
    }

    public float mostrarIVA() {
        return (float) (this.mostrarPrecio() * 0.16);
    }

    public float mostrarDescuento(int edad) {
        if(edad < 60)
            return 0;

        return (this.mostrarPrecio() + this.mostrarIVA()) / 2;
    }

    public float mostrarTotal(int edad) {
        return this.mostrarPrecio() + this.mostrarIVA() - this.mostrarDescuento(edad);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipoViaje() {
        return this.tipoViaje;
    }

    public void setTipoViaje(int tipo) {
        this.tipoViaje = tipo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDestino() {
        return this.destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

}
