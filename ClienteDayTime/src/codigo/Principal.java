package codigo;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public static void main(String[] args) {
              
        Socket conexion = null;
        Scanner entrada = null;
        String linea = null;
        
        //Creamos un Socket para conectarmos con el servicio local de DayTime
        try {
            //Establecemos la conexión
            conexion = new Socket("localhost", 13);
            System.out.println("El puerto local es: " + conexion.getLocalPort());
        } catch (IOException ex) {
            System.out.println("El servidor de DayTime no responde");
        }
        
        //Obtenemos un lector (Scanner) a traves de la conexion
        try {
            entrada = new Scanner (conexion.getInputStream());
        } catch (IOException ex) {
            System.out.println("Error al obtener un punto de entrada");
        }
        
        //Leemos lineas hasta agotar la conexion
        while(entrada.hasNextLine()){
            linea = entrada.nextLine();
        }
        System.out.println(linea);
            
        //Cerrar el Scanner
        entrada.close();
        
        //Cerrar la conexion con el servidor
        try {
            conexion.close();
        } catch (IOException ex) {
            System.out.println("La conexion ya está cerrada");
        }
    }
}
