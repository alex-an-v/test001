package ru.alexan.theGame.personages;

import ru.alexan.theGame.*;
import ru.alexan.theGame.weapons.Weapon;

/**
 * Базовый класс персонажа
 */
public class Personage {
    private static final int MAX_FIGHT_TURNS = 1000;

    private final int strength;
    private int health;
    private OperateStatus operateStatus = OperateStatus.Alive;
    private FightStatus fightStatus = FightStatus.None;
    private Weapon weapon;

    Personage(int minStrength, int maxStrength, int minHealth, int maxHealth) {
        this.strength = generateRandom(minStrength, maxStrength);
        this.health = generateRandom(minHealth, maxHealth);
    }

    private static boolean isFighter(Personage who) {
        return who instanceof Fighter;
    }

    private int generateRandom(int minValue, int maxValue) {
        return (int) (minValue + Math.round(Math.random() * (maxValue - minValue)));
    }

    // basic checks
    public boolean canEat(Personage other) {
        return this instanceof Eater && other instanceof Edible && this != other;
    }

    public boolean canFight(Personage other) {
        return isFighter(this) && isFighter(other);
    }

    public boolean canBeArmed() {
        return this instanceof Armed;
    }

    // basic actions
    public void addWeapon(Weapon weapon) throws GameException {
        if (canBeArmed()) {
            this.weapon = weapon;
        } else {
            throw new GameException(this.getClass().getName() + " can`t be armed");
        }
    }

    public final boolean eat(Personage other) throws GameException {
        if (canEat(other)) {
            this.fightStatus = FightStatus.Aggressing;
            other.fightStatus = FightStatus.Defendind;
            Personage winner = this.fight(other);
            return this == winner;
        } else {
            throw new GameException(this.getClass().getName() + " can`t eat " + other.getClass().getName());
        }
    }

    public final Personage fight(Personage other) throws GameException {
        if (canFight(other)) {
            if (this.operateStatus != OperateStatus.Alive) {
                throw new GameException(this.getClass().getName() + "is not Alive -> can`t fight with " + other.getClass().getName());
            } else if (other.operateStatus != OperateStatus.Alive) {
                throw new GameException(other.getClass().getName() + "is not Alive -> can`t fight with " + this.getClass().getName());
            }
            for (int i = 0; i < MAX_FIGHT_TURNS; i++) {
                if (this.attack(other)) {
                    return this;
                }
                if (other.attack(this)) {
                    return other;
                }
            }
            throw new GameException("Too long fight: turns over of " + MAX_FIGHT_TURNS);
        } else {
            if (isFighter(this) && !isFighter(other)) {
                other.operateStatus = OperateStatus.Died;
                return this;
            } else if (!isFighter(this) && isFighter(other)) {
                this.operateStatus = OperateStatus.Died;
                return other;
            }
            throw new GameException(this.getClass().getName() + " can`t fight with " + other.getClass().getName());
        }
    }

    private boolean attack(Personage other) {
        other.health -= getAttackStrength();
        if (other.health <= 0) {
            other.operateStatus = OperateStatus.Died;
            return true;
        }
        return false;
    }

    private int getAttackStrength() {
        return canBeArmed() && weapon != null ? weapon.getStrength() : strength;
    }

    public OperateStatus getOperateStatus(){
        return operateStatus;
    }

    public enum OperateStatus {Alive, Died}

    public enum FightStatus {None, Aggressing, Defendind}

}
