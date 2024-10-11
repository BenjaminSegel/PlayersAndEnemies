import java.util.Scanner;

public class Game {
    private boolean running;
    private boolean inGame;
    private boolean inCombat;
    private Scanner sc;
    private EnemyGenerator enemyGenerator;
    private ItemDrop itemDrop;
    public Game(){
        running = true;
        inCombat = false;
        sc = new Scanner(System.in);
        enemyGenerator = new EnemyGenerator();
        itemDrop = new ItemDrop();
        inGame = false;

    }



    public void start(){

        while(running){
            System.out.println("Welcome to Player and Enemy! ");
            System.out.println("Please enter your name: ");
            String name = sc.nextLine();
            Player player = new Player(name);
            player.addItemToInventory(new HealthPotion(3));
            player.addItemToInventory(new Sword("Elf Sword", 500, 5, 50, "Elf Dust", 10, 10));
            player.addItemToInventory(new Sword("Dragon wand", 2000, 4, 180, "Dragon Scale", 10, 10));
            inGame = true;
            while(inGame){
            System.out.println(player);
            System.out.println("1. Open Inventory " + System.lineSeparator() +
                    "2. Fight enemy");
            int menuChoice = sc.nextInt();
            switch(menuChoice){
                case 1:
                System.out.println("Enter item number to showcase it");
                player.openInventory();
                int inventoryChoice = sc.nextInt();
                Item item = player.viewSpecificPlayerItem(inventoryChoice);
                int itemChoice = sc.nextInt();
                switch(itemChoice){
                    case 1:
                        player.manageItem(item);
                        break;
                    case 2:
                        player.removeItemFromInventory(item);
                        break;
                    case 3:
                        if(item instanceof Upgradable){
                            ((Upgradable) item).upgrade(player.getGold());
                            break;
                        }
                        System.out.println("Invalid choice");
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }

                break;
                case 2:

                    inCombat = true;
                    Enemy enemy = enemyGenerator.pickRandomEnemy(player.getLevel(), 2);
                    System.out.println("A " + enemy.getName() + " crossed your path!");
                    while(inCombat){
                    System.out.println(player);
                    System.out.println(enemy);
                    System.out.println("What do you want to do?: " + System.lineSeparator() +
                            "1. Attack" + System.lineSeparator() +
                            "2. Use consumable" + System.lineSeparator() +
                            "3. Flee");
                    int playerChoice = sc.nextInt();
                    switch(playerChoice){
                        case 1:
                            player.attack(enemy);
                            if(enemy.getHealth() <= 0){
                                System.out.println(enemy.getName() + " was defeated!");
                                Item droppedItem = itemDrop.pickRandomItem(enemy.getLevel());
                                player.recieveGold(enemy.dropGold());
                                System.out.println(droppedItem.getName() + " was dropped!: " + System.lineSeparator() +
                                        droppedItem + System.lineSeparator() +
                                        "1. Pick up item" + System.lineSeparator() +
                                        "2. Leave item" + System.lineSeparator());
                                int dropChoice = sc.nextInt();
                                switch(dropChoice){
                                    case 1:
                                        player.addItemToInventory(droppedItem);
                                        System.out.println("Item was added to Inventory!");
                                        break;
                                    case 2:
                                        break;
                                    default:
                                        System.out.println("Invalid choice!");
                                }
                                player.recieveXp(enemy.calcXpDrop(player.getLevel()));
                                inCombat = false;
                                break;
                            }
                            enemy.attack(player);
                            break;
                        case 2:
                            player.useConsumable();
                            break;
                        case 3:
                            System.out.println(player.getName() + " ran away! What a coward!");
                            inCombat = false;
                            break;

                    }
                    }
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }

            }

        }
    }
}
