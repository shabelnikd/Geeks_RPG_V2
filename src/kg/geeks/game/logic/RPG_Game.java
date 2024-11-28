package kg.geeks.game.logic;

import kg.geeks.game.template.*;

import java.util.Arrays;
import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();
    private static int roundNumber = 0;

    public static int getRoundNumber() {
        return roundNumber;
    }

    public static void startGame() {
        Boss boss = new Boss("Darkness Lord", 2000, 50);

        Magic magic = new Magic("Gandalf", 280, 10, 5);
        Warrior warrior1 = new Warrior("Lambert", 290, 10);
        Warrior warrior2 = new Warrior("Diamond", 280, 15);
        Berserk berserk = new Berserk("Trevor", 240, 10);
        Medic doc = new Medic("Mr. Doc", 250, 5, 15);
        Medic assistant = new Medic("Connor", 300, 5, 5);
        Hacker hacker = new Hacker("Mr. Robot", 220, 5, 3);
        King king = new King("King", 250, 0);
        ShapeShifter shifter = new ShapeShifter("Shang Tsung", 200, 5);

        Hero[] heroes = {magic, warrior1, doc, warrior2, berserk, assistant, hacker, shifter};
        printStatistics(boss, heroes);

        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0
                    && boss.getDefence() != hero.getAbility()) {
                hero.attack(boss);
                hero.applySuperPower(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " -----------------");
        System.out.println(boss);
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }
}
