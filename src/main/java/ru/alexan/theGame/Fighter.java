package ru.alexan.theGame;

import ru.alexan.theGame.personages.Personage;

/**
 * ����� �������
 */
public interface Fighter {

    /**
     * ���������� ����������
     *
     * @param personage
     * @return
     */
    Personage fight(Personage personage) throws GameException;
}
