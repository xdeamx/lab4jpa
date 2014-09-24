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
    
    private String login;
    private int idPais=-1;
    private Pais pais=null;
    /**
     * Creates a new instance of ReportesBean
     */
    public ReportesBean() {
    }
    
    public List<RegistroVenta> getReportesComprasCliente(){
        Usuario usuario = (Usuario)persistenciaService.findById(Usuario.class, login);
        return usuario.getCompras();
    }
    
    public String verHistial(String login){
        this.login = login;
        return "HistorialUsuarioView";
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
        System.out.print(this.getIdPais());
        if(this.getIdPais() !=-1){
            this.pais = (Pais) persistenciaService.findById(Pais.class,new Long(this.getIdPais()));
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
        return (List<Pais>)persistenciaService.findAll(Pais.class);
    }

    /**
      * Retorna el listado de muebles más vendidos
      * @return Lista con todos los muebles mas vendidos
      */
     public List<Mueble> getMueblesMasVendidos()
    {
       //List<RegistroVenta> ventas = persistenciaService.findAll(RegistroVenta.class);
       List<Mueble> muebles = persistenciaService.findTopfurniture(3);
       return muebles;
    }
     
    /**
      * Retorna el listado de muebles
      * @return Lista con todos los muebles mas vendidos
      */
     public List<Mueble> getMuebles()
    {
       //List<RegistroVenta> ventas = persistenciaService.findAll(RegistroVenta.class);
       //List<Mueble> muebles = persistenciaService.findTopfurniture(3);
       return (List<Mueble>)persistenciaService.findAll(Mueble.class);
    }
     

    /**
     * @return the idPais
     */
    public int getIdPais() {
        return idPais;
    }

    /**
     * @param idPais the idPais to set
     */
    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }
     
     
}
