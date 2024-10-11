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
    private int maxHealth;
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
        this.maxHealth = 100;
        this.baseDefence = 20;
        this.baseDamage = 30;
        this.xp = 0;
        this.maxXp = calcMaxXp();
        this.rng = new Random();
    }

    public int getGold(){
        return gold;
    }
    public String getName(){
        return name;
    }

    public void levelUp(int excessXp){
        level++;
        xp = excessXp;
        this.baseHealth += 20;
        this.maxHealth += 20;
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

    public void recieveGold(int gold){
        this.gold += gold;
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
            int totalDamage = baseDamage + equippedWeapon.attack() + randomExtraDmg;
            System.out.println("Player dealt " + enemy.takeDamage(totalDamage) + " damage");
        }else{
            int totalDamage = baseDamage + randomExtraDmg;
            System.out.println("Player dealt " + enemy.takeDamage(totalDamage) + " damage");

        }
    }

    public void addItemToInventory(Item item){
        inventory.addItem(item);
    }

    public Item viewSpecificPlayerItem(int index){
        return inventory.viewSpecificItem(index);
    }

    public void manageItem(Item item){
        if(item.getClass().getSuperclass().toString().equals("class Consumable")){
            drinkHpPotion((HealthPotion) item);
        }else{
        if(!inventory.itemEquipped(item)){
            equipItem(item);
        }else{
        unequipItem(item);
        }
        }
    }

    public void removeItemFromInventory(Item item){
        try{
        inventory.removeItem(item.getName());
        }catch(Exception e){
            System.out.println("Something went very wrong: " + e);
        }
    }
    public void openInventory(){
        inventory.openInventory();
    }

    public void unequipItem(Item item){
        inventory.removeEquippedItem(item);
        if(item.getClass().getSuperclass().toString().equals("class Weapon")){
            System.out.println(equippedWeapon.getName() + " was unequipped!");
            this.equippedWeapon = null;
        }else if(item.getClass().getSuperclass().toString().equals("class Armor")){
            System.out.println(equippedArmor.getName() + " was unequipped!");
            this.equippedArmor = null;
        }else{
            System.out.println("Something went wrong");
        }
    }

    public void equipItem(Item item){
        inventory.addEquippedItem(item);
        if(item.getClass().getSuperclass().toString().equals("class Weapon")){
           this.equippedWeapon = (Weapon) item;
           System.out.println(equippedWeapon.getName() + " was equipped!");
        }else if(item.getClass().getSuperclass().toString().equals("class Armor")){
            this.equippedArmor = (Armor) item;
            System.out.println(equippedArmor.getName() + " was equipped!");
        }else{
            System.out.println("Something went wrong");
        }
    }


    public void drinkHpPotion(HealthPotion potion){
        if(baseHealth < maxHealth){
            if(baseHealth + potion.use() > maxHealth){
                baseHealth = maxHealth;
                System.out.println("Health now at full hp!");
                potion.decrementAmount();

            }else{
                System.out.println("Used" + potion.getName() + ", recovered " + potion.getEffect() + potion.getPlayerStatToEffect());
                baseHealth += potion.use();
            }
        }else{
        System.out.println("Health already at full hp!");
        }
    }

    @Override
    public String toString(){
        return System.lineSeparator() + "| " + name + " |" + System.lineSeparator()
                + "HP: " + baseHealth + System.lineSeparator() +
                "XP: " + xp + "/" + maxXp + System.lineSeparator();
    }
}
