/**
 * DatabaseManager - adapter to talk to Inventory database
 */
public class DatabaseManager {
    private String _dbname;
    public DatabaseManager(String dbname) throws Exception {
        if (dbname == null || !dbname.toLowerCase().equals("inventory")) {
            throw new Exception("Invalid database name");
        }
        _dbname = dbname;
    }
    public boolean FindChannel(String channel) throws Exception {
        if (channel == null || channel.length() < 7) {
            throw new Exception("Invalid channel");
        }
        //pretend we talk to the database here, and we only have one channel, channel-5
        if (!channel.toLowerCase().equals("channel-5")) {
            throw new Exception("Failed to find channel " + channel);
        }
        return true;
    }
    public boolean FindMarket(String market) throws Exception {
        if (market == null || market.length() < 5) {
            throw new Exception("Invalid market");
        }
        //pretend we talk to the database here, and we only have one market, market-7
        if (!market.toLowerCase().equals("market-7")) {
            throw new Exception("Failed to find market " + market);
        }
        return true;
    }
    public boolean FindStyle(String styleCode) throws Exception {
        if (styleCode == null || styleCode.length() > 12) {
            throw new Exception("Invalid style");
        }
        //pretend we talk to the database here, and we only have one style code, style-9
        if (!styleCode.toLowerCase().equals("style-9")) {
            throw new Exception("Failed to find style " + styleCode);
        }
        return true;
    }
    public Object FindItem(String style, String market, String description, String channel) throws Exception {
        //pretend we talk to the database here, and get back a 5-7-9 item if successful
        if (!description.toLowerCase().startsWith("blue jeans")) {
            throw new Exception("Failed to find item like " + description);
        }
        return new InventoryItem("channel-5","market-7","style-9","br579-a",description);
    }

    public Object FindItem(String sku) throws Exception {
        //pretend we talk to the database here, and get back a 5-7-9 item if successful
        if (!sku.toLowerCase().equals("br579-a")) {
            throw new Exception("Failed to find item " + sku);
        }
        return new InventoryItem("channel-5","market-7","style-9",sku,"blue jeans");
    }
}
