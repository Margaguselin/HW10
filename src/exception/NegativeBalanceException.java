package exception;

public class NegativeBalanceException extends RuntimeException{

    public NegativeBalanceException(String error) {
        super(error);
    }
}
