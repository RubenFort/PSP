package servidor;

import java.awt.Color;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import vista.Principal;

public class HiloServidor extends Thread {

    private final Principal frmPrincipal;
    ServerSocket escuchador;
    
    public HiloServidor(Principal principal) {
        this.frmPrincipal = principal;
    }

    public void finalizar(){
        try {
            escuchador.close();
        } catch (IOException ex) {
            //Sólo saltaría si ya estuviera cerrado ... y eso no es un problema
        }
    }

     
    @Override
    public void run() {

        
        Socket conexion;
        Scanner entrada;
        String mensaje;
        

        try {
            //Creamos un servidor escuchando peticiones de conexión en el puerto 5555
            escuchador = new ServerSocket(5555);

            do {
                //Esperamos un intento de conexión
                conexion = escuchador.accept();

                //Obtenemos los puntos de E/S (Aquí sólo entrada)
                entrada = new Scanner(conexion.getInputStream());

                //Esperamos por un mensaje de cambio de color
                mensaje = entrada.nextLine();

                //Atendemos la petición
                atiendePeticion(mensaje);

                //Cerramos los puntos de E/S (Aquí sólo entrada)
                entrada.close();

                //Cerramos la conexión con el cliente
                conexion.close();

            } while (true);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void atiendePeticion(String mensaje) {
        String[] trozos = mensaje.split("#");
        int rojo;
        int verde;
        int azul;
        Color color;

        //Miramos que sólo llegan 3 trozos
        if (trozos.length != 3) {
            return;
        }

        //Analizamos el primer trozo (la componente Rojo)
        try {
            rojo = Integer.parseInt(trozos[0]);
            //Miramos que esté en rango válido
            if (rojo < 0 || rojo > 255) {
                return;
            }
        } catch (NumberFormatException numberFormatException) {
            //No se puede obtener un entero
            return;
        }

        //Analizamos el segundo trozo (la componente Verde)
        try {
            verde = Integer.parseInt(trozos[1]);
            //Miramos que esté en rango válido
            if (verde < 0 || verde > 255) {
                return;
            }
        } catch (NumberFormatException numberFormatException) {
            //No se puede obtener un entero
            return;
        }

        //Analizamos el primer trozo (la componente Azul)
        try {
            azul = Integer.parseInt(trozos[2]);
            //Miramos que esté en rango válido
            if (azul < 0 || azul > 255) {
                return;
            }
        } catch (NumberFormatException numberFormatException) {
            //No se puede obtener un entero
            return;
        }

        color = new Color(rojo, verde, azul);
        frmPrincipal.cambiaColor(color);
        System.out.println("Rojo:" + rojo + "-" + "Verde:" + verde + "-" + "Azul:" + azul);
        System.out.println(color);
    }
}
