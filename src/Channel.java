/**
 * a tinytype for a Channel, which has only a name
 */
final public class Channel {
    private final static int MINIMUM_CHANNEL_NAME_LENGTH = 7;

    private final String _name;

    public Channel(String name) throws InvalidChannelException {
        validate(name);
        _name = name;
    }

    private void validate(String name) throws InvalidChannelException {
        if (name == null) {
            throw new InvalidChannelException("Channel name was null");
        }
        if (name.length() < MINIMUM_CHANNEL_NAME_LENGTH) {
            throw new InvalidChannelException(
                    "Channel name must be at least " +
                            MINIMUM_CHANNEL_NAME_LENGTH + " characters, " + name +
                            " is only " + name.length() + " characters long");
        }
    }

    public String getName() { return _name; }

    @Override
    public int hashCode() {
        return (_name == null ? 0 : _name.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Channel)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Channel rhs = (Channel) obj;
        return rhs.getName().equals(this.getName());
    }
}
