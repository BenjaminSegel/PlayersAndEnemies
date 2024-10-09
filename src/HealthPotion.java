public class HealthPotion extends Consumable{

    public HealthPotion(int worth, int weight) {

        super("Health Potion", worth, weight, 30, 2);
    }

    @Override
    public int use(){
        System.out.println("Player drank a " + getName() + ", +" + effect + " health");
        return effect;
    }
}
