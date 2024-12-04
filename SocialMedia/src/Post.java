import java.util.Date;

public class Post {
    private final Double id;
    private String message;
    private final Date timestamp;

    public Post(String message){
        this.id = Math.random();
        this.message = message;
        this.timestamp = new Date();
    }

    public Double getId(){
        return id;
    }
    public String getMessage(){
        return message;
    }
}
