package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void setItemTitle() {

        Item testItem = new Item(null,"NewTitle", null, false);
        assertEquals("NewTitle", testItem.getItemTitle());
    }

    @Test
    void setItemDescription() {
        Item testItem = new Item(null,"NewTitle", "TestDescription", false);
        assertEquals("TestDescription", testItem.getItemDescription());
    }

    @Test
    void setComplete() {
        Item testItem = new Item(null,"NewTitle", "TestDescription", true);
        assertTrue(testItem.getComplete());
        }

}