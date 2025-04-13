package TicTacToe.Exception;

public class invalidNumberOfPlayersException extends Exception{
    public invalidNumberOfPlayersException() {
    }

    public invalidNumberOfPlayersException(String message) {
        super(message);
    }

    public invalidNumberOfPlayersException(String message, Throwable cause) {
        super(message, cause);
    }

    public invalidNumberOfPlayersException(Throwable cause) {
        super(cause);
    }

    public invalidNumberOfPlayersException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
