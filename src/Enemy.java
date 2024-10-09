import java.util.Random;

public class Enemy {
    private int health;
    private String name;
    private int damage;
    private int level;
    private Random rng;
    private int xpDrop;

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
    public int calcXpDrop(int level){
        return 50 + (level * 2);
    }

    public int takeDamage(int damage){
        this.health -= damage;
        return damage;
    }

    public void attack(Player player){
        int randomExtraDamage = rng.nextInt(20);
        int totalDamage = damage + randomExtraDamage;
        System.out.println(name + " attacked! It dealt " + player.takeDamage(totalDamage) + " damage to " + player.getName() );
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
                "HP: " + health;

    }

}
