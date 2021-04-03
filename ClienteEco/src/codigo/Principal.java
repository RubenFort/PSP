package codigo;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public static void main(String[] args) {
        
        Socket conexion;
        Scanner teclado, entrada = null;
        String lineaSaliente, lineaEntrante;
        PrintStream salida = null;
        
        //Establecemos la conexion con el servidor
        try {
            conexion = new Socket("localhost", 7);
            entrada = new Scanner(conexion.getInputStream());
            salida = new PrintStream(conexion.getOutputStream());
        } catch (IOException ex) {
            System.out.println("El servidor local de Eco NO responde");
        }
        
        //Construimos un Scanner para leer desde el teclado
        teclado = new Scanner(System.in);
        
        //Leemos eternamente lineas desde el teclado, las enviamos al servidor 
        //y esperamos el retorno
        while(true){
            //Leemos linea del teclado
            lineaSaliente = teclado.nextLine();
            
            //La enviamos al servidor
            salida.println(lineaSaliente);
            salida.flush();//Forzamos el vaciado del buffer de salida
            
            //Leemos una linea del servidor
            lineaEntrante = entrada.nextLine();
            
            //Mostramos la linea recibida
            System.out.println(lineaEntrante);
            
        }
        
        
        //Devido al bucle eterno anterior estas sentencias son inalcanzableshola
//        //Cerramos las entradas y salidas de red.
//        entrada.close();
//        salida.close();
//        
//        //cerramos la conexion
//        try {
//            conexion.close();
//        } catch (IOException ex) {
//            
//        }
    }  
}
