public class producer_consumer {
    public static void main(String[] args) {
        SharedBuffer sharedBuffer = new SharedBuffer(2);;

        // producer thread using class implementing Runnable interface
        Thread producerThread = new Thread(new producer(sharedBuffer));
        // consumer thread using lambda expression
        Thread consumerThread = new Thread(()->{
            for(int i=0; i<6; i++){
                sharedBuffer.consume();
            }
        });
        producerThread.start();
        consumerThread.start();
    }
}
