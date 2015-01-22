package com.vivelabhuila.carrito;

/**
 * Created by andres on 22/01/15.
 */
public class Elemento {

    private String nombre;
    private double valor;

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public double getValor(){
        return this.valor;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

}
