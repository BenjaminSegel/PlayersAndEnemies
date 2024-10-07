import java.util.Random;

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
    private Random rng;

    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
        this.level = 1;
        this.gold = 0;
        this.baseHealth = 100;
        this.baseDefence = 20;
        this.baseDamage = 30;
        rng = new Random();
    }

    public int getLevel(){
        return level;
    }

    public int attack(){
        int randomExtraDmg = rng.nextInt(30);
        if(equippedWeapon !=null){
            int totalDamage = baseDamage += equippedWeapon.attack() + randomExtraDmg;
            System.out.println("Player dealt " + totalDamage + " damage");
            return totalDamage;
        }else{
            int totalDamage = baseDamage += randomExtraDmg;
            System.out.println("Player dealt " + totalDamage + " damage");
            return totalDamage;

        }
    }

    public void addItemToInventory(Item item){
        inventory.addItem(item);
    }
    public void removeItemFromInventory(Item item){
        try{
        inventory.removeItem(item.getName());
        }catch(Exception e){
            System.out.println("Something went very wrong");
        }
    }
    public void openInventory(){
        inventory.openInventory();
    }

    public void equipArmor(Armor armor){
        equippedArmor = armor;
    }

    public void equipWeapon(Weapon weapon){
        equippedWeapon = weapon;
    }

}
