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
        Scanner entrada = null;
        PrintStream salida = null;
        String lineaRecibida;
        int resultado;
        
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
            } catch (IOException ex) {
                System.out.println("Error. Se ha cerrado un puerto");
            }

            //Obtenemos los puntos de E/S
            try {
                entrada = new Scanner(conexion.getInputStream());
                salida = new PrintStream(conexion.getOutputStream());
            } catch (IOException ex) {
                System.out.println("Error al obtener salida hacia el cliente");
            }

            //·Enviamos el mensaje de bienvenida e invitación
try {
                salida.println("Bienvenido a Calculín, tu Servidor de cálculo");
                salida.println("Escribe tu cálculo, operaciones aceptadas: +, -, *, /");
                salida.println("Ejemplo: 23 + 14");
                salida.print("Cálculo?: ");
                salida.flush();

                //Recibimos la frase entrante
                lineaRecibida = entrada.nextLine();
                //Procesamos la petición que en este caso es parsear los datos recibidos,
                //realizar la operacíón

                //En este caso, ssta no sería la manera más eficiente de hacer un Split
                //pero uso este formato para tener un ejemplo de este uso
                String[] lineaRecibidaParseada = lineaRecibida.split(" ");
                
                if (lineaRecibidaParseada.length == 3){
                    int operando1 = Integer.valueOf(lineaRecibidaParseada[0]);
                    int operando2 = Integer.valueOf(lineaRecibidaParseada[2]);
                    String operador = lineaRecibidaParseada[1];
                    
                    ////Enviamos el mensaje con el resultado o un mensaje de "peticion incorrecta" 
                    if ((operador.equals("+") || operador.equals("-") || operador.equals("*") || operador.equals("/"))) {
                        resultado = calculoResultado(operando1, operando2, operador);
                        salida.println("Resultado: " + resultado);
                    } else {
                        salida.println("Peticion incorrecta");
                    }
                } else {
                    salida.println("Peticion incorrecta");
                }
                
                //Nos despedimos
                salida.println("Gracias por usar Calculín. Bye, bye");

                //Cerramos los puntos de E/S
                entrada.close();
                salida.close();

                //Cerramos la conexion con el cliente
                try {
                    conexion.close();
                } catch (IOException ex) {
                }
            } catch (NumberFormatException numberFormatException) {
                salida.println("Peticion incorrecta");
                salida.println("Gracias por usar Calculín. Bye, bye");
                entrada.close();
                salida.close();
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

    private static int calculoResultado(int operando1, int operando2, String operador) {
        int resultadoOperacion = 0;
        
        switch (operador){
            case "+":
                resultadoOperacion = operando1 + operando2;
                break;
            case "-":
                resultadoOperacion = operando1 - operando2;
                break;
            case "*":
                resultadoOperacion = operando1 * operando2;
                break;
            case "/":
                resultadoOperacion = operando1 / operando2;
                break;    
        }
        return resultadoOperacion;
    }
    
}
