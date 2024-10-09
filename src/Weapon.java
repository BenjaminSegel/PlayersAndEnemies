import java.util.Random;

public abstract class Weapon extends Item{

    protected int damage;
    private String material;
    private Random rng;

    public Weapon(String name, int worth, int weight, int damage, String material, int level){
        super(name, worth, weight, level );
        this.damage = calcDamage(level, damage);
        this.material = material;
    }

    public int calcDamage(int level, int damage){
        rng = new Random();
        return damage + (rng.nextInt(10 * level));
    }

    public int attack(){
        System.out.println("Player attacked!");
        return damage;
    }


    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() + "Damage: " +
                damage + System.lineSeparator() + "Material: " + material;
    }
}
