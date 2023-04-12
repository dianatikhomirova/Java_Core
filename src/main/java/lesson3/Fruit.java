package lesson3;

public abstract class Fruit {
    private static float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    public static float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
