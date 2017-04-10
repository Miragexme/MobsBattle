/**
 * Created by Mirage on 09.04.2017.
 */

import java.util.Random;

/**Основной класс игры*/
public class GameLoop {
    /**Метод Main - точка входа в программу, здесь мы создаём мобов и запускаем бой между ними*/
    public static void main(String args[]) {
        Mob mobJack = new Mob("JackUarabey", 100, 10, 25);
        Mob mobBlack = new Mob("BlackBoroda", 120, 9, 22);
        Mob mobCraken = new CheaterMob("Craken", 100, 10, 1);
        fight(mobJack, mobBlack); // - Закомментируйте, если будет драка с Кракеном
        //fight(mobJack, mobCraken); // - Раскомментируйте, если хотите увидеть бой Джека с Кракеном!
    }

    /**Метод fight - описывает бой между двумя мобами за определённое кол-во раундов*/
    static void fight(Mob mob1, Mob mob2) {
        System.out.println("Let's Start the fight, Yaarrrrr!!!! (\\/)(O_0)(\\/)\n");
        int Round = 12;
        for (int i=1; i<=Round; i++){
            if (mob1.isAlive()&&mob2.isAlive()){
                hit(mob1, mob2);
                hit(mob2, mob1);
            }
           else {
                if (mob1.isAlive()){
                    System.out.println(mob1.name + " победил!");
                    break;
                }
                else {
                    if (mob2.isAlive()){
                        System.out.println(mob2.name + " победил!");
                        break;
                    }
                    else {
                        System.out.println(mob1.name + " и " + mob2.name + " оба погибли! \n     WASTED \n (\\/)(O_0)(\\/)\n");
                        break;
                    }
                }
            }
            System.out.println("\n");
        }
    }
    /** Метод hit - описывает удар одного моба по другому*/
    public static void hit(Mob mob1, Mob mob2){
        if (isCrit(mob1)){
            System.out.println(mob1.name + " наносит крииитический ydaaarrrr!");
            mob2.takeDamage(2*mob1.damage);
            System.out.println(mob2.name + " has " + mob2.health + " health" + " (-" + 2*mob1.damage + ")");
        }
        else {
            mob2.takeDamage(mob1.damage);
            System.out.println(mob2.name + " has " + mob2.health + " health" + " (-" + mob1.damage + ")");
        }
    }

    /** Метод isCrit - проверяет, нанёс ли моб критический удар*/
    public static boolean isCrit (Mob mob){
        //задаём случайное число от 0 до 100, если оно оказалось в диапазоне от 0 до critChance то происходит критический удар
        Random r = new Random();
        int Chanse = r.nextInt(101);
        if (Chanse <= mob.critChanse) {
            return true;
        } else {
            return false;
        }
    }
}
