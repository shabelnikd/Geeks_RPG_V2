package kg.geeks.game.template;

import kg.geeks.game.logic.RPG_Game;

// Мой герой, его суть в том, что он превращается на один раунд в любого другого героя
// Описание:

// Способность: ShapeShifter может принимать облик любого другого героя в команде
// (при попытке превращения в себя ничего не происходит) на один раунд.
// При этом он копирует не только внешний вид,
// но и все характеристики выбранного героя: здоровье, урон, и даже суперспособность.

// При условии если ShapeShifter превращается в мертвого героя, то погибает и сам, иначе был бы дисбаланс
// Так что он сам виноват

public class ShapeShifter extends Hero {

    public ShapeShifter(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.SHIFTING);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        Hero chosenHero = heroes[RPG_Game.random.nextInt(heroes.length)];
        if (chosenHero.getAbility() == SuperAbility.SHIFTING) {
            System.out.println("--> Shifting has no effect");
        } else {

            this.setDamage(chosenHero.getDamage() - getBoost());
            this.setHealth(chosenHero.getHealth());

            System.out.println("---> ShapeShifter was shifted to " + chosenHero.getName());
            chosenHero.applySuperPower(boss, heroes);
            System.out.println("---> And apply his SuperPower ⬏");
        }
    }
}
