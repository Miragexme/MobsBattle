/**
 * Created by Mirage on 11.04.2017.
 */
/** Класс Cheater, унаследован от класса Mob*/
public class CheaterMob extends Mob {

    /** Конструктор класса CheaterMob, точно такой же, как и у основного класса*/
    public CheaterMob(String name, int health, int damage, int critChance) {
        super(name, health, damage, critChance);
    };

    int resist = 5; // задаём читерский резист -5 урона

    //** Переопределяем родительский метод takeDamage, добавляя читерский резист*/
   @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage-resist);
    }
}