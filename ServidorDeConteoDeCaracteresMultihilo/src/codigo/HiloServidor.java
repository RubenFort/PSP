package codigo;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class HiloServidor extends Thread {

    Socket conexion;
    Scanner entrada;
    PrintStream salida;
    String lineaRecibida;
    int caracteresRecibidos;

    public HiloServidor(Socket conexion) {
        this.conexion = conexion;
    }

    @Override
    public void run() {
        System.out.println("Nuevo cliente conectado: "
                + conexion.getInetAddress().getHostAddress()
                + "/" + conexion.getPort() + "a las " + new Date());

        //Obtenemos los puntos de E/S
        try {
            entrada = new Scanner(conexion.getInputStream());
            salida = new PrintStream(conexion.getOutputStream());
        } catch (IOException ex) {
            System.out.println("Error al obtener salida hacia el cliente");
        }

        //Enviamos el mensaje de bienvenida e invitación
        salida.println("Bienvenido al Servidor de conteo de caracteres de Alberto");
        do {
            salida.println("Escribe una frase(o FIN para cerrar) y yo te digo cuantos caracteres tiene: ");
            salida.flush();

            //Recibimos la frase entrante
            lineaRecibida = entrada.nextLine();
            //Procesamos la petición que en este caso es contar los caracteres
            caracteresRecibidos = lineaRecibida.length();

            //Enviamos el mensaje con el resultado (conteo) y nos despedimos
            salida.println("Tu frase tiene " + caracteresRecibidos + " caracteres");
        } while (!lineaRecibida.endsWith("FIN"));
        salida.println("Gracias por usar el Servidor de Conteo de Caracteres de Alberto. Bye, bye.");

        //HAcemos log a consola del proceso
        System.out.println("Recibido: " + lineaRecibida + "   Caracteres: " + caracteresRecibidos);

        //Cerramos los puntos de E/S (en este caso sólo de salida)
        entrada.close();
        salida.close();

        //Cerramos la conexión con el cliente
        try {
            conexion.close();
        } catch (IOException ex) {
        }

        System.out.println("Cliente desconectado: "
                + conexion.getInetAddress().getHostAddress()
                + "/" + conexion.getPort() + "a las " + new Date());
    }

}
