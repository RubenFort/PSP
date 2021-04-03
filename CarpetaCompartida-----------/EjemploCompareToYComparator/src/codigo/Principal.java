package codigo;

import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;

public class Principal {

    public static void main(String[] args) {

        //Creamos un conjunto ordenado basado en el orden natural de Persona (que es NIF)
        System.out.println("Personas ordenadas con compareTo por NIF");
        Persona p0 = new Persona("Luis", "32111222W", new Date(1968 - 1900, 5, 23));
        Persona p1 = new Persona("Ana", "32555666R", new Date(1978 - 1900, 7, 15));
        Persona p2 = new Persona("Bartolo", "32444222S", new Date(1980 - 1900, 6, 12));
        Persona p3 = new Persona("Eva", "32111111H", new Date(1990 - 1900, 2, 2));

        TreeSet<Persona> personas = new TreeSet<>();
        personas.add(p0);
        personas.add(p1);
        personas.add(p2);
        personas.add(p3);

        //Obtenemos un iterador ascendente de personas
        Iterator<Persona> it = personas.iterator();
        while (it.hasNext()) {
            Persona p = it.next();
            System.out.println(p);
        }
        System.out.println("");
        System.out.println("Personas ordenadas con un Comparator por Date");
        //Creamos un conjunto ordenado basado en el orden del 
        //comparador ComparadorPersonasPorFechaNacimiento basado en Date
        ComparadorPersonasPorFechaNacimiento c = new ComparadorPersonasPorFechaNacimiento();
        TreeSet<Persona> otras = new TreeSet<>(c);
        otras.add(p0);
        otras.add(p1);
        otras.add(p2);
        otras.add(p3);
        //Obtenemos un iterador ascendente de personas
        Iterator<Persona> it2 = otras.iterator();
        while (it2.hasNext()) {
            Persona p = it2.next();
            System.out.println(p);
        }

    }

}
