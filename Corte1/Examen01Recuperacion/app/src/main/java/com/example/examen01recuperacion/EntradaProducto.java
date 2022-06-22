package com.example.examen01recuperacion;

public class EntradaProducto {

    private String codigo;
    private String descripcion;

    public EntradaProducto(){

    }

    public EntradaProducto(String codigo, String descripcion){
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public int calcularPrecioCompra(int precioC, int cant){
        return(precioC*cant);
    }

    public int calcularPrecioVenta(int precioV, int cant){
        return(precioV*cant);
    }

    public int calcularGanancia(int precioV, int precioC, int cant){
        return((precioV-precioC)*cant);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
