import java.util.Scanner;

public class Game {
    private boolean running;
    private boolean inCombat;
    private Scanner sc;
    private EnemyGenerator enemyGenerator;
    public Game(){
        running = true;
        inCombat = false;
        sc = new Scanner(System.in);
        enemyGenerator = new EnemyGenerator();
    }



    public void start(){

        while(running){
            Weapon w1 = new Sword("Elf Sword", 500, 5, 50, "Elf Dust");
            Weapon w2 = new Sword("Dragon wand", 2000, 4, 180, "Dragon Scale");
            System.out.println("Welcome to Player and Enemy! ");
            System.out.println("Please enter your name: ");
            String name = sc.nextLine();
            Player player = new Player(name);
            player.addItemToInventory(w1);
            player.addItemToInventory(w2);
            System.out.println("1. Open Inventory " + System.lineSeparator() +
                    "2. Fight enemy");
            int menuChoice = sc.nextInt();
            switch(menuChoice){
                case 1:
                player.openInventory();
                break;
                case 2:

                    inCombat = true;
                    Enemy enemy = enemyGenerator.pickRandomEnemy(player.getLevel(), 2);
                    System.out.println("A " + enemy.getName() + " crossed your path!");
                    while(inCombat){
                    System.out.println(enemy);
                    System.out.println("What do you want to do?: " + System.lineSeparator() +
                            "1. Attack" + System.lineSeparator() +
                            "2. Use consumable" + System.lineSeparator() +
                            "3. Flee");
                    int playerChoice = sc.nextInt();
                    switch(playerChoice){
                        case 1:
                            enemy.takeDamage(player.attack());
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
