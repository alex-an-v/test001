package ru.alexan.theGame.personages;

import ru.alexan.theGame.Armed;
import ru.alexan.theGame.Eater;
import ru.alexan.theGame.Edible;
import ru.alexan.theGame.Fighter;

/**
 * Гоблин
 */
public class Goblin extends Personage implements Fighter, Eater, Edible, Armed {
    protected static final int MIN_STRENGTH = 15;
    protected static final int MAX_STRENGTH = 20;
    protected static final int MIN_HEALTH = 130;
    protected static final int MAX_HEALTH = 150;

    public Goblin() {
        super(MIN_STRENGTH, MAX_STRENGTH, MIN_HEALTH, MAX_HEALTH);
    }
}
