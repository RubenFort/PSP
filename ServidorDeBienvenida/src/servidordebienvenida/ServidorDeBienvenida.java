package servidordebienvenida;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorDeBienvenida {

    public static void main(String[] args) {
        
        ServerSocket escuchador;
        Socket conexion = null;
        PrintStream salida = null;
        
        try {
            //Creamos un "listener" en el puerto 6666
            escuchador = new ServerSocket (6666);
        } catch (IOException ex) {
            System.out.println("El puerto 6666 está siendo usado por otro servidor");
            return;
        }
        
        //Esperamos la conexion de un cliente
        try {
            conexion = escuchador.accept();
        } catch (IOException ex) {
            System.out.println("Error. Se ha cerrado el puerto");
        }
        
        //Obtenemos los puntos de entrada/salida (en este caso solo de salida)
        try {
            salida = new PrintStream(conexion.getOutputStream());
        } catch (IOException ex) {
            System.out.println("Error. Al obtener salida hacia el cliente");
        }
        
        //Eviamos los puntos de bienvenida
        salida.println("Bienvenido al servidor do Demo");
        salida.println("Bye, bye");
        salida.flush();
        
        //Cerramos los puntos de E/S
        salida.close();
        
        //Cerramos la conexion con el cliente
        try {
            conexion.close();
        } catch (IOException ex) {
        }
         
        //Cerramos el servidor
        try {
            escuchador.close();
        } catch (IOException ex) {
        }
    }
    
}
