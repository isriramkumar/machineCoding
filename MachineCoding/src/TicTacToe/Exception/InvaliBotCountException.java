package TicTacToe.Exception;

public class InvaliBotCountException extends Exception{
    public InvaliBotCountException() {
    }

    public InvaliBotCountException(String message) {
        super(message);
    }

    public InvaliBotCountException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvaliBotCountException(Throwable cause) {
        super(cause);
    }

    public InvaliBotCountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
