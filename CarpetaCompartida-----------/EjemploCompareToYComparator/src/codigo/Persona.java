package codigo;

import java.util.Date;
import java.util.Objects;

public class Persona implements Comparable<Persona>{

    private String nombre;
    private String NIF;
    private Date fechaNacimiento;

    public Persona(String nombre, String NIF, Date fechaNacimiento) {
        this.nombre = nombre;
        this.NIF = NIF;
        this.fechaNacimiento = fechaNacimiento;
    }

    
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.NIF);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.NIF, other.NIF)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Persona o) {
        
//       String miNIF = NIF;
//       String elOtroNIF = o.getNIF();
//       
//       int resultadoComparacion = miNIF.compareTo(elOtroNIF);
       
       return NIF.compareTo(o.getNIF());
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", NIF=" + NIF + ", fechaNacimiento=" + fechaNacimiento + '}';
    }
    
    
    

}
