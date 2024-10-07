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

    public void removeItem(String name) throws Exception{
        for(Item item : items){
            if(item.getName().equalsIgnoreCase(name)){
                try{
                items.remove(item);
                }catch (Exception e){
                    System.out.println("Something went wrong: " + e);
                    throw e;
                }
            }
        }
    }

    public void openInventory(){
        for(Item item : items){
            System.out.println(item);
        }

    }

    public void viewItem(String name){
        for(Item item : items){

        }
    }
}
