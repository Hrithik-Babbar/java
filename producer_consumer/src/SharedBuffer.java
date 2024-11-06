import java.util.ArrayDeque;
import java.util.Queue;

public class SharedBuffer  {

    Queue<Integer> buffer;
    int size;

    SharedBuffer(int size){
        this.size = size;
        buffer = new ArrayDeque<Integer>();
    }

    public synchronized void produce(int num){
        try{
            while(buffer.size() == size){
                System.out.println("buffer is full");
                wait();
            }
            buffer.add(num);
            System.out.println("produced item");
            notify();
        }
        catch(Exception e){
            System.out.println("exception while producing");
        }
    }

    public synchronized void consume(){
        try{
            while(buffer.isEmpty()){
                System.out.println("buffer is empty");
                wait();
            }
            buffer.remove();
            System.out.println("consumed item");
            notify();
        }
        catch(Exception e){
            System.out.println("exception while consuming");
        }
    }
}