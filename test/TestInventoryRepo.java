import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.omg.CORBA.DynAnyPackage.Invalid;

/**
 * Unit test InventoryRepo interface
 */
public class TestInventoryRepo {
    private static Channel validChannel;
    private final static String validMarket = "market-7";
    private final static String validStyle = "style-9";
    private final static String validSku = "br579-a";
    private final static String validDescription = "blue jeans";

    @BeforeClass
    public static void OneTimeSetup() {
        try {
            validChannel = new Channel("channel-5");
        }
        catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test(expected = NullPointerException.class)
    public void TestNullChannel() throws Exception {
        InventoryRepo im = new InventoryRepo();
        InventoryItem item = im.LookUpItem(null, validMarket, validStyle, validDescription);
    }
    @Test(expected = Exception.class)
    public void TestNullMarket() throws Exception {
        InventoryRepo im = new InventoryRepo();
        InventoryItem item = im.LookUpItem(validChannel, null, validStyle, validDescription);
    }
    @Test(expected = Exception.class)
    public void TestNullStyle() throws Exception {
        InventoryRepo im = new InventoryRepo();
        InventoryItem item = im.LookUpItem(validChannel, validMarket, null, validDescription);
    }
    @Test(expected = Exception.class)
    public void TestNullDescription() throws Exception {
        InventoryRepo im = new InventoryRepo();
        InventoryItem item = im.LookUpItem(validChannel, validMarket, validStyle, null);
    }

    @Test(expected = Exception.class)
    public void TestInvalidMarket() throws Exception {
        InventoryRepo im = new InventoryRepo();
        InventoryItem item = im.LookUpItem(validChannel, "mkt", validStyle, validDescription);
    }
    @Test(expected = Exception.class)
    public void TestInvalidStyle() throws Exception {
        InventoryRepo im = new InventoryRepo();
        InventoryItem item = im.LookUpItem(validChannel, validMarket, "styl", validDescription);
    }
    @Test(expected = Exception.class)
    public void TestInvalidDescription() throws Exception {
        InventoryRepo im = new InventoryRepo();
        InventoryItem item = im.LookUpItem(validChannel, validMarket, validStyle, "");
    }
    @Test
    public void TestFindFakeItemByDescription() throws Exception {
        InventoryRepo im = new InventoryRepo();
        InventoryItem item = im.LookUpItem(validChannel, validMarket, validStyle, validDescription);
        Assert.assertNotNull(item);
        Assert.assertEquals("blue jeans", item.getDescription());
    }
    @Test
    public void TestFindFakeItemBySku() throws Exception {
        InventoryRepo im = new InventoryRepo();
        InventoryItem item = im.LookUpItem(validSku);
        Assert.assertNotNull(item);
        Assert.assertEquals("blue jeans", item.getDescription());
    }

    @Test(expected = InvalidChannelException.class)
    public void TestNullChannelName() throws InvalidChannelException {
        Channel badChannel = new Channel(null);
    }
    @Test(expected = InvalidChannelException.class)
    public void TestInvalidChannel() throws InvalidChannelException {
        Channel badChannel = new Channel("ex");
    }
}
