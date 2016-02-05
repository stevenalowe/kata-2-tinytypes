/**
 * An exception for an invalid channel. The message specifies exactly what is wrong with the channel name.
 */
public class InvalidChannelException extends Exception {
    public InvalidChannelException(String message) {
        super(message);
    }
}
