
package testagenda;
import java.io.FileInputStream;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/** @author a14juanlbu*/

public class TestAgenda {

    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        
        int opMenu = 0, opBusca = 0;
        String nom, dir, codp, telf, n, t;
        Agenda MiAgenda = null;
        FileOutputStream fos = null;
        ObjectOutputStream salida = null;
        FileInputStream fis = null;
        ObjectInputStream entra = null;
        
        int maxCont = 0;
        System.out.println("**********--------------VAMOS A CREAR UNA AGENDA--------------***********");
        System.out.print("Indique el número máximo de contactos para la agenda: ");
        maxCont = entrada.nextInt();
        MiAgenda = new Agenda(maxCont); 
        
        fos = new FileOutputStream("Agenda.data", true);
            
        do{
            System.out.println("++++++++++++-----------BIENVENIDO A TU AGENDA-----------++++++++++++++"
                    + "\n1.- Añadir un contacto nuevo"
                    + "\n2.- Listar todos los contactos de la agenda"
                    + "\n3.- Buscar un contacto"
                    + "\n4.- Borrar un teléfono dado un nombre"
                    + "\n5.- Modificar un número de teléfono dado un nombre"
                    + "\n6.- Salir");
            System.out.print("Opción = ");            
            opMenu = entrada.nextInt();
            
            switch (opMenu) {
            
                case 1:
                    System.out.println("-----------------------AÑADIR CONTACTO-----------------------");
                    System.out.println();                    
                    System.out.print("Ingrese un nombre: ");
                    nom = entrada.next();
                    System.out.print("Ingrese una dirección: ");
                    dir = entrada.next();
                    System.out.print("Ingrese un código postal: ");
                    codp = entrada.next();
                    System.out.print("Ingrese un teléfono: ");
                    telf = entrada.next();
                    if(MiAgenda.buscarxNombre(nom) == null){
                        Contacto contacto =new Contacto(nom,dir,codp,telf);
                        try{
                            salida = new ObjectOutputStream(fos);
                            salida.writeObject(contacto); // Probar escribir como string tostring
                        } catch (FileNotFoundException e) {
                            System.out.println("1"+e.getMessage());
                        } catch (IOException e) {
                            System.out.println("2"+e.getMessage());
                        } finally {
                                try {
                                    if(fos!=null) fos.close();
                                    if(salida!=null) salida.close();
                                } catch (IOException e) {
                                    System.out.println("3"+e.getMessage());
                                }
                        }                                                    
                        MiAgenda.añadirContacto(contacto);
                    } else {
                        System.out.print("ERROR: El contactto ya existe en nuestra agenda"); 
                    }
                    break;
                case 2:
                   MiAgenda.listarContactos();                    
                    break;
                case 3:
                   System.out.println("-----------------------BUSCAR CONTACTO-----------------------"
                        + "\n"
                        + "\n1.- Por nombre"
                        + "\n2.- Por teléfono");
                        opBusca = entrada.nextInt();    
                    switch (opBusca) {                            
                        case 1:
                            System.out.print("Indique un nombre: ");
                            n = entrada.next();
                            MiAgenda.verContacto(MiAgenda.buscarxNombre(n));
                            break;
                        case 2:
                            System.out.print("Indique un teléfono: ");
                            t = entrada.next();
                            MiAgenda.verContacto(MiAgenda.buscarTelefono(t));     
                            break;
                        default:
                            break;
                    }
                    break;
                case 4:
                    System.out.println("-----------------------BORRAR TELÉFONO DADO UN NOMBRE-----------------------");                     
                    System.out.print("Indique un nombre: ");
                    n = entrada.next();
                    if(MiAgenda.borrarTelfxNom(n) != false){
                        System.out.println("ERROR: El Contacto no existe");
                    } else {
                        System.out.println("Se ha borrado el teléfono del contacto con nombre "+n);
                        MiAgenda.verContacto(MiAgenda.buscarxNombre(n));
                    }
                    break;
                case 5:
                    System.out.println("-----------------------MODIFICAR TELÉFONO DADO UN NOMBRE-----------------------");                     
                    System.out.print("Indique un nombre: ");
                    n = entrada.next();
                    if(MiAgenda.borrarTelfxNom(n) != false){
                        System.out.println("ERROR: El Contacto no existe");
                    } else {
                        System.out.println("Se ha borrado el teléfono del contacto con nombre "+n);
                        MiAgenda.verContacto(MiAgenda.buscarxNombre(n));
                    }     
                    break;
                case 6:
                    
                    break;
            }
        } while (opMenu > 0 && opMenu < 6); 
    }
}        
