public class Sword extends Weapon{

    public Sword(String name, int worth, int weight, int damage, String material) {
        super(name, worth, weight, damage, material);
    }

    @Override
    public int attack(){
        System.out.println("Player swung their sword!");
        return damage;
    }


}
