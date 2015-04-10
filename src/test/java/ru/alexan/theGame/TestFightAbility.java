package ru.alexan.theGame;

import org.junit.Before;
import org.junit.Test;
import ru.alexan.theGame.personages.Goblin;
import ru.alexan.theGame.personages.Ogre;
import ru.alexan.theGame.personages.Sheep;

import static org.junit.Assert.assertTrue;

/**
 *
 */
public class TestFightAbility {
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
        assertTrue("Sheep can fight with sheep", sheep.canFight(sheep));
    }

    @Test
    public void test_02() throws Exception {
        assertTrue("Sheep can fight with goblin", sheep.canFight(goblin));
    }

    @Test
    public void test_03() throws Exception {
        assertTrue("Sheep can fight with ogre", sheep.canFight(ogre));
    }

    @Test
    public void test_04() throws Exception {
        assertTrue("Goblin can fight with sheep", sheep.canFight(sheep));
    }

    @Test
    public void test_05() throws Exception {
        assertTrue("Goblin can fight with goblin", sheep.canFight(goblin));
    }

    @Test
    public void test_06() throws Exception {
        assertTrue("Goblin can fight with ogre", sheep.canFight(ogre));
    }

    @Test
    public void test_07() throws Exception {
        assertTrue("Ogre can fight with sheep", sheep.canFight(sheep));
    }

    @Test
    public void test_08() throws Exception {
        assertTrue("Ogre can fight with goblin", sheep.canFight(goblin));
    }

    @Test
    public void test_09() throws Exception {
        assertTrue("Ogre can fight with ogre", sheep.canFight(ogre));
    }

}

