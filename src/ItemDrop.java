import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemDrop {
    private List<Item> lowLevelItemList;
    private List<Item> MediumLevelItemList;
    private List<Item> HighLevelItemList;
    private Random rng;

    public ItemDrop() {
        lowLevelItemList = new ArrayList<Item>();
        MediumLevelItemList = new ArrayList<Item>();
        HighLevelItemList = new ArrayList<Item>();
        rng = new Random();
    }

    public void generateWeapons(){
        String[] lowLevelWandNames = {"Mighty Stick", "Magical Branch" ,"Enchanted Rod"};
        String[] lowLevelSwordNames = {"Sharp Dagger" , "Rusty Sword" , "Small Axe"};
        int maxLevel = rng.nextInt(3, 5);
        for(int level = 1; level < 5; level++){
            for(String name : lowLevelWandNames){
               lowLevelItemList.add(new Wand(name,calcWorth(level, 100), rng.nextInt(1,3), 20, "Wood", level, maxLevel));
            }
            for(String name : lowLevelSwordNames){
                lowLevelItemList.add(new Sword(name,calcWorth(level, 100), rng.nextInt(3,5), 20, "Metal", level, maxLevel));
            }
        }

    }

    public void generateArmor(){
        String[] lowLevelHeavyArmorNames = {"Bronze armor", "Chainmail armor" ,"Aligator armor"};

        int maxLevel = rng.nextInt(3, 5);
        for(int level = 1; level < 5; level++){
            for(String name : lowLevelHeavyArmorNames){
                lowLevelItemList.add(new HeavyArmor(name, rng.nextInt(5, 8), calcWorth(level, 80),10, level, maxLevel ));
            }
        }
    }

    public List<Item> getRangedItems(int enemyLevel){
        List<Item> rangedItems = new ArrayList<>();
        int range = rng.nextInt(3);
        int minLevel = Math.max(1, enemyLevel - range);
        int maxLevel = enemyLevel + range;
        for(Item item : lowLevelItemList){
            if(item.getLevel() >= minLevel && item.getLevel() <= maxLevel ){
                rangedItems.add(item);
            }
        }
        return rangedItems;
    }

    public Item pickRandomItem(int enemyLevel){
        generateWeapons();
        generateArmor();
        List<Item> rangedItems = getRangedItems(enemyLevel);
        if(!rangedItems.isEmpty()){
            Random rng = new Random();
            return rangedItems.get(rng.nextInt(rangedItems.size()));
        }
        return null;
    }
    public int calcWorth(int level, int worth){
        return worth + (rng.nextInt(10 * level));
    }
}
