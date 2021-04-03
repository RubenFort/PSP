package codigo;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public static void main(String[] args) {
        
        //Obtenemos InetAdderss a traves del Host
        try {
            InetAddress udc = InetAddress.getByName("www.udc.es");
            System.out.println(udc);
        } catch (UnknownHostException ex) {
            System.out.println("No existe una maquina con nommbre www.udc.es y");
        }
        
        System.out.println("--------------------------------------------------");
        
        try {
            //Obtenemos una lista de InetAddress a partir del nombre del Host
            InetAddress[] googles = InetAddress.getAllByName("www.pp.com");
            for (InetAddress inet : googles) {
                System.out.println(inet);
            }
        } catch (UnknownHostException ex) {
            System.out.println("No existe una maquina con nommbre www.google.es y");
        }
        
        System.out.println("--------------------------------------------------");
        
        //Obtenermos la IP de esta máquina
        try {
            InetAddress estaMAquina = InetAddress.getLocalHost();
            System.out.println(estaMAquina);
        } catch (UnknownHostException ex) {
            System.out.println("Esta máqiona no tiene dir IP configurada/no tiene tarjeta");
        }
        
        System.out.println("--------------------------------------------------");
        
        //Obtenermos la IP de esta máquina
        try {
            InetAddress estaMAquina = InetAddress.getLocalHost();
            System.out.println(estaMAquina);
        } catch (UnknownHostException ex) {
            System.out.println("Esta máqiona no tiene dir IP configurada/no tiene tarjeta");
        }

        System.out.println("--------------------------------------------------");

        //Obtenermos el loopback address de esta máquina
            InetAddress estaMAquina = InetAddress.getLoopbackAddress();
            System.out.println(estaMAquina);
        
        System.out.println("--------------------------------------------------");

        //Miramos el www.elmundo.es es alcanzable en 100ms
        try {
            InetAddress elmundo = InetAddress.getByName("www.elmundo.es");
            if (elmundo.isReachable(100)) {
                System.out.println("La máquina www.elmundo.es es alcanzable en tiempos <= que 100ms");
            } else {
                    System.out.println("La máquina www.elmundo.es NO es alcanzable en tiempos <= que 100ms");
            }
        } catch (UnknownHostException ex) {
            System.out.println("No existe una máquina con nombre www.elmundo.es");
        } catch (IOException ex) {
            
        }
    }
}
