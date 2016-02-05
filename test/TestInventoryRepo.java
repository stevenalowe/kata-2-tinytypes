import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.omg.CORBA.DynAnyPackage.Invalid;

import javax.swing.text.Style;
import java.io.*;

/**
 * Unit test InventoryRepo interface
 */
public class TestInventoryRepo {
    private static Channel validChannel;
    private static Market validMarket;
    private static StyleCode validStyle;
    private static Sku validSku;
    private final static String validDescription = "blue jeans";

    @BeforeClass
    public static void OneTimeSetup() {
        try {
            validChannel = new Channel("channel-5");
            validMarket = new Market("market-7");
            validStyle = new StyleCode("style-9");
            validSku =  new Sku("br579-a");
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
    @Test(expected = NullPointerException.class)
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

    @Test(expected = InvalidMarketException.class)
    public void TestNullMarketName() throws InvalidMarketException {
        Market badMarket = new Market(null);
    }
    @Test(expected = InvalidMarketException.class)
    public void TestInvalidMarket() throws InvalidMarketException {
        Market badMarket = new Market("ex");
    }

    @Test(expected = InvalidStyleCodeException.class)
    public void TestNullStyleCode() throws InvalidStyleCodeException {
        StyleCode badStyle = new StyleCode(null);
    }
    @Test(expected = InvalidStyleCodeException.class)
    public void TestInvalidStyleCode() throws InvalidStyleCodeException {
        StyleCode badStyle = new StyleCode("ex");
    }

    @Test(expected = InvalidSkuException.class)
    public void TestNullSku() throws InvalidSkuException {
        Sku badSku = new Sku(null);
    }
    @Test(expected = InvalidSkuException.class)
    public void TestInvalidSku() throws InvalidSkuException {
        Sku badSku = new Sku("ex");
    }
    @Test(expected = InvalidSkuException.class)
    public void TestInvalidSkuNonDigitViolation() throws InvalidSkuException {
        Sku badSku = new Sku("brX79-a");
    }

    @Test
    public void TestInventoryItemSerialization() throws Exception {
        InventoryRepo im = new InventoryRepo();
        InventoryItem writeItem = im.LookUpItem(validSku);
        Assert.assertEquals("blue jeans", writeItem.getDescription());

        try {
            FileOutputStream fileOut = new FileOutputStream("inventoryitem.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(writeItem);
            out.close();
            fileOut.close();
        }
        catch(IOException i) {
            Assert.fail("Unexpected IO exception serializing InventoryItem: " + i.toString());
        }

        InventoryItem readItem = null;
        try {
            FileInputStream fileIn = new FileInputStream("inventoryitem.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            readItem = (InventoryItem) in.readObject();
            in.close();
            fileIn.close();
        }
        catch(IOException i) {
            Assert.fail("Unexpected IO exception deserializing InventoryItem: " + i.toString());
        }
        catch(ClassNotFoundException c) {
            Assert.fail("InventoryItem class not found: " + c.toString());
        }

        Assert.assertEquals(writeItem.getChannel(), readItem.getChannel());
        Assert.assertEquals(writeItem.getMarket(), readItem.getMarket());
        Assert.assertEquals(writeItem.getSku(), readItem.getSku());
        Assert.assertEquals(writeItem.getStyle(), readItem.getStyle());
    }
}
