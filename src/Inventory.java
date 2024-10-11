import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List <Item> items;
    private List<Item> equippedItems;
    public Inventory(){
        items = new ArrayList<Item>();
        equippedItems = new ArrayList<Item>();
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void addEquippedItem(Item item){
        equippedItems.add(item);
    }

    public void removeEquippedItem(Item item){
        equippedItems.remove(item);
    }

    public void removeItem(String name) throws Exception{
        Item itemToRemove = null;
        for(Item item : items){
            if(item.getName().equalsIgnoreCase(name)){
                itemToRemove = item;
            }
        }
                try{
                if(itemToRemove != null){
                    items.remove(itemToRemove);
                    System.out.println(itemToRemove.getName() + " was removed from inventory");
                }else{
                    throw new Exception("Item not found");
                }
                }catch (Exception e){
                    System.out.println("Something went wrong: " + e);
                    throw e;
                }
    }

    public boolean itemEquipped(Item item){
        return equippedItems.contains(item);
    }

    public Item viewSpecificItem(int index){
        for(Item item : items){
            if(index == item.getIndex() && item.getClass().getSuperclass().toString().equals("class Consumable")){
                System.out.println(item);
                System.out.println("1. Use item" + System.lineSeparator() +
                        "2. Remove item");
                return item;
            }else if(index == item.getIndex()){
                if(itemEquipped(item)){
                    System.out.println(item);
                System.out.println("1. Unequip item" + System.lineSeparator()
                        + "2. Remove item" + System.lineSeparator()
                        +   "3. Upgrade item" + System.lineSeparator());
                    return item;
                }
                    System.out.println(item);
                System.out.println("1. Equip item" + System.lineSeparator()
                        + "2. Remove item" + System.lineSeparator()
                        + "3. Upgrade item" );
                    return item;


            }
        }
            return null;
    }

    public void openInventory(){
        int indexIncrement = 0;
        for(Item item : items){
            indexIncrement ++;
            item.setIndex(indexIncrement);
            System.out.println(indexIncrement + ". " + item);
        }

    }

}
