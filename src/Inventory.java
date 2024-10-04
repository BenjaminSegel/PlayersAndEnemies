import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List <Item> items;

    public Inventory(){
        items = new ArrayList<Item>();
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(String name){
        for(Item item : items){
            if(item.getName().equalsIgnoreCase(name)){
                items.remove(item);
            }
        }
    }

    public void openInventory(){
        System.out.println("Inventory: " + System.lineSeparator() +
                items);

    }

    public void viewItem(String name){
        for(Item item : items){
            if(item.getName().equalsIgnoreCase(name)){
                System.out.println(item);
            }
        }
    }
}
