package codigo;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public static void main(String[] args) {
              
        Socket conexion;
        InputStream entrada;//Lee un byte 
        int b; //(valor entre 0 y 255, aunque es un byte(-127,128))
        char c;
        //Creamos un Socket para conectarmos con el servicio local de DayTime
        try {
            //Establecemos la conexión con el servidor de CitaDelDia en esta máquina
            conexion = new Socket("localhost", 19);
            System.out.println("El puerto local es: " + conexion.getLocalPort());
            
            //Obtenemos el InputStream
            entrada = conexion.getInputStream();
            
            //Leemos de la entrada hasta "agotarla" (lee hasta alcanzar -1, que es el final)
            //Leemos caracter a caracter, 
            while((b=entrada.read()) != -1){
                c = (char)b;
                System.out.print(c);
            }
            
            //Cerrar el InputStream
            entrada.close();
            
            //Cerrar la conexión, liberamos recursos de mi máquina y de la remota
            conexion.close();
            
        } catch (IOException ex) {
            System.out.println("No es pocible establecer conexion con el servidor local de CitaDelDia");
        }
    }
    
}
