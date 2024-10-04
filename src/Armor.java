public abstract class Armor extends Item {
    private int defence;
    private String material;
    public Armor(String name, int weight, int worth, int defence, String material) {
        super(name, weight, worth);
        this.defence = defence;
        this.material = material;
    }

    public int getDefence() {
        return defence;
    }
}
