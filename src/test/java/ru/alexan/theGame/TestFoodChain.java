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
public class TestFoodChain {
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
        assertFalse("Sheep can`t eat sheep", sheep.canEat(sheep));
    }

    @Test
    public void test_01_1() throws Exception {
        assertFalse("Sheep can`t eat sheep", sheep.canEat(new Sheep()));
    }

    @Test
    public void test_02() throws Exception {
        assertFalse("Sheep can`t eat goblin", sheep.canEat(goblin));
    }

    @Test
    public void test_03() throws Exception {
        assertFalse("Sheep can`t eat ogre", sheep.canEat(ogre));
    }

    @Test
    public void test_04() throws Exception {
        assertTrue("Goblin can eat sheep", goblin.canEat(sheep));
    }

    @Test
    public void test_05() throws Exception {
        assertFalse("Goblin can eat goblin", goblin.canEat(goblin));
    }

    @Test
    public void test_05_1() throws Exception {
        assertTrue("Goblin can eat goblin", goblin.canEat(new Goblin()));
    }

    @Test
    public void test_06() throws Exception {
        assertFalse("Goblin can`t eat ogre", goblin.canEat(ogre));
    }

    @Test
    public void test_07() throws Exception {
        assertTrue("Ogre can eat sheep", ogre.canEat(sheep));
    }

    @Test
    public void test_08() throws Exception {
        assertTrue("Ogre can eat goblin ", ogre.canEat(goblin));
    }

    @Test
    public void test_09() throws Exception {
        assertFalse("Ogre can`t eat ogre ", ogre.canEat(ogre));
    }

    @Test
    public void test_09_1() throws Exception {
        assertFalse("Ogre can`t eat ogre ", ogre.canEat(new Ogre()));
    }
}

