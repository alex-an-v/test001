package ru.alexan.theGame;

import ru.alexan.theGame.weapons.Weapon;

/**
 * ����� ������������ �������
 */
public interface Armed {

    void addWeapon(Weapon weapon) throws GameException;
}
