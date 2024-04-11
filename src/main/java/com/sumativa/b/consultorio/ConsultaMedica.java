package com.sumativa.b.consultorio;

import java.util.Date;

public class ConsultaMedica {
    private Date fecha;
    private String motivoConsulta;
    private String diagnostico;
    private String tratamiento;

    public ConsultaMedica(Date fecha, String motivoConsulta, String diagnostico, String tratamiento) {
        this.fecha = fecha;
        this.motivoConsulta = motivoConsulta;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
    }

    public Date getFecha() {
        return fecha;
    }
    public String getMotivoConsulta() {
        return motivoConsulta;
    }
    public String getDiagnostico() {
        return diagnostico;
    }
    public String getTratamiento() {
        return tratamiento;
    }

    
}
