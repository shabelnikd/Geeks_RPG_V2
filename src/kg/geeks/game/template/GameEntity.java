package kg.geeks.game.template;

public abstract class GameEntity {
    private final String name;
    private int health;
    private int damage;
    private int boost;

    public void setBoost(int boost) {
        this.boost = boost;
    }

    public int getBoost() {
        return boost;
    }

    public GameEntity(String name, int health, int damage) {
        this.name = name;
        setHealth(health);
        setDamage(damage);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    public int getDamage() {
        return damage + boost;
    }

    public void setDamage(int damage) {
        this.damage = Math.max(damage, 0);
    }

    @Override
    public String toString() {
        return this.name + " | health: " + this.health + " | damage: " + this.damage + (boost > 0 ? " with " + boost + " boosted" : "");
    }
}
