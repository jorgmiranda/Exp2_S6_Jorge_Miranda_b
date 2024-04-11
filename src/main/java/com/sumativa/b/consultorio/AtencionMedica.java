package com.sumativa.b.consultorio;

import java.util.Date;

public class AtencionMedica {
    private Date fecha;
    private String tipo; 
    private String descripcion;

    public AtencionMedica(Date fecha, String tipo, String descripcion) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    

    
}
