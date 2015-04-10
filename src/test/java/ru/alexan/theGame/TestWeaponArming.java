package ru.alexan.theGame;

import org.junit.Before;
import org.junit.Test;
import ru.alexan.theGame.personages.Goblin;
import ru.alexan.theGame.personages.Ogre;
import ru.alexan.theGame.personages.Sheep;
import ru.alexan.theGame.weapons.Sword;
import ru.alexan.theGame.weapons.Weapon;


/**
 *
 */
public class TestWeaponArming {
    private Weapon weapon;

    @Before
    public void setup() {
        weapon = new Sword();
    }

    @Test(expected = GameException.class)
    public void test_01() throws Exception {
        new Sheep().addWeapon(weapon);
    }

    @Test
    public void test_02() throws Exception {
        new Goblin().addWeapon(weapon);
    }

    @Test
    public void test_03() throws Exception {
        new Ogre().addWeapon(weapon);
    }
}
