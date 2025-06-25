package Interfaces;

import Interfaces.Usuario;

public class Pacientes extends Usuario implements IGestionPaciente {
    
    public Pacientes(int id_usuario, String nombre, String apellido, int dni, String fecha, String direccion, String celular, String correo, String contraseña, String rol) {
        super(id_usuario, nombre, apellido, dni, fecha, direccion, celular, correo, contraseña, rol);
    }


    @Override
    public void solicitarCita(int idMedico, String fecha, String hora) {
       
        System.out.println("Solicitando cita con el médico " + idMedico);
    }

    @Override
    public void cancelarCitaPaciente(int idCita) {
       
        System.out.println("Cancelando cita " + idCita);
    }

    @Override
    public void verHistorialPropio() {
     
        System.out.println("Consultando historial médico personal");
    }

    @Override
    public void actualizarDatosPersonales(String direccion, String telefono) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
