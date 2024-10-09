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
    private int xp;
    private int maxXp;
    private Random rng;

    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
        this.level = 1;
        this.gold = 0;
        this.baseHealth = 100;
        this.baseDefence = 20;
        this.baseDamage = 30;
        this.xp = 0;
        this.maxXp = calcMaxXp();
        this.rng = new Random();
    }

    public String getName(){
        return name;
    }

    public void levelUp(int excessXp){
        level++;
        xp = excessXp;
        this.baseHealth += 20;
        this.baseDefence += 5;
        this.baseDamage += 10;
        System.out.println(name + " leveled up! Current level: " + level);
        System.out.println("Current stats: " + System.lineSeparator() +
                "HP: " + baseHealth + System.lineSeparator()
                + "Defence: " + baseDefence + System.lineSeparator() +
                "Damage: " + baseDamage + System.lineSeparator());
    }

    public void recieveXp(int xp){
        this.xp += xp;
        System.out.println(name + " recieved XP: " + xp);
        if(this.xp >= maxXp){
            levelUp(this.xp - maxXp);
        }
    }

    public int takeDamage(int damage){
        if(equippedArmor !=null){
            int totalDamageTaken = damage - (this.baseDefence + equippedArmor.getDefence());
            this.baseHealth -= totalDamageTaken;
            return totalDamageTaken;
        }
        int totalDamageTaken = damage - this.baseDefence;
        this.baseHealth -= totalDamageTaken;
        return totalDamageTaken;
    }

    public int getLevel(){
        return level;
    }

    public int calcMaxXp(){
        return 100 * level;
    }

    public void attack(Enemy enemy){
        int randomExtraDmg = rng.nextInt(30);
        if(equippedWeapon !=null){
            int totalDamage = baseDamage += equippedWeapon.attack() + randomExtraDmg;
            System.out.println("Player dealt " + enemy.takeDamage(totalDamage) + " damage");
        }else{
            int totalDamage = baseDamage += randomExtraDmg;
            System.out.println("Player dealt " + enemy.takeDamage(totalDamage) + " damage");

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

    public void drinkHpPotion(HealthPotion potion){
        baseHealth += potion.use();
    }

    public void equipWeapon(Weapon weapon){
        equippedWeapon = weapon;
    }

    @Override
    public String toString(){
        return System.lineSeparator() + "| " + name + " |" + System.lineSeparator()
                + "HP: " + baseHealth + System.lineSeparator() +
                "XP: " + xp + "/" + maxXp + System.lineSeparator();
    }
}
