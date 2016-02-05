import java.util.List;

/**
 * InventoryItem - a dumb data object where every fields is a String
 */
public class InventoryItem {
    private String _channel;
    private String _market;
    private String _style;
    private String _sku;
    private String _description;

    public InventoryItem() {

    }

    public InventoryItem(String chnl, String mkt, String styl, String sk, String desc) {
        this();
        _channel = chnl;
        _market = mkt;
        _style = styl;
        _sku = sk;
        _description = desc;
    }

    public String getChannel() { return _channel; }
    public void setChannel(String value) { _channel = value; }
    public String getMarket() { return _market; }
    public void setMarket(String value) { _market = value; }
    public String getStyle() { return _style; }
    public void setStyle(String value) { _style = value; }
    public String getSku() { return _sku; }
    public void setSku(String value) { _sku = value; }
    public String getDescription() { return _description; }
    public void setDescription(String value) { _description = value; }
}
