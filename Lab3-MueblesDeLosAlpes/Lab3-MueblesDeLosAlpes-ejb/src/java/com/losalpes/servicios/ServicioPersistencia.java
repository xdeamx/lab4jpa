/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ ServicioPersistenciaMock.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * Autor: Juan Sebastián Urrego
 * Modificado por: Camilo Rodríguez Gaviria
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package com.losalpes.servicios;

import com.losalpes.entities.Mueble;
import com.losalpes.entities.Usuario;
import com.losalpes.excepciones.OperacionInvalidaException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Implementación de los servicios de persistencia
 * @author Juan Sebastián Urrego
 * @author Modificaciones por Camilo Rodríguez Gaviria
 */
@Stateless
public class ServicioPersistencia implements IServicioPersistenciaMockLocal,IServicioPersistenciaMockRemote, Serializable {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    
    /**
     * La entidad encargada de persistir en la base de datos
     */
    @PersistenceContext
    EntityManager em;
    EntityTransaction et;
    
    //TODO

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor de la clase. Inicializa los atributos.
     */
    public ServicioPersistencia()
    {
        
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------
    
    /**
     * Permite crear un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere crear.
     */
    @Override
    public void create(Object obj) throws OperacionInvalidaException
    {
       //TODO
        //et = em.getTransaction();
        //et.begin();
        em.persist(obj); 
        //et. commit(); 
    }

    /**
     * Permite modificar un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere modificar.
     */
    @Override
    public void update(Object obj)
    {
       //TODO
        em.merge(obj);
    }

    /**
     * Permite borrar un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere borrar.
     */
    @Override
    public void delete(Object obj) throws OperacionInvalidaException
    {
        if (obj != null) {
          em.remove(obj);
        }
    }

    /**
     * Retorna la lista de todos los elementos de una clase dada que se encuentran en el sistema.
     * @param c Clase cuyos objetos quieren encontrarse en el sistema.
     * @return list Listado de todos los objetos de una clase dada que se encuentran en el sistema.
     */
    @Override
    public List findAll(Class c)
    {
    String queryString = "SELECT c FROM "+c.getSimpleName()+" c ";
    Query query = em.createQuery(queryString);
    return query.getResultList();
    }

    /**
     * Retorna la instancia de una entidad dado un identificador y la clase de la entidadi.
     * @param c Clase de la instancia que se quiere buscar.
     * @param id Identificador unico del objeto.
     * @return obj Resultado de la consulta.
     */
    @Override
    public Object findById(Class c, Object id)
    {
        
        if (c.equals(Usuario.class))
        {
            String queryString = "SELECT c FROM "+c.getSimpleName()+" c  Where c.login ='"+String.valueOf(id)+"'";
            Query query = em.createQuery(queryString);
            List tmp=query.getResultList();
            if(tmp!=null){
             if(tmp.size()>0){
              return tmp.get(0);
             }
            }
            return null;
        }
        if(c.equals(Mueble.class)){
            String queryString = "SELECT m FROM "+c.getSimpleName()+" m  Where m.referencia="+String.valueOf(id)+"";
            Query query = em.createQuery(queryString);
            List tmp=query.getResultList();
            if(tmp!=null){
             if(tmp.size()>0){
              return tmp.get(0);
             }
            }
            return null;
            
        }else{
            return em.find(c, id);
        }
    }
}
