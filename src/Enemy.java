import java.util.Random;

public class Enemy {
    private int health;
    private String name;
    private int damage;
    private int level;
    private Random rng;

    public Enemy(String name, int level) {
        this.name = name;
        this.level = level;
        this.health = calcHealth(level);
        this.damage = calcDamage(level);
        rng = new Random();
    }

    public int calcHealth(int level){
        return 80 + (level * 5);
    }
    public int calcDamage(int level){
        return 20 + (level * 2);
    }
    public void takeDamage(int damage){
        this.health -= damage;
    }

    public int attack(){
        int randomExtraDamage = rng.nextInt(20);
        return damage += randomExtraDamage ;
    }

    public String getName(){
        return name;
    }

    public int getLevel(){
        return level;
    }

    public int getHealth(){
        return health;
    }

    @Override
    public String toString(){
        return "lvl " + level + " " + name + System.lineSeparator() +
                "health: " + health;

    }

}
