/**
 * InvalidStyleCodeException for invalid style codes; the message says what was wrong with the style code given
 */
public class InvalidStyleCodeException extends Exception {
    public InvalidStyleCodeException(String message) {
        super(message);
    }
}
