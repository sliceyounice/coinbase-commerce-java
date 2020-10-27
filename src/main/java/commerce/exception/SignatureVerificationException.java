package commerce.exception;

public class SignatureVerificationException extends CoinbaseException {

    public SignatureVerificationException(String message) {
        super(message);
    }
}
