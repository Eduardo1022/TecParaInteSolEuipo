package com.example.transporte;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transportes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String marca ;
    private String modeo;
    private int anio;
    private int asientos;

    

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return String return the modeo
     */
    public String getModeo() {
        return modeo;
    }

    /**
     * @param modeo the modeo to set
     */
    public void setModeo(String modeo) {
        this.modeo = modeo;
    }

    /**
     * @return int return the anio
     */
    public int getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**
     * @return int return the asientos
     */
    public int getAsientos() {
        return asientos;
    }

    /**
     * @param asientos the asientos to set
     */
    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

}