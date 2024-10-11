public abstract class Item  {
    private String name;
    private int worth;
    private int weight;
    private int level;
    private int index;

    public Item (String name, int worth, int weight, int level) {
        this.name = name;
        this.worth = worth;
        this.weight = weight;
        this.level = level;
        this.index = 0;
    }

    public int getLevel(){
        return level;
    }

    public void setIndex(int index){
        this.index = index;
    }
    public int getIndex(){
        return this.index;
    }

    public String getName() {
        return name;
    }

    public int getWorth() {
        return worth;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return System.lineSeparator() + name + System.lineSeparator() + "Worth: " +  worth + " Gold" +
                System.lineSeparator() + "Weight: " + weight + "kg" ;
    }
}
