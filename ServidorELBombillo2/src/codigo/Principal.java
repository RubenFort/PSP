package codigo;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws IOException {
        ServerSocket escuchador;
        Socket conexion;
        Scanner entrada;
        String mensaje;

        //BufferedReader entrada;
        
        
        //Creamos un servidor escuchando peticiones de conexión en el puerto 5555
        escuchador = new ServerSocket(5555);
        
        do{
            //Esperamos un intento de conexión
            conexion = escuchador.accept();
            
            //Obtenemos los puntos de E/S (solo entrada)
            entrada = new Scanner (conexion.getInputStream());
            //entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            
            //Esperamos por un mensaje de cambio de color
            mensaje = entrada.nextLine();
            
            //Atendemos la peticion
            atiendaPeticion(mensaje);
            
            //Cerramos los puntos de E/S(Aqui solo entrada)
            entrada.close();
            
            //Cerramos la conexion con el cliente
            conexion.close();
            
            
        }while(true);
        
    }

    private static void atiendaPeticion(String mensaje) {
        String[] trozos = mensaje.split("#");
        int rojo, verde, azul;
        Color color;
        
        //Mensaje que sólo llegan 3 trozos
        if(trozos.length != 3) return;
        
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
    }
    
}
