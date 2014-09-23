/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ RegistroVenta.java
 * Universidad de los Andes (Bogota - Colombia)
 * Departamento de Ingenieria de Sistemas y Computacion
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles los Alpes
 * Autor: Juan Sebastián Urrego
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package com.losalpes.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 * Clase que modela un registro de venta realizado por un cliente
 * @author Juan Sebastián Urrego
 */

@Entity
public class RegistroVenta implements Serializable
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    
    /**
     * Fecha en la que se vendió el producto
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaVenta;

    /**
     * Producto vendido
     */
    @OneToOne( fetch = FetchType.LAZY)
    private Mueble producto;

    /**
     * Cantidad vendida del producto
     */
    private int cantidad;

    /**
     * Ciudad en la que se vendió el producto
     */
    private String ciudad;

    /**
     * Usuario que compró el producto
     */
    
    @ManyToOne (fetch = FetchType.LAZY)
    private Usuario comprador;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    /**
     * Constructor sin argumentos
     */
    public RegistroVenta()
    {
        
    }

    /**
     * Constructor de la clase con argumentos
     * @param fechaVenta Fecha en que se realizó la venta
     * @param producto Mueble adquirido
     * @param cantidad Cantidad adquirida
     * @param ciudad Ciudad en la que se vendió el producto
     * @param comprador Usuario que compro el mueble
     */
    public RegistroVenta(Date fechaVenta, Mueble producto, int cantidad,
            String ciudad, Usuario comprador)
    {
        this.fechaVenta = fechaVenta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.ciudad = ciudad;
        this.comprador = comprador;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * Devuelve la cantidad de producto vendido
     * @return cantidad Cantidad de producto vendido
     */
    public int getCantidad()
    {
        return cantidad;
    }

    /**
     * Modifica la cantidad de muebles adquiridos
     * @param cantidad Nueva cantidad de muebles
     */
    public void setCantidad(int cantidad)
    {
        this.cantidad = cantidad;
    }

    /**
     * Devuelve la fecha en que se vendió el mueble
     * @return fechaVenta Fecha de venta del mueble
     */
    public Date getFechaVenta()
    {
        return fechaVenta;
    }

    /**
     * Modifica la fecha en que se vendió el mueble
     * @param fechaVenta Nueva fecha de venta
     */
    public void setFechaVenta(Date fechaVenta)
    {
        this.fechaVenta = fechaVenta;
    }

    /**
     * Devuelve el mueble adquirido
     * @return producto Mueble adquirido
     */
    public Mueble getProducto()
    {
        return producto;
    }

    /**
     * Modifica el mueble adquirido
     * @param producto Nuevo mueble
     */
    public void setProducto(Mueble producto)
    {
        this.producto = producto;
    }

    /**
     * Devuelve la ciudad en dónde se realizó la venta
     * @return ciudad Ciudad
     */
    public String getCiudad()
    {
        return ciudad;
    }

    /**
     * Modifica la ciudad dónde se realizó la venta
     * @param ciudad Nueva ciudad
     */
    public void setCiudad(String ciudad)
    {
        this.ciudad = ciudad;
    }

    /**
     * Devuelve el usuario que realizó la compra
     * @return comprador Usuario que realizó la compra
     */
    public Usuario getComprador()
    {
        return comprador;
    }

    /**
     * Modifica el usuario que realizó la compra
     * @param comprador Nuevo usuario
     */
    public void setComprador(Usuario comprador)
    {
        this.comprador = comprador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
