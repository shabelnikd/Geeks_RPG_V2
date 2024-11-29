package kg.geeks.game.template;

public class Witcher extends Hero {
    public Witcher(String name, int health) {
        super(name, health, 0, SuperAbility.REVIVAL);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() <= 0) {
                hero.setHealth(this.getHealth());
                this.setHealth(0);
                System.out.println("--> Witcher saved " + hero.getName() + " and gave his life (health: " + hero.getHealth() + ")");
            }
        }
    }
}
