package ru.alexan.theGame;

import ru.alexan.theGame.personages.Personage;

/**
 * Едок
 */
public interface Eater {

    boolean eat(Personage personage) throws GameException;
}
