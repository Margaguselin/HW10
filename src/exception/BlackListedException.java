package exception;

public class BlackListedException extends RuntimeException{
    public BlackListedException(String error) {
        super(error);
    }
}
