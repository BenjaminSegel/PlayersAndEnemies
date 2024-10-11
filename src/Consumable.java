public abstract class Consumable extends Item implements Useable{

    protected int effect;
    private String playerStatToEffect;

    public Consumable(String name, int weight, int worth, int effect, int level, String playerStatToEffect){
        super(name, weight, worth, level);
        this.effect = effect;
        this.playerStatToEffect = playerStatToEffect;
    }

    public String getPlayerStatToEffect(){
        return playerStatToEffect;
    }

    public int getEffect(){
        return effect;
    }

    public int use(){
        return effect;
    }
}
