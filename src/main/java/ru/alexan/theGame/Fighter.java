package ru.alexan.theGame;

import ru.alexan.theGame.personages.Personage;

/**
 * Может драться
 */
public interface Fighter {

    /**
     * возвращает победителя
     *
     * @param personage
     * @return
     */
    Personage fight(Personage personage) throws GameException;
}
