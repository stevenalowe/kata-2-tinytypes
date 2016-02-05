/**
 * InventoryManager - a facade to the database facade for inventory
 */
public class InventoryRepo {
    public InventoryItem LookUpItem(Channel channel, Market market, StyleCode styleCode, String description) throws Exception {
        if (description == null) {
            throw new Exception("Invalid description");
        }
        DatabaseManager dbmgr = new DatabaseManager("Inventory");
        if (!dbmgr.FindChannel(channel)) {
            throw new Exception("Invalid channel");
        }
        if (!dbmgr.FindMarket(market)) {
            throw new Exception("Invalid market");
        }
        if (!dbmgr.FindStyle(styleCode)) {
            throw new Exception("Invalid style code");
        }
        InventoryItem item = (InventoryItem)dbmgr.FindItem(styleCode, market, channel, description);
        if (item == null) {
            return null;
        }
        return item;
    }

    public InventoryItem LookUpItem(Sku sku) throws Exception {
        DatabaseManager dbmgr = new DatabaseManager("Inventory");
        InventoryItem item = (InventoryItem)dbmgr.FindItem(sku);
        if (item == null) {
            return null;
        }
        return item;
    }
}
