package sample;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;



class RocketTest {
    @Test
    void launch() {
        Rocket rocket = new Rocket(100, 75, 89);
        assertTrue(rocket.launch());
    }

    @Test
    void land() {
        Rocket rocket = new Rocket(21, 635, 54);
        assertTrue(rocket.land());
    }
    @Test
    void carry(){
        U1 rocket = new U1();
        Item item1 = new Item("Item 1", 14);
        Item item2 = new Item("Item 2", 23);

        rocket.carry(item1);
        assertEquals(50, rocket.getRocketWeight());

        rocket.carry(item2);
        assertEquals(60, rocket.getRocketWeight());
    }
    @Test
    void canCarry() {
        U1 rocket = new U1();
        Item item1 = new Item("Item 1", 15);
        Item item2 = new Item("Item 2", 22);

        boolean answer1 = rocket.canCarry(item1);
        assertTrue(answer1);

        boolean answer2 = rocket.canCarry(item2);
        assertFalse(answer2);
    }
}