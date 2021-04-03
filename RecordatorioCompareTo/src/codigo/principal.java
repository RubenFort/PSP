package codigo;

import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;

public class principal {

    public static void main(String[] args) {
        
        Persona p0 = new Persona("Luis", "12345678M", new Date(1968-1900, 5, 23));
        Persona p1 = new Persona("Ana", "87654321Q", new Date(1978-1900, 7, 18));
        Persona p2 = new Persona("Bartolo", "65465487R", new Date(1980-1900, 6, 12));
        Persona p3 = new Persona("Eva", "45645678U", new Date(1990-1900, 2, 2));
        
        //Podemos usar el CompareTo pq lo implementamos en la clase persona
        //Se compararan a traves del NIF
        System.out.println(p0.compareTo(p1));
        System.out.println(p1.compareTo(p0));
        
        //Podriamos usar una interfaz SortedSet<E>, pero usamos un TreeSet(más sencillo)
        //Ordena las elementos de una manera natural(en base a Comparable)
        TreeSet<Persona> persona = new TreeSet<>();
        persona.add(p0);
        persona.add(p1);
        persona.add(p2);
        persona.add(p3);
        
        //Obtenemos un iterador ascendente de personas
        //persona.iterator(); devuelve y crea una clase que implementa Iterator 
        Iterator<Persona> it = persona.iterator();
        while(it.hasNext()){
            Persona p = it.next();
            System.out.println(p);
        }
        
    }   
}
