package lesson3;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruitList = new ArrayList<>();

    public Box() {
    }

    public ArrayList<T> getFruitList() {
        return fruitList;
    }

    public void setFruitList(ArrayList<T> fruitList) {
        this.fruitList = fruitList;
    }

    public void addFruit(T fruit) {
        fruitList.add(fruit);
    }

    public float getWeight() {
        if (fruitList.size() == 0) {
            return 0;
        }
        return fruitList.size() * fruitList.get(0).getWeight();
    }

    public boolean pourOver(Box<T> box) {
        if (Integer.MAX_VALUE - box.getFruitList().size() < fruitList.size()) {
            return false;
        }
        box.getFruitList().addAll(fruitList);
        fruitList.clear();
        return true;
    }

    public boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruitList=" + fruitList +
                '}';
    }
}
