/**
 * Created by Mirage on 09.04.2017.
 */

/**Наш класс Моб*/
public class Mob {
    final String name;
    int health;
    int damage;
    int critChanse;

    /**Конструктор класса Моб*/
    public Mob(String name, int health, int damage, int critChance){
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.critChanse = critChance;
    };

    /**Метод takeDamage - получение урона*/
    public void takeDamage(int damage){
        health = health - damage;
    }

    /**Метод IsAlive - определяет, жив ли Моб*/
    public boolean isAlive (){
        if (health > 0) {
            return true;
        } else {
            return false;
        }
    }
}
