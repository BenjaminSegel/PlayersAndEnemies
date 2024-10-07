import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyGenerator {
    List<Enemy> enemyList;

    public EnemyGenerator(){
        enemyList = new ArrayList<>();
    }

    private void generateEnemies(){
        String[] enemynames = {"Lava Goblin", "Trench Fox", "Ice Troll", "Water Dragon", "Holy Demon"};

        for(int level = 1;level <= 20;level++){
            for(String name : enemynames){
                enemyList.add(new Enemy(name, level));
            }
        }
    }

    public List<Enemy> getRangedEnemies(int playerLevel, int range){
        List<Enemy> rangedEnemies = new ArrayList<>();
        int minLevel = Math.max(1, playerLevel - range);
        int maxLevel = playerLevel + range;

        for(Enemy enemy : enemyList){
            if(enemy.getLevel() >= minLevel && enemy.getLevel() <= maxLevel){
                rangedEnemies.add(enemy);
            }
        }
        return rangedEnemies;
    }

    public Enemy pickRandomEnemy(int playerLevel, int range){
        generateEnemies();
        List<Enemy> rangedEnemies = getRangedEnemies(playerLevel, range);
        if(!rangedEnemies.isEmpty()){
            Random rng = new Random();
            return rangedEnemies.get(rng.nextInt(rangedEnemies.size()));
        }
        return null;
    }
}
