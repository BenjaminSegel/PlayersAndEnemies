public class Wand extends Weapon{

    public Wand(String name, int worth, int weight, int damage, String material) {
        super(name, worth, weight, damage, material);
    }

    @Override
    public int attack(){
      System.out.println("Player flicked their wand!");
      return damage;
    };
}
