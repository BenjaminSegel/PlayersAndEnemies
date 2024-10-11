import java.util.Random;

public abstract class Weapon extends Item implements Upgradable{

    protected int damage;
    private String material;
    private Random rng;
    private int upgradeCost;

    public Weapon(String name, int worth, int weight, int damage, String material, int level, int maxLevel){
        super(name, worth, weight, level, maxLevel );
        this.damage = calcDamage(level, damage);
        this.material = material;
        this.upgradeCost = calcUpgradeCost();
    }

    public int calcDamage(int level, int damage){
        rng = new Random();
        return damage + (rng.nextInt(10 * level));
    }

    public int attack(){
        System.out.println("Player attacked!");
        return damage;
    }

    public int calcUpgradeCost(){
        return level * damage;
    }

    public int calcDamageUpgrade(){
        return calcUpgradeCost() / 10;
    }

    public void upgrade(int playerGold){
        if(level < getMaxLevel() && playerGold >= upgradeCost){
            level++;
            upgradeCost = calcUpgradeCost();
            damage += calcDamageUpgrade();
            if(level == getMaxLevel()){
                System.out.println("Weapon is now at max level!");
            } else{
                System.out.println("Weapon upgraded! Weapon level: " + level);
            }
        } else if (upgradeCost > playerGold){
            System.out.println("Insufficient gold!");
        }else{
            System.out.println("Weapon is already max level!");
        }
    }


    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() + "Damage: " +
                damage + System.lineSeparator() + "Material: " + material + System.lineSeparator() +
                "Upgrade cost: " + upgradeCost + System.lineSeparator();
    }
}
