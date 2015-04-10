package ru.alexan.theGame;

import org.junit.Before;
import org.junit.Test;
import ru.alexan.theGame.personages.Goblin;
import ru.alexan.theGame.personages.Ogre;
import ru.alexan.theGame.personages.Sheep;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 */
public class TestArmsAbility {
    private Sheep sheep;
    private Goblin goblin;
    private Ogre ogre;

    @Before
    public void setup() {
        sheep = new Sheep();
        goblin = new Goblin();
        ogre = new Ogre();
    }

    @Test
    public void test_01() throws Exception {
        assertFalse("Sheep can't use arms", sheep.canBeArmed());
    }

    @Test
    public void test_02() throws Exception {
        assertTrue("Goblin can use arms", goblin.canBeArmed());
    }

    @Test
    public void test_03() throws Exception {
        assertTrue("Ogre can use arms", ogre.canBeArmed());
    }

}
