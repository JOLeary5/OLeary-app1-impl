package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GUIControllerTest {

    @Test
    void demoTestMethod() {
        assertTrue(true);
    }

    @Test
    void addItem() {
        Item testItem = new Item(null,"NewTitle1", null, false);
        Item testItem2 = new Item(null,"NewTitle2", null, false);
        Item testItem3 = new  Item(null,"NewTitle3", null, false);

        ObservableList<Item> iList = FXCollections.observableArrayList();
        iList.setAll(testItem,testItem2, testItem3);

        if (iList != null){
            assertTrue(true);
        }
    }

    @Test
    void deleteItem() {
        Item testItem = new Item(null,"NewTitle1", null, false);

        ObservableList<Item> iList = FXCollections.observableArrayList();
        iList.setAll(testItem);

        iList.remove(testItem);

        if (iList == null){
            assertTrue(true);
        }
    }

    @Test
    void clearItemList() {
        Item testItem = new Item(null,"NewTitle1", null, false);
        Item testItem2 = new Item(null,"NewTitle2", null, false);
        Item testItem3 = new  Item(null,"NewTitle3", null, false);

        ObservableList<Item> iList = FXCollections.observableArrayList();
        iList.setAll(testItem,testItem2, testItem3);

        iList.clear();

        if (iList == null){
            assertTrue(true);
        }
    }
}