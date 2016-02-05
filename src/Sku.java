/**
 * a tinytype for a Sku, which has only a name
 */
final public class Sku {
    private final static int MINIMUM_SKU_LENGTH = 6;
    private final static int MAXIMUM_SKU_LENGTH = 9;

    private final String _name;

    public Sku(String name) throws InvalidSkuException {
        validate(name);
        _name = name;
    }

    private void validate(String name) throws InvalidSkuException {
        if (name == null) {
            throw new InvalidSkuException("Sku was null");
        }
        if (name.length() < MINIMUM_SKU_LENGTH) {
            throw new InvalidSkuException(
                    "Sku must be at least " +
                            MINIMUM_SKU_LENGTH + " characters, " + name +
                            " is only " + name.length() + " characters long");
        }
        if (name.length() > MAXIMUM_SKU_LENGTH) {
            throw new InvalidSkuException(
                    "Sku name may be at most " +
                            MAXIMUM_SKU_LENGTH + " characters, " + name +
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
        if (!(obj instanceof Sku)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Sku rhs = (Sku) obj;
        return rhs.getName().equals(this.getName());
    }
}
