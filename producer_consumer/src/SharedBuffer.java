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
            notify();
        }
        catch(Exception e){
            System.out.println("exception");
        }
    }

    public synchronized void consume(){
        try{
            while(buffer.isEmpty()){
                System.out.println("buffer is empty");
                wait();
            }
            buffer.remove();
            notify();
        }
        catch(Exception e){
            System.out.println("exception");
        }
    }
}