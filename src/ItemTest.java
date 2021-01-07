import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test

    void getWeight() {
        Item i=new Item("item1", 10);

        assertEquals(10,i.getWeight());

    }
}
