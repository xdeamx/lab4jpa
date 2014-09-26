/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;

/**
 *
 * @author xDEAMx
 */
@Embeddable
public class RegistroVentaPk implements Serializable{
    @Column(name = "comprador_id")
    private Long usuarioId;
    @Column(name = "producto_id")
    private Long muebleId;
     @Column(name = "fechaventa")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;

    
    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getMuebleId() {
        return muebleId;
    }

    public void setMuebleId(Long muebleId) {
        this.muebleId = muebleId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
