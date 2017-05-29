
package testagenda;

import java.util.*;

/** @author a14juanlbu*/

public class Agenda {

    private int maxAgenda, cont = 0;
    private Contacto [] agenda;
    

    //Constructor
    public Agenda(int maxAgenda) {
        this.maxAgenda = maxAgenda;
        this.agenda = new Contacto[maxAgenda];
    }
    
    //Getters and Setters
   
   /* public int getMaxAgenda() {
        return maxAgenda;
    }*/

    public void setMaxAgenda(int maxAgenda) {
        this.maxAgenda = maxAgenda;
    }

    public Contacto[] getAgenda() {
        return agenda;
    }

    public void setAgenda(Contacto[] agenda) {
        this.agenda = agenda;
    }    
   
    //Metodos
    //Añadir un contacto nuevo
    public void añadirContacto(Contacto c) throws Exception{       
        
        try{
            if(cont<maxAgenda){
                agenda[cont] = c;
                cont++;            
            }
        } catch (Exception e){    
            System.out.print("No se puede añadir el contacto (AGENDA LLENA)");
        }
    }
    //Listar todos los contactos de la agenda
    public void verContacto(Contacto c){
        System.out.println(c);
    }
    
    public void listarContactos(){        
        for(int i=0; i<agenda.length; i++){
            if(agenda[i] != null){
                verContacto(agenda[i]);
            }            
        }
    }
    //Buscar un contacto por nombre
    public Contacto buscarxNombre(String nom){
        
        for(int i=0; i<agenda.length; i++){
            if (agenda[i] != null){            
                if(nom.equals(agenda[i].getNombre())){
                    return agenda[i];
                }
            }
        }    
        return null;
    }
    //Buscar por telefono
    public Contacto buscarTelefono(String telefono){
        
            for(int i=0; i<agenda.length; i++){
                if (agenda[i] != null){
                    if(telefono.equals(agenda[i].getTelefono())){
                        return agenda[i];
                    }
                }    
            }
            
        return null;
    }
    //Borrar un teléfono dado un nombre
    public boolean borrarTelfxNom(String nombre){
       boolean r;
       if(buscarxNombre(nombre)== null){ //Si devuelve false, el contacto no existe
            r = false;
       } else {
            buscarxNombre(nombre).setTelefono(null);
            r = true;
       }
       return r;
    }
    //Modificar un número de teléfono dado un nombre
    public boolean modificarTelfxNom(String nombre, String telefono){
       boolean r;
       if(buscarxNombre(nombre)== null){
            r = false;
       } else {
            buscarxNombre(nombre).setTelefono(telefono);
            r = true;
       }
       return r;
    }    
}
