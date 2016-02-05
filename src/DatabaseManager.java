/**
 * DatabaseManager - (fake) adapter to talk to Inventory database
 */
public class DatabaseManager {
    private String _dbname;
    public DatabaseManager(String dbname) throws Exception {
        if (dbname == null || !dbname.toLowerCase().equals("inventory")) {
            throw new Exception("Invalid database name");
        }
        _dbname = dbname;
    }
    public boolean FindChannel(Channel channel) throws Exception {
        //pretend we talk to the database here, and we only have one channel, channel-5
        if (!channel.getName().toLowerCase().equals("channel-5")) {
            throw new Exception("Failed to find channel " + channel);
        }
        return true;
    }
    public boolean FindMarket(Market market) throws Exception {
        //pretend we talk to the database here, and we only have one market, market-7
        if (!market.getName().toLowerCase().equals("market-7")) {
            throw new Exception("Failed to find market " + market);
        }
        return true;
    }
    public boolean FindStyle(StyleCode styleCode) throws Exception {
        //pretend we talk to the database here, and we only have one style code, style-9
        if (!styleCode.getName().toLowerCase().equals("style-9")) {
            throw new Exception("Failed to find style " + styleCode);
        }
        return true;
    }
    public Object FindItem(StyleCode style, Market market, Channel channel, String description) throws Exception {
        //pretend we talk to the database here, and get back a 5-7-9 item if successful
        if (!description.toLowerCase().startsWith("blue jeans")) {
            throw new Exception("Failed to find item like " + description);
        }
        return new InventoryItem(channel,market,new StyleCode("style-9"),"br579-a",description);
    }
    public Object FindItem(String sku) throws Exception {
        //pretend we talk to the database here, and get back a 5-7-9 item if successful
        if (!sku.toLowerCase().equals("br579-a")) {
            throw new Exception("Failed to find item " + sku);
        }
        return new InventoryItem(new Channel("channel-5"),new Market("market-7"),new StyleCode("style-9"),sku,"blue jeans");
    }
}
