import java.util.Random;

public abstract class Armor extends Item implements Upgradable {
    private int defence;
    private String material;
    private int upgradeCost;
    private Random rng;
    public Armor(String name, int weight, int worth, int defence, String material, int level, int maxLevel) {
        super(name, weight, worth, level, maxLevel);
        this.defence = defence;
        this.material = material;
        this.upgradeCost = calcUpgradeCost();
    }

    public int getDefence() {
        return defence;
    }

    public int calcDefence(int level, int defence) {
        rng = new Random();
        return defence + (rng.nextInt(10 * level));
    }

    public int calcUpgradeCost(){
        return level * defence;
    }

    public int calcDefenceUpgrade(){
        return calcUpgradeCost() / 10;
    }

    public void upgrade(int playerGold){
        if(level < getMaxLevel() && playerGold >= upgradeCost){
            level++;
            upgradeCost = calcUpgradeCost();
            defence += calcDefenceUpgrade();
            if(level == getMaxLevel()){
                System.out.println("Armor is now at max level!");
            } else{
                System.out.println("Armor upgraded! Armor level: " + level);
            }
        } else if (upgradeCost > playerGold){
            System.out.println("Insufficient gold!");
        }else{
            System.out.println("Armor is already max level!");
        }
    }

    @Override
    public String toString(){
        return super.toString() + "Defence: " + defence + System.lineSeparator() +
                "Material: " + material;
    }
}
