package exceptions;

public class LimitIsExceeded extends Exception {
    public LimitIsExceeded() {
    }
    public LimitIsExceeded(String message){
        super(message);
    }
}
