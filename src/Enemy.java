public class Enemy {
    private int health;
    private String name;
    private int damage;

    public Enemy(String name, int health, int damage){
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public void takeDamage(int damage){
        this.health -= damage;
    }

    public int attack(){
        return damage;
    }

    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }

}
