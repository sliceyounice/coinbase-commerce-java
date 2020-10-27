package commerce.exception;

public class InvalidRequestException extends CoinbaseException {
    public InvalidRequestException(String message) {
        super(message);
    }
}
