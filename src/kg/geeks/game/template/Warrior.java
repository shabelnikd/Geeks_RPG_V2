package kg.geeks.game.template;

import kg.geeks.game.logic.RPG_Game;

public class Warrior extends Hero {
    public Warrior(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int exp = RPG_Game.random.nextInt(5) + 2;
        boss.setHealth(boss.getHealth() - this.getDamage() * exp);
        System.out.println("--> Warrior " + this.getName() + " attacked critically "
                + this.getDamage() * exp + " damage");
    }
}
