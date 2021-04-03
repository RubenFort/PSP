package codigo;

public class Hilo extends  Thread{
                
    private long veces;

    public long getVeces() {
        return veces;
    }

    @Override
    public void run() {
     do{
        veces ++; 
     }while (true);            
    }    
}
