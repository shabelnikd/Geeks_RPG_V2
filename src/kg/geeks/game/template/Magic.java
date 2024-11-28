package kg.geeks.game.template;

import kg.geeks.game.logic.RPG_Game;

public class Magic extends Hero {
    private final int boostPoints;

    public Magic(String name, int health, int damage, int boost) {
        super(name, health, damage, SuperAbility.BOOST);
        this.boostPoints = boost;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {

        if (RPG_Game.getRoundNumber() < 5 && boss.getDefence() != SuperAbility.BOOST) {
            for (Hero hero : heroes) {
                hero.setBoost(boostPoints);
            }
            System.out.println("--> Magic boosted all");
        } else {
            for (Hero hero : heroes) {
                hero.setBoost(0);
            }
        }

    }
}
