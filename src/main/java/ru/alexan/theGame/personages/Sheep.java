package ru.alexan.theGame.personages;

import ru.alexan.theGame.Edible;
import ru.alexan.theGame.Fighter;

/**
 * Œ‚ˆ‡
 */
public final class Sheep extends Personage implements Fighter, Edible {
    protected static final int MIN_STRENGTH = 3;
    protected static final int MAX_STRENGTH = 7;
    protected static final int MIN_HEALTH = 5;
    protected static final int MAX_HEALTH = 10;

    public Sheep() {
        super(MIN_STRENGTH, MAX_STRENGTH, MIN_HEALTH, MAX_HEALTH);
    }
}
