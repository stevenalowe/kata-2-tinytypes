import java.io.Serializable;

/**
 * a tinytype for a Market, which has only a name
 */
final public class Market implements Serializable {
    private static final long serialVersionUID = 1L;

    private final static int MINIMUM_MARKET_LENGTH = 4;
    private final static int MAXIMUM_MARKET_LENGTH = 8;

    private final String _name;

    public Market(String name) throws InvalidMarketException {
        validate(name);
        _name = name;
    }

    private void validate(String name) throws InvalidMarketException {
        if (name == null) {
            throw new InvalidMarketException("Market was null");
        }
        if (name.length() < MINIMUM_MARKET_LENGTH) {
            throw new InvalidMarketException(
                    "Market must be at least " +
                            MINIMUM_MARKET_LENGTH + " characters, " + name +
                            " is only " + name.length() + " characters long");
        }
        if (name.length() > MAXIMUM_MARKET_LENGTH) {
            throw new InvalidMarketException(
                    "Market name may be at most " +
                            MAXIMUM_MARKET_LENGTH + " characters, " + name +
                            " was " + name.length() + " characters long");
        }
    }

    public String getName() { return _name; }

    @Override
    public int hashCode() {
        return (_name == null ? 0 : _name.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Market)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Market rhs = (Market) obj;
        return rhs.getName().equals(this.getName());
    }
}
