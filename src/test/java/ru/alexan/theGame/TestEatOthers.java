package ru.alexan.theGame;

import org.junit.Before;
import org.junit.Test;
import ru.alexan.theGame.personages.Goblin;
import ru.alexan.theGame.personages.Ogre;
import ru.alexan.theGame.personages.Sheep;


/**
 *
 */
public class TestEatOthers {
    private Sheep sheep;
    private Goblin goblin;
    private Ogre ogre;

    @Before
    public void setup() {
        sheep = new Sheep();
        goblin = new Goblin();
        ogre = new Ogre();
    }

    @Test(expected = GameException.class)
    public void test_01() throws Exception {
        sheep.eat(sheep);
    }

    @Test(expected = GameException.class)
    public void test_01_1() throws Exception {
        sheep.eat(new Sheep());
    }

    @Test(expected = GameException.class)
    public void test_02() throws Exception {
        sheep.eat(goblin);
    }

    @Test(expected = GameException.class)
    public void test_03() throws Exception {
        sheep.eat(ogre);
    }

    @Test
    public void test_04() throws Exception {
        goblin.eat(sheep);
    }

    @Test(expected = GameException.class)
    public void test_05() throws Exception {
        goblin.eat(goblin);
    }

    @Test
    public void test_05_1() throws Exception {
        goblin.eat(new Goblin());
    }

    @Test(expected = GameException.class)
    public void test_06() throws Exception {
        goblin.eat(ogre);
    }

    @Test
    public void test_07() throws Exception {
        ogre.eat(sheep);
    }

    @Test()
    public void test_08() throws Exception {
        ogre.eat(goblin);
    }

    @Test(expected = GameException.class)
    public void test_09() throws Exception {
        ogre.eat(ogre);
    }

    @Test(expected = GameException.class)
    public void test_09_1() throws Exception {
        ogre.eat(new Ogre());
    }

}
