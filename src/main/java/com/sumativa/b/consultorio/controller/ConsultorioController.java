package com.sumativa.b.consultorio.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import com.sumativa.b.consultorio.model.AtencionMedica;
import com.sumativa.b.consultorio.model.ConsultaMedica;
import com.sumativa.b.consultorio.model.HistorialMedico;
import com.sumativa.b.consultorio.model.Paciente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class ConsultorioController {

    List<Paciente> pacientes = new ArrayList<>();

    public ConsultorioController(){

        //Se definen los Pacientes
        pacientes.add(new Paciente(1 ,"11.289.528-0", "Juanito Perez", "juan.perez@gmail.com", new Date(2024), "calle 123, La Reina", 
                        new HistorialMedico(generarConsultasMedicas(2), generarAtencionesMedicas(5))));
        pacientes.add(new Paciente(2 ,"33.666.999-8", "Juan Pablito", "juan.pablo@gmail.com", new Date(5), "calle 123, La Reina", 
                        new HistorialMedico(generarConsultasMedicas(4), generarAtencionesMedicas (4))));
        pacientes.add(new Paciente(3, "12.345.678-9", "Chunito Perez", "chunito.perez@gmail.com", new Date(14), "calle 123, La Reina", 
                        new HistorialMedico(generarConsultasMedicas(3), generarAtencionesMedicas(1))));
        pacientes.add(new Paciente(4, "23.456.789-0", "María González", "maria.gonzalez@gmail.com", new Date(3), "calle 123, La Reina", 
                        new HistorialMedico(generarConsultasMedicas(5), generarAtencionesMedicas(3))));
        pacientes.add(new Paciente(5, "34.567.890-1", "Pedro Rodríguez", " pedro.rodriguez@gmail.com", new Date(2), "calle 123, La Reina", 
                        new HistorialMedico(generarConsultasMedicas(2), generarAtencionesMedicas(4))));
        pacientes.add(new Paciente(6, "45.678.901-2", "Ana López", " ana.lopez@gmail.com", new Date(2024), "calle 123, La Reina", 
                        new HistorialMedico(generarConsultasMedicas(3), generarAtencionesMedicas(5))));
        pacientes.add(new Paciente(7, "56.789.012-3", "Carlos Martínez", "carlos.martinez@gmail.com", new Date(10), "calle 123, La Reina", 
                        new HistorialMedico(generarConsultasMedicas(1), generarAtencionesMedicas(1))));
        pacientes.add(new Paciente(8, "67.890.123-4", "Laura Sánchez", "laura.sanchez@gmail.com", new Date(79), "calle 123, La Reina", 
                        new HistorialMedico(generarConsultasMedicas(4), generarAtencionesMedicas(5))));
    }
    

    @GetMapping("/pacientes")
    public List<Paciente> getPacientes() {
        return pacientes;
    }
    
    @GetMapping("/pacientes/{id}")
    public Paciente getPacienteById(@PathVariable int id) {
        for(Paciente p: pacientes){
            if(p.getId() == id){
                return p;
            }
        }

        return new Paciente();
    }
    
    @GetMapping("/pacientes/{id}/historial")
    public HistorialMedico getPacienteHistorialMedico(@PathVariable int id) {
        for(Paciente p: pacientes){
            if(p.getId() == id){
                return p.getHistorialMedicos();
            }
        }

        return null;
    }
    
    @GetMapping("/pacientes/{id}/historial/consultas")
    public List<ConsultaMedica> getConsultasPaciente(@PathVariable int id) {
        for(Paciente p: pacientes){
            if(p.getId() == id){
                return p.getHistorialMedicos().getConsultas();
            }
        }
        return null;
    }

    @GetMapping("/pacientes/{id}/historial/atenciones")
    public List<AtencionMedica> getAtencionesPaciente(@PathVariable int id) {
        for(Paciente p: pacientes){
            if(p.getId() == id){
                return p.getHistorialMedicos().getAtenciones();
            }
        }
        return null;
    }
    

    @GetMapping("/pacientes/contar")
    public HashMap<String, Integer> getCantidadPacientes() {
        HashMap<String, Integer> cantidad = new HashMap<String, Integer>();
        cantidad.put("Cantidad Pacientes", pacientes.size());
        return cantidad;
    }
    



    public List<AtencionMedica> generarAtencionesMedicas(int indice){
        List<AtencionMedica> atenciones = new ArrayList<>();
        String[] tipoAtencion = new String[] {"Hospitalización","Procedimiento Quirúrgico","Tratamiento","Otro", "etc."};
        List<Calendar> listaFechas = new ArrayList<>();
        
        // Crear fechas predefinidas
        Calendar fecha1 = new GregorianCalendar(2023, Calendar.JANUARY, 15);
        Calendar fecha2 = new GregorianCalendar(2023, Calendar.MAY, 7);
        Calendar fecha3 = new GregorianCalendar(2023, Calendar.AUGUST, 22);
        Calendar fecha4 = new GregorianCalendar(2023, Calendar.NOVEMBER, 3);
        Calendar fecha5 = new GregorianCalendar(2024, Calendar.FEBRUARY, 10);

        // Agregar las fechas a la lista
        listaFechas.add(fecha1);
        listaFechas.add(fecha2);
        listaFechas.add(fecha3);
        listaFechas.add(fecha4);
        listaFechas.add(fecha5);
        
        for(int i = 0; i < indice; i++){

            AtencionMedica a = new AtencionMedica(listaFechas.get(i).getTime(), 
                                tipoAtencion[i], "Esta es una descripcion de ejemplo: "+i);
            atenciones.add(a);
        }
        
        return atenciones;
    }


    public List<ConsultaMedica> generarConsultasMedicas(int indice){
        List<ConsultaMedica> consultas = new ArrayList<>();
        String[] motivoConsulta = new String[] {"Dolor abdominal", "Fiebre persistente", "Dolor de cabeza intenso", "COVID!", "Síntomas de gripe"};
        String[] diagnosticos = new String[] {"Gastritis", "Neumonía", "Migraña", "COVID!!", "Resfriado común"};
        String[] tratamientos = new String[] {"Antiacidos y dieta", "Antibióticos y reposo", "Analgésicos y descanso", "COVID!!!", "Descanso y líquidos"};


        List<Calendar> listaFechas = new ArrayList<>();
        
        // Crear fechas predefinidas
        Calendar fecha1 = new GregorianCalendar(2023, Calendar.JANUARY, 15);
        Calendar fecha2 = new GregorianCalendar(2023, Calendar.MAY, 7);
        Calendar fecha3 = new GregorianCalendar(2023, Calendar.AUGUST, 22);
        Calendar fecha4 = new GregorianCalendar(2023, Calendar.NOVEMBER, 3);
        Calendar fecha5 = new GregorianCalendar(2024, Calendar.FEBRUARY, 10);

        // Agregar las fechas a la lista
        listaFechas.add(fecha1);
        listaFechas.add(fecha2);
        listaFechas.add(fecha3);
        listaFechas.add(fecha4);
        listaFechas.add(fecha5);
        
        for(int i = 0; i < indice; i++){
            ConsultaMedica c = new ConsultaMedica(listaFechas.get(i).getTime(), motivoConsulta[i],diagnosticos[i], tratamientos[i]);
            consultas.add(c);
        }
        
        return consultas;
    }
}
