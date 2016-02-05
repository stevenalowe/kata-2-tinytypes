/**
 * InvalidMarketException - message says what's wrong with market name given
 */
public class InvalidMarketException extends Exception {
    public InvalidMarketException(String message) {
        super(message);
    }
}
