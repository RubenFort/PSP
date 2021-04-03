package codigo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Principal {

    public static void main(String[] args) {

        ServerSocket escuchador;
        Socket conexion = null;

        //Creamos un "listener" en el puerto 10000
        try {
            escuchador = new ServerSocket(10000);
        } catch (IOException ex) {
            System.out.println("El puerto 10000 está siendo usado por otro servidor");
            return;
        }

        do {
            //Esperamos la conexión de un cliente
            try {
                conexion = escuchador.accept();
                //Vamos a instanciar un HiloServidor pasandole el Socket via constructor
                //Y lo arrancamos
                new HiloServidor(conexion).start();
                
            } catch (IOException ex) {
                System.out.println("Error. Se ha cerrado el puerto");
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
