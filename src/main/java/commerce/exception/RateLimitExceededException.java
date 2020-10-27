package commerce.exception;

public class RateLimitExceededException extends CoinbaseException {
    public RateLimitExceededException(String message) {
        super(message);
    }
}
