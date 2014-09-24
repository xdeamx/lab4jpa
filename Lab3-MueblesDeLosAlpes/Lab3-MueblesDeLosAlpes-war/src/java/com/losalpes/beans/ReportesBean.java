package com.losalpes.beans;

import com.losalpes.entities.Ciudad;
import com.losalpes.entities.Mueble;
import com.losalpes.entities.Pais;
import com.losalpes.entities.RegistroVenta;
import com.losalpes.entities.Usuario;
import com.losalpes.servicios.IServicioPersistenciaMockLocal;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Managed Bean encargado de la administración de reportes en el sistema
 * @author paulacastellanos
 */
@ManagedBean(name = "reportesBean")
@SessionScoped
public class ReportesBean {

    @EJB
    private IServicioPersistenciaMockLocal persistenciaService;
    
    private int idCliente;
    private Pais pais=null;
    /**
     * Creates a new instance of ReportesBean
     */
    public ReportesBean() {
    }
    
    public List<RegistroVenta> getReportesComprasCliente(){
        Usuario usuario = (Usuario)persistenciaService.findById(Usuario.class, idCliente);
        return usuario.getCompras();
    }
    
    public String verHistial(int idCliente){
        this.idCliente = idCliente;
        return "verHistorialCliente";
    }
    
    public void setPais(Pais pais){
        this.pais = pais;
    }
    public Pais getPais(){
        return pais;
    }
    
    public List<Usuario> getTop5Usuarios(){
        List<Usuario> usuarios= new LinkedList<Usuario>();
        List<Ciudad> ciudades;
        if(this.pais !=null){
            ciudades = this.pais.getCiudades();
            usuarios = persistenciaService.findUsersByCities(ciudades,5);
        }
        return usuarios;
    }
    
    public int calcularTotalCompras(Usuario usuario){
        int total = 0;
        for(RegistroVenta compra : usuario.getCompras()){
            total += compra.getCantidad() * compra.getProducto().getPrecio();
        }
        return total;
    }
    
    public List<Pais> getPaises(){
        return persistenciaService.findAll(Pais.class);
    }

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
