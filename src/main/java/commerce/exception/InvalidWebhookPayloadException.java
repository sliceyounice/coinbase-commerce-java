package commerce.exception;

public class InvalidWebhookPayloadException extends CoinbaseException {

    public InvalidWebhookPayloadException(String message) {
        super(message);
    }
}
