/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.entity;

/**
 *
 * @author Jaime Ambrosio
 */
public class TipoUsuario {

    public TipoUsuario() {
    }

    public TipoUsuario(Integer idTipoUsuario, String nombreTUsuario, String observacion) {
        this.idTipoUsuario = idTipoUsuario;
        this.nombreTUsuario = nombreTUsuario;
        this.observacion = observacion;
    }
    
    private Integer idTipoUsuario;
    private String nombreTUsuario;
    private String observacion;

    /**
     * @return the idTipoUsuario
     */
    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    /**
     * @param idTipoUsuario the idTipoUsuario to set
     */
    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    /**
     * @return the nombreTUsuario
     */
    public String getNombreTUsuario() {
        return nombreTUsuario;
    }

    /**
     * @param nombreTUsuario the nombreTUsuario to set
     */
    public void setNombreTUsuario(String nombreTUsuario) {
        this.nombreTUsuario = nombreTUsuario;
    }

    /**
     * @return the observacion
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * @param observacion the observacion to set
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
