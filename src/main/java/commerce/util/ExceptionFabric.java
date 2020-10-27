package commerce.util;

import commerce.exception.*;
import commerce.model.CoinbaseError;

public class ExceptionFabric {

    private ExceptionFabric() {}

    public static void throwCoinbaseException(CoinbaseError coinbaseError) {
        switch (coinbaseError.getType()) {
            case "not_found":
                throw new ResourceNotFoundException(coinbaseError.getMessage());
            case "param_required":
                throw new ParamRequiredException(coinbaseError.getMessage());
            case "validation_error":
                throw new ValidationException(coinbaseError.getMessage());
            case "invalid_request":
                throw new InvalidRequestException(coinbaseError.getMessage());
            case "authentication_error":
                throw new AuthenticationException(coinbaseError.getMessage());
            case "rate_limit_exceeded":
                throw new RateLimitExceededException(coinbaseError.getMessage());
            case "internal_server_error":
                throw new InternalServerException(coinbaseError.getMessage());
            default:
                throw new CoinbaseException(coinbaseError.getType() + " " + coinbaseError.getMessage());
        }
    }
}
