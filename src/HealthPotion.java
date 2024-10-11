public class HealthPotion extends Consumable{
    private int amount;
    public HealthPotion(int amount) {
        super("Health Potion", 1, 20, 30, 2);
        this.amount = amount;
    }

    @Override
    public int use(){
        if(amount > 0){
        System.out.println("Player drank a " + getName() + ", +" + effect + " health");
        return effect;
        }
        System.out.println("No Health Potions left!");
        return 0;
    }
}
