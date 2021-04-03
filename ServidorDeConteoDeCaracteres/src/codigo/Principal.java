package codigo;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        ServerSocket escuchador;
        Socket conexion = null;
        Scanner entrada = null;
        PrintStream salida = null;
        String lineaRecibida;
        int caracteresRecibidos;

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
                System.out.println("Esperando la conexión de un cliente");
                conexion = escuchador.accept();
            } catch (IOException ex) {
                System.out.println("Error. Se ha cerrado el puerto");
            }

            System.out.println("Nuevo cliente conectado: "
                    + conexion.getInetAddress().getHostAddress()
                    + "/" + conexion.getPort() + " a las " + new Date());

            //Obtenemos los puntos de E/S
            try {
                entrada = new Scanner(conexion.getInputStream());
                salida = new PrintStream(conexion.getOutputStream());
            } catch (IOException ex) {
                System.out.println("Error al obtener salida hacia el cliente");
            }

            //Enviamos el mensaje de bienvenida e invitación
            salida.println("Bienvenido al Servidor de conteo de caracteres de Alberto");
            salida.println("Escribe una frase y yo te digo cuantos caracteres tiene: ");
            salida.flush();

            //Recibimos la frase entrante
            lineaRecibida = entrada.nextLine();
            //Procesamos la petición que en este caso es contar los caracteres
            caracteresRecibidos = lineaRecibida.length();
            
            //Enviamos el mensaje con el resultado (conteo) y nos despedimos
            salida.println("Tu frase tiene " + caracteresRecibidos + " caracteres");
            salida.println("Gracias por usar el Servidor de Conteo de Caracteres de Alberto. Bye, bye.");
            
            //HAcemos log a consola del proceso
            System.out.println("Recibido: " + lineaRecibida + "   Caracteres: " + caracteresRecibidos);
            
            //Cerramos los puntos de E/S
            entrada.close();
            salida.close();

            //Cerramos la conexión con el cliente
            try {
                conexion.close();
            } catch (IOException ex) {
            }

            System.out.println("Cliente desconectado a las " + new Date());
            System.out.println("------------------------------------------------");
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
