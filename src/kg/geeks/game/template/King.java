package kg.geeks.game.template;

import kg.geeks.game.logic.RPG_Game;

public class King extends Hero {

    public King(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int chance = RPG_Game.random.nextInt(99);
        if (chance <= 10) {
            boss.setHealth(0);
            System.out.println("--> King called Saitama and he was killed the BOSS " + boss.getName());
        }
    }
}
