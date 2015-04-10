package ru.alexan.theGame.personages;

import ru.alexan.theGame.GameException;

import java.util.ArrayList;
import java.util.List;

/**
 * группа персонажей
 */
public class Group {
    List<Personage> members = new ArrayList<Personage>();

    public Group(List<? extends Personage> members) {
        this.members.addAll( members );
    }

    private Personage getAliveMember(){
        for (Personage member : members) {
            if( member.getOperateStatus() == Personage.OperateStatus.Alive ){
                return member;
            }
        }
        return null;
    }

    public boolean eat(Group other) throws GameException {
        return this == fight(other);
    }

    public Group fight(Group other) throws GameException {
        Personage left, right;
        while( (left = this.getAliveMember()) != null && (right = other.getAliveMember()) != null ){
            left.fight(right);
        }
        return left != null? this: other;
    }
}
