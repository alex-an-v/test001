package ru.alexan.theGame;

import org.junit.Test;
import ru.alexan.theGame.personages.*;
import ru.alexan.theGame.weapons.MagicSword;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 */
public class TestScenario {

    /**
     * 1) Гоблин съел овцу
     */
    @Test
    public void scenario_01() {
        try {
            assertTrue(new Goblin().eat(new Sheep()));
        } catch (GameException e) {
            fail(e.getMessage());
        }
    }

    /**
     * 2) Два гоблина подрались из-за овцы. Победитель съел овцу.
     */
    @Test
    public void scenario_02() {
        try {
            assertTrue(new Goblin().fight(new Goblin()).eat(new Sheep()));
        } catch (GameException e) {
            fail(e.getMessage());
        }
    }

    /**
     * 3) Огр попытался съесть группу гоблинов, но не смог.
     */
    @Test
    public void scenario_03() {
        try {
            ArrayList<Personage> singleOgreGroupMemers = new ArrayList<Personage>();
            singleOgreGroupMemers.add(new Ogre());
            Group singleOgreGroup = new Group(singleOgreGroupMemers);

            List<Goblin> goblinHordeMembers = new ArrayList<Goblin>();
            for (int i = 0; i < 10; i++) {
                goblinHordeMembers.add(new Goblin());
            }
            Group goblinHordeGroup = new Group(goblinHordeMembers);

            assertFalse(singleOgreGroup.eat(goblinHordeGroup));
        } catch (GameException e) {
            fail(e.getMessage());
        }
    }

    /**
     * 4) Группа огров успешно съели группу гоблинов.
     */
    @Test
    public void scenario_04() {
        try {
            ArrayList<Personage> ogreHordeGroupMemers = new ArrayList<Personage>();
            for (int i = 0; i < 10; i++) {
                ogreHordeGroupMemers.add(new Ogre());
            }
            Group ogreHordeGroup = new Group(ogreHordeGroupMemers);

            List<Goblin> goblinHordeMembers = new ArrayList<Goblin>();
            for (int i = 0; i < 10; i++) {
                goblinHordeMembers.add(new Goblin());
            }
            Group goblinHordeGroup = new Group(goblinHordeMembers);

            assertTrue(ogreHordeGroup.eat(goblinHordeGroup));
        } catch (GameException e) {
            fail(e.getMessage());
        }
    }

    /**
     * 5) Два огра попытались съесть гоблина с волшебным мечом, но не смогли.
     */
    @Test
    public void scenario_05() {
        try {
            ArrayList<Personage> twoOgreGroupMemers = new ArrayList<Personage>();
            for (int i = 0; i < 2; i++) {
                twoOgreGroupMemers.add(new Ogre());
            }
            Group twoOgreGroup = new Group(twoOgreGroupMemers);

            List<Goblin> mightyGoblinMembers = new ArrayList<Goblin>();
            Goblin mightyGoblin = new Goblin();
            mightyGoblin.addWeapon(new MagicSword());
            mightyGoblinMembers.add(mightyGoblin);
            Group mightyGoblinGroup = new Group(mightyGoblinMembers);

            assertFalse(twoOgreGroup.eat(mightyGoblinGroup));
        } catch (GameException e) {
            fail(e.getMessage());
        }
    }

    /**
     * 6) Стадо овец и группа гоблинов дерётся с двумя ограми и побеждает.
     */
    @Test
    public void scenario_06() {
        try {
            List<Personage> herdersAndSheepsMembers = new ArrayList<Personage>();
            for (int i = 0; i < 50; i++) {
                herdersAndSheepsMembers.add(new Sheep());
            }
            for (int i = 0; i < 10; i++) {
                herdersAndSheepsMembers.add(new Goblin());
            }
            Group herdersAndSheepsGroup = new Group(herdersAndSheepsMembers);

            ArrayList<Personage> twoOgreGroupMemers = new ArrayList<Personage>();
            for (int i = 0; i < 2; i++) {
                twoOgreGroupMemers.add(new Ogre());
            }
            Group twoOgreGroup = new Group(twoOgreGroupMemers);

            assertSame(herdersAndSheepsGroup,herdersAndSheepsGroup.fight(twoOgreGroup));
        } catch (GameException e) {
            fail(e.getMessage());
        }
    }

}
