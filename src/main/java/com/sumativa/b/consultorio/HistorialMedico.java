package com.sumativa.b.consultorio;

import java.util.List;

public class HistorialMedico {
    private List<ConsultaMedica> consultas;
    private List<AtencionMedica> atenciones;
    
    public HistorialMedico(List<ConsultaMedica> consultas, List<AtencionMedica> atenciones) {
        this.consultas = consultas;
        this.atenciones = atenciones;
    }

    public List<ConsultaMedica> getConsultas() {
        return consultas;
    }

    public List<AtencionMedica> getAtenciones() {
        return atenciones;
    }

    
}
