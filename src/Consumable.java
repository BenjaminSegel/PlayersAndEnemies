public abstract class Consumable extends Item implements Useable{

    protected int effect;

    public Consumable(String name, int weight, int worth, int effect, int level){
        super(name, weight, worth, level);
        this.effect = effect;
    }

    public int use(){
        return effect;
    }
}
