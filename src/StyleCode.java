/**
 * a tinytype for a StyleCode, which has only a name
 */
final public class StyleCode {
    private final static int MINIMUM_STYLE_CODE_LENGTH = 5;
    private final static int MAXIMUM_STYLE_CODE_LENGTH = 10;

    private final String _name;

    public StyleCode(String name) throws InvalidStyleCodeException {
        validate(name);
        _name = name;
    }

    private void validate(String name) throws InvalidStyleCodeException {
        if (name == null) {
            throw new InvalidStyleCodeException("StyleCode was null");
        }
        if (name.length() < MINIMUM_STYLE_CODE_LENGTH) {
            throw new InvalidStyleCodeException(
                    "StyleCode must be at least " +
                            MINIMUM_STYLE_CODE_LENGTH + " characters, " + name +
                            " is only " + name.length() + " characters long");
        }
        if (name.length() > MAXIMUM_STYLE_CODE_LENGTH) {
            throw new InvalidStyleCodeException(
                    "StyleCode name may be at most " +
                            MAXIMUM_STYLE_CODE_LENGTH + " characters, " + name +
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
        if (!(obj instanceof StyleCode)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        StyleCode rhs = (StyleCode) obj;
        return rhs.getName().equals(this.getName());
    }
}
