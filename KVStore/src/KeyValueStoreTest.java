import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class KeyValueStoreTest {

    private KeyValueStore kv;

    @BeforeEach
    public void setUp() {
        kv = new KeyValueStore();
    }

    @Test
    public void testSetGet() {
        kv.set("x", "100");
        assertEquals("100", kv.get("x"));
    }

    @Test
    public void testDelete() {
        kv.set("x", "100");
        kv.delete("x");
        assertEquals("NULL", kv.get("x"));
    }

    @Test
    public void testRollback() {
        kv.set("a", "1");
        kv.begin();
        kv.set("a", "2");
        assertEquals("2", kv.get("a"));
        kv.rollback();
        assertEquals("1", kv.get("a"));
    }

    @Test
    public void testCommit() {
        kv.begin();
        kv.set("a", "3");
        kv.set("b", "4");
        kv.commit();
        assertEquals("3", kv.get("a"));
        assertEquals("4", kv.get("b"));
    }

    @Test
    public void testRollbackDelete() {
        kv.set("a", "10");
        kv.begin();
        kv.delete("a");
        assertEquals("NULL", kv.get("a"));
        kv.rollback();
        assertEquals("10", kv.get("a"));
    }

    @Test
    public void testNoTransactionRollbackCommit() {
        kv.rollback(); // Should print "NO TRANSACTION"
        kv.commit();   // Should print "NO TRANSACTION"
    }
}
