package ru.alexan.theGame;

import ru.alexan.theGame.weapons.Weapon;

/**
 * Может пользоваться оружием
 */
public interface Armed {

    void addWeapon(Weapon weapon) throws GameException;
}
