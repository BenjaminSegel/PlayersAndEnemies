public abstract class Weapon extends Item {

    protected int damage;
    private String material;

    public Weapon(String name, int worth, int weight, int damage, String material){
        super(name, worth, weight );
        this.damage = damage;
        this.material = material;
    }

    public int attack(){
        System.out.println("Player attacked!");
        return damage;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() + "Damage: " +
                damage + System.lineSeparator() + "Material: " + material;
    }
}
