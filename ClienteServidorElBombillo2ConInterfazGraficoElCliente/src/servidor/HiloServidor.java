package servidor;

import java.awt.Color;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import vista.Principal;

public class HiloServidor extends Thread {
    
    private final Principal principal;
    private boolean enMarcha;
    private boolean condicion;

//    public HiloServidor(Principal principal) {
//        this.principal = principal;
//    }

    public HiloServidor(Principal principal, boolean condicion) {
        this.principal = principal;
        this.condicion = condicion;
    }

    public boolean isEnMarcha() {
        return enMarcha;
    }

    public void setEnMarcha(boolean enMarcha) {
        this.enMarcha = enMarcha;
    }

    public boolean isCondicion() {
        return condicion;
    }

    public void setCondicion(boolean condicion) {
        this.condicion = condicion;
    }

    @Override
    public void run() {
        boolean condicion = true;
        ServerSocket escuchador = null;
        Socket conexion = null;
        Scanner entrada;
        String mensaje;
        System.out.println("fdsdf");
        //BufferedReader entrada;
        try {
            //Creamos un servidor escuchando peticiones de conexión en el puerto 5555
            escuchador = new ServerSocket(5555);
            escuchador.setSoTimeout(50);

            do {
                //Esperamos un intento de conexión
                try {
                    conexion = escuchador.accept();
                } catch (IOException Ex) {
                    System.out.println(Ex.getMessage());
                }

                //Obtenemos los puntos de E/S (solo entrada)
                entrada = new Scanner(conexion.getInputStream());
                //entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream()));

                //Esperamos por un mensaje de cambio de color
                mensaje = entrada.nextLine();
                
                condicion = principal.getBoolean();
                System.out.println(condicion);
                
                //Atendemos la peticion
                atiendaPeticion(mensaje);

                //Cerramos los puntos de E/S(Aqui solo entrada)
                entrada.close();

                //Cerramos la conexion con el cliente
                conexion.close();

            } while (condicion);
            
            
        } catch (IOException Ex) {
            System.out.println(Ex.getMessage());
        }
        
        
        try {
            conexion.close();
            escuchador.close();
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    private void atiendaPeticion(String mensaje) {
        String[] trozos = mensaje.split("#");
        int rojo, verde, azul;
        Color color;

        //Mensaje que sólo llegan 3 trozos
        if (trozos.length != 3) {
            return;
        }

        //Analizamos el primer trozo (La componente Rojo)
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
        //Analizamos el segundo trozo (La componente Rojo)
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
        //Analizamos el tercer trozo (La componente Rojo)
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
        
        System.out.println("Rojo: " + rojo + "- Verde: " + verde + "- Azul: " + azul);
        System.out.println(color);
        
        principal.cambiaColor(color);
    }

}
