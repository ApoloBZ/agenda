
package testagenda;
/** @author a14juanlbu*/

public class Contacto {
    
    private String nombre, direccion;
    private String codpostal, telefono;

    //Constructor
    public Contacto(String nombre, String direccion, String codpostal, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.codpostal = codpostal;
        this.telefono = telefono;
    }
    
    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(String codpostal) {
        this.codpostal = codpostal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        String mensaje;
        
        mensaje = "\nNombre ........: " + nombre;;
        mensaje += "\nDirección .....: " + direccion;
        mensaje += "\nCódigo Postal .: " + codpostal;
        mensaje += "\nTeléfono ......: " + telefono;
        
        return mensaje;
    }   
}
