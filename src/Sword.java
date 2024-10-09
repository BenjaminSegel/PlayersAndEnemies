public class Sword extends Weapon{

    public Sword(String name, int worth, int weight, int damage, String material, int level) {
        super(name, worth, weight, damage, material, level);
    }

    @Override
    public int attack(){
        System.out.println("Player swung their sword!");
        return damage;
    }


}
