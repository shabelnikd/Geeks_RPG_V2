package kg.geeks.game.template;

import kg.geeks.game.logic.RPG_Game;

import java.util.Arrays;

public class Hacker extends Hero {
    private final int hackPointsPercent;

    public Hacker(String name, int health, int damage, int hackPointsPercent) {
        super(name, health, damage, SuperAbility.HACK);
        this.hackPointsPercent = hackPointsPercent;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {

        int randomHero = RPG_Game.random.nextInt(heroes.length);
        int hacked = boss.getHealth() / 100 - hackPointsPercent;

        boss.setHealth(boss.getHealth() - hacked);
        heroes[randomHero].setHealth(heroes[randomHero].getHealth() + hacked);
        System.out.println("--> Hacker hacked " + hacked + " points and return this to " + heroes[randomHero].getName());

    }
}
