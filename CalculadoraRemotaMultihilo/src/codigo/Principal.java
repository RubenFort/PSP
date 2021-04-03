package codigo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public static void main(String[] args) {
        ServerSocket escuchador = null;
        Socket conexion = null;

        try {
            //Creamos un "listener" en el puerto 31415
            escuchador = new ServerSocket(31415);
        } catch (IOException ex) {
            System.out.println("El puerto 31415 está siendo usado por otro servidor");
        }

        do {
            //Esperamos la conexión de un cliente
            try {
                conexion = escuchador.accept();
                new HiloServidor(conexion).start();;
            } catch (IOException ex) {
                System.out.println("Error. Se ha cerrado un puerto");
            }

        } while (true);
        
        //Cerramos el servidor
        //Este bloque de código es inalcanzable debido al bucle do-while(true)
        /*
        try {
            escuchador.close();
        } catch (IOException ex) {
        }
         */
    }
}
