package codigo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

public class Principal {
    private static Vector<Hilo> hilos;
    private static int ocupacion;
    private static Data operaciones;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        hilos = new Vector<Hilo>();
        operaciones = new Data();
        String linea;
        boolean salir = false;
        int seleccion = 0;
        
        do {
            System.out.println("");
            System.out.println("1. Crear hilo");
            System.out.println("2. Detener hilo");
            System.out.println("3. Finalizar hilo");
            System.out.println("4. Info hilo");
            System.out.println("5. Info hilos");
            System.out.println("6. Salir");

            try {
                System.out.print("Selecciona operación: ");
                linea = teclado.nextLine();
                seleccion = Integer.parseInt(linea);
            } catch (NumberFormatException numberFormatException) {
                System.out.println("El caracter tecleado no es un número");
            }
        
            switch (seleccion){
                case 1:
                    crearHilo();
                    break;
                case 2:
                    detenerHilo();
                    break;
                case 3:
                    finalizarHilo();
                    break;
                case 4:
                    informacionHilo();
                    break;
                case 5:
                    informacionTodosLosHilos();
                    break;
                case 6:
                    salir = true;
                    break;
                default :
                    System.out.println("Seleccion incorrecta");
                    break;
                  
            }
        } while (!salir);  
    }
    
    //Creo un hilo, le pongo nombre y lo guardo en un vector.
    //Si ya existe un hilo con el nombre que le doy al nuevo, no creo el hilo e 
    //imprimo un mensaje por pantalla
    private static void crearHilo() {
        Scanner teclado = new Scanner(System.in);
        String linea;
        boolean nombreYaUsado;
        
        System.out.print("Nombre: ");
        linea = teclado.nextLine();
        nombreYaUsado = operaciones.hiloExiste(linea);
        if (nombreYaUsado == true){
            System.out.println("Ya existe un hilo con ese nombre");   
        } else {
            Hilo h = new Hilo(ocupacion, linea, new Date());
            operaciones.addHilo(h);
            h.start();
            System.out.println("Hilo creado");
        }
    }
    
    //Busco coincidencia con el nombre que se teclea, si hay coincidencia suspendo
    //el hilo y cambio el Estado. Si no las hay imprimo un mensaje.
    //Si no hay hilos en Vector imprimo un mensaje por pantalla
    private static void detenerHilo() {
        Scanner teclado = new Scanner(System.in);
        String linea;
        
        if (operaciones.todosLosHilos().length == 0) {
            System.out.println("No hay hilos");
        } else {
            System.out.print("Que hilo quieres detener:: ");
            linea = teclado.nextLine();
            Hilo h = operaciones.buscarHilo(linea);
            if(h != null) {
                h.suspend();
                h.setEstado(Estado.DETENIDO);
                System.out.println("Hilo detenido");
            } else {
                System.out.println("El hilo buscado no existe");
            }
        }
    }
    
    //Busco coincidencia con el nombre que se teclea, si hay coincidencia finalizo
    //el hilo y cambio el Estado. Si no las hay imprimo un mensaje.
    //Si no hay hilos en Vector imprimo un mensaje por pantalla
    private static void finalizarHilo() {
        Scanner teclado = new Scanner(System.in);
        String linea;
        
        if (operaciones.todosLosHilos().length == 0) {
            System.out.println("No hay hilos");
        } else {
            System.out.print("Que hilo quieres finalizar:: ");
            linea = teclado.nextLine();
            Hilo h = operaciones.buscarHilo(linea);
            if(h != null) {
                h.stop();
                h.setEstado(Estado.FINALIZANDO);
                System.out.println("Hilo finalizado");
            } else {
                System.out.println("El hilo buscado no existe");
            }
        }
    }
    
    //Busco coincidencia con el nombre que se teclea, si hay coincidencia devuelvo
    //el hilo e imprimo sus atributos, usando SimpleDateFormat para la fecha.
    //Si no hay coincidencias imprimo un mensaje.
    //Si no hay hilos en Vector imprimo un mensaje por pantalla
    private static void informacionHilo() {
        Scanner teclado = new Scanner(System.in);
        String linea;
        Date ahora = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        
        if (operaciones.todosLosHilos().length == 0) {
            System.out.println("No hay hilos");
        } else {
            System.out.print("Que hilo quieres buscar:: ");
            linea = teclado.nextLine();
            Hilo h = operaciones.buscarHilo(linea);
            if(h != null) {
                System.out.println(h.getNombre());
                System.out.println(h.getFechaYHora());
                //Usando getTime() obtengo la fecha en milisegundos
                long dateTmp = h.getFechaYHora().getTime();
                long dateAhora = ahora.getTime();
                System.out.println(String.valueOf("Edad en segundos: " + (dateAhora - dateTmp )/1000));
                System.out.println("Estado: " + h.getEstado().toString());
            } else {
                System.out.println("El hilo buscado no existe");
            }
        }
    }
    
    //Obtengo el Vector en forma de array e imprimo nombre y estado de todos los hilos
    //Si no hay hilos en Vector imprimo un mensaje por pantalla
    private static void informacionTodosLosHilos() {
        if (operaciones.todosLosHilos().length == 0) {
            System.out.println("No hay hilos");
        } else {
            for (Hilo h : operaciones.todosLosHilos()) {
                System.out.println(h.getNombre() + " " + h.getEstado());
            }
        }
    }
}
