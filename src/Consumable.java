public abstract class Consumable extends Item {

    protected int effect;

    public Consumable(String name, int weight, int worth, int effect){
        super(name, weight, worth);
        this.effect = effect;
    }

    public int drink(){
        return effect;
    }
}
