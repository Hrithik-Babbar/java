public class producer implements Runnable{
    SharedBuffer sharedBuffer;
    producer(SharedBuffer sharedBuffer){
        this.sharedBuffer = sharedBuffer;
    }
    public void run(){
        for(int i = 0; i<6; i++){
            sharedBuffer.produce(i);
        }
    }
}
