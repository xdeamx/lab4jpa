/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ ReporteBean.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * Autor: Gabriel Martinez Rojas
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package com.losalpes.beans;

import com.losalpes.entities.Mueble;
import com.losalpes.entities.RegistroVenta;
import com.losalpes.servicios.IServicioPersistenciaMockLocal;
import com.losalpes.servicios.IServicioVendedoresMockLocal;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.ejb.EJB;

/**
 * Managed Bean encargado de la administración de reportes en el sistema
 * @author 
 */
public class ReportesBean implements Serializable
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Relación con la interfaz que provee los servicios necesarios de persistencia para los reportes
     */    
    @EJB
    private IServicioPersistenciaMockLocal persistenciaService;    
    
    /**
     * Relación con la interfaz que provee los servicios necesarios del vendedor
     */
    @EJB
    private IServicioVendedoresMockLocal vendedor;  

    /**
     * Representa un nuevo registro de venta a ingresar
     */
    private RegistroVenta registroVenta;



    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor sin argumentos de la clase
     */
    public ReportesBean()
    {
        registroVenta=new RegistroVenta();
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * Retorna un registro de ventas
     * @return 
     */    
    public RegistroVenta getRegistroVenta() {
        return registroVenta;
    }

    /**
     * Establece el registro de ventas
     * @param registroVenta 
     */
    public void setRegistroVenta(RegistroVenta registroVenta) {
        this.registroVenta = registroVenta;
    }
 

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

     /**
      * Retorna el listado de muebles más vendidos
      * @return Lista con todos los muebles mas vendidos
      */
     public List<Mueble> getMueblesMasVendidos()
    {
       /*List<RegistroVenta> registrosVentas = persistenciaService.findAll(RegistroVenta.class);
        for (RegistroVenta registro : registrosVentas) {
            System.out.println(registro.getCantidad());
        }*/

        List<Mueble> muebles = persistenciaService.findTopMuebles(Mueble.class);
       
        return muebles;




    }
   
     
     
     
}
