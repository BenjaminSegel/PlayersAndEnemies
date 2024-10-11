public class Sword extends Weapon{

    public Sword(String name, int worth, int weight, int damage, String material, int level, int maxLevel) {
        super(name, worth, weight, damage, material, level, maxLevel);
    }

    @Override
    public int attack(){
        System.out.println("Player swung their sword!");
        return damage;
    }


}
