package ru.alexan.theGame.personages;

import ru.alexan.theGame.Armed;
import ru.alexan.theGame.Eater;
import ru.alexan.theGame.Fighter;

/**
 * Îãð
 */
public class Ogre extends Personage implements Fighter, Eater, Armed {
    protected static final int MIN_STRENGTH = 50;
    protected static final int MAX_STRENGTH = 80;
    protected static final int MIN_HEALTH = 200;
    protected static final int MAX_HEALTH = 250;

    public Ogre() {
        super(MIN_STRENGTH, MAX_STRENGTH, MIN_HEALTH, MAX_HEALTH);
    }
}
