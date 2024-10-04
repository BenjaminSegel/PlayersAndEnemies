public abstract class Item  {
    private String name;
    private int worth;
    private int weight;

    public Item (String name, int worth, int weight) {
        this.name = name;
        this.worth = worth;
        this.weight = weight;
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
        return name + System.lineSeparator() + "worth: " +  worth + " gold" +
                System.lineSeparator() + "weight: " + weight + "kg" ;
    }
}
