import javax.swing.text.Style;
import java.io.Serializable;
import java.util.List;

/**
 * InventoryItem - a dumb data object where every fields is a String
 */
public class InventoryItem implements Serializable {
    private static final long serialVersionUID = 1L;

    private Channel _channel;
    private Market _market;
    private StyleCode _style;
    private Sku _sku;
    private String _description;

    private InventoryItem() {

    }

    public InventoryItem(Channel chnl, Market mkt, StyleCode styl, Sku sk, String desc) {
        this();
        _channel = chnl;
        _market = mkt;
        _style = styl;
        _sku = sk;
        _description = desc;
    }

    public Channel getChannel() { return _channel; }
    public Market getMarket() { return _market; }
    public StyleCode getStyle() { return _style; }
    public Sku getSku() { return _sku; }
    public String getDescription() { return _description; }
}
