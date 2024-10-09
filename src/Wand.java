public class Wand extends Weapon{

    public Wand(String name, int worth, int weight, int damage, String material, int level) {
        super(name, worth, weight, damage, material, level);
    }



    @Override
    public int attack(){
      System.out.println("Player flicked their wand!");
      return damage;
    };
}
