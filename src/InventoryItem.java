import javax.swing.text.Style;
import java.util.List;

/**
 * InventoryItem - a dumb data object where every fields is a String
 */
public class InventoryItem {
    private Channel _channel;
    private Market _market;
    private StyleCode _style;
    private String _sku;
    private String _description;

    public InventoryItem() {

    }

    public InventoryItem(Channel chnl, Market mkt, StyleCode styl, String sk, String desc) {
        this();
        _channel = chnl;
        _market = mkt;
        _style = styl;
        _sku = sk;
        _description = desc;
    }

    public Channel getChannel() { return _channel; }
    public void setChannel(Channel value) { _channel = value; }
    public Market getMarket() { return _market; }
    public void setMarket(Market value) { _market = value; }
    public StyleCode getStyle() { return _style; }
    public void setStyle(StyleCode value) { _style = value; }
    public String getSku() { return _sku; }
    public void setSku(String value) { _sku = value; }
    public String getDescription() { return _description; }
    public void setDescription(String value) { _description = value; }
}
