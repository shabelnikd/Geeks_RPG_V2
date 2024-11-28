package kg.geeks.game.template;

public class Medic extends Hero {
    private final int healPoints;

    public Medic(String name, int health, int damage, int healPoints) {
        super(name, health, damage, SuperAbility.HEAL);
        this.healPoints = healPoints;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int total = 0;
        for (Hero hero : heroes) {
            if (hero != this && hero.getHealth() > 0) {
                hero.setHealth(hero.getHealth() + healPoints);
                total += healPoints;
            }
        }
        System.out.println("--> Medic healed " + total + " points");
    }
}
