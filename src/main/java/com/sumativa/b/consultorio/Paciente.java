package com.sumativa.b.consultorio;

import java.sql.Date;

public class Paciente {
    private int id;
    private String rut;
    private String nombre;
    private String correo;
    private Date fechaNacimeinto;
    private String direccion;
    private HistorialMedico historialMedicos;

    
    public Paciente() {
    }

    public Paciente(int id, String rut, String nombre, String correo, Date fechaNacimeinto, String direccion,
            HistorialMedico historialMedicos) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.correo = correo;
        this.fechaNacimeinto = fechaNacimeinto;
        this.direccion = direccion;
        this.historialMedicos = historialMedicos;
    }

    public int getId() {
        return id;
    }


    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public Date getFechaNacimeinto() {
        return fechaNacimeinto;
    }

    public String getDireccion() {
        return direccion;
    }

    public HistorialMedico getHistorialMedicos() {
        return historialMedicos;
    }



    
    


    
}
