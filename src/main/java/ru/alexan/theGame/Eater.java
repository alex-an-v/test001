package ru.alexan.theGame;

import ru.alexan.theGame.personages.Personage;

/**
 * ����
 */
public interface Eater {

    boolean eat(Personage personage) throws GameException;
}
