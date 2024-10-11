public class HealthPotion extends Consumable{
    private int amount;
    public HealthPotion(int amount) {
        super("Health Potion", 1, 20, 30, 2, "Health");
        this.amount = amount;
    }

    public void decrementAmount(){
        amount--;
    }

    @Override
    public int use(){
        if(amount > 0){
        decrementAmount();
        return effect;
        }
        System.out.println("No Health Potions left!");
        return 0;
    }
    @Override
    public String toString(){
        return super.toString() + System.lineSeparator() + "Uses left: " + amount;
    }
}
