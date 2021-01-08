package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void getWeight() {
        Item i=new Item("item number 1", 20);

        assertEquals(25,i.getWeight());

    }
}
