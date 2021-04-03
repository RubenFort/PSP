package codigo;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Principal {

    public static void main(String[] args) {

        ServerSocket escuchador;
        Socket conexion = null;
        PrintStream salida = null;

        //Creamos un "listener" en el puerto 6666
        try {
            escuchador = new ServerSocket(6666);
        } catch (IOException ex) {
            System.out.println("El puerto 6666 está siendo usado por otro servidor");
            return;
        }

        //Esperamos la conexión de un cliente
        try {
            conexion = escuchador.accept();
        } catch (IOException ex) {
            System.out.println("Error. Se ha cerrado el puerto");
        }

        //Obtenemos los puntos de E/S (en este caso sólo de salida)
        try {

            salida = new PrintStream(conexion.getOutputStream());
        } catch (IOException ex) {
            System.out.println("Error al obtener salida hacia el cliente");
        }

        //Enviamos el mensaje de bienvenida
        salida.println("Bienvenido al Servidor do Demo");
        salida.println("Bye, bye");
        salida.flush();

        //Cerramos los puntos de E/S (en este caso sólo de salida)
        salida.close();

        //Cerramos la conexión con el cliente
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
