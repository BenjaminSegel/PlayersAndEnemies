public class Player {
    private Inventory inventory;
    private Armor equippedArmor;
    private Weapon equippedWeapon;
    private String name;
    private int level;
    private int gold;
    private int baseHealth;
    private int baseDefence;
    private int baseDamage;

    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
        this.level = 0;
        this.gold = 0;
        this.baseHealth = 100;
        this.baseDefence = 20;
        this.baseDamage = 30;
    }

}
