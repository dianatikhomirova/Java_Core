package lesson3;

public class Main {
    public static void main(String[] args) {
        Box<Apple> box = new Box<>();
        box.addFruit(new Apple());
        box.addFruit(new Apple());
        box.addFruit(new Apple());
        System.out.println(box.getWeight());

        Box<Apple> box1 = new Box<>();
        box1.addFruit(new Apple());
        box1.addFruit(new Apple());
        //box1.addFruit(new Apple());

        Box<Orange> box2 = new Box<>();
        box2.addFruit(new Orange());
        box2.addFruit(new Orange());

        System.out.println(box1.compare(box));
        System.out.println(box2.compare(box));

        boolean isSuccessful = box.pourOver(box1);
        if (!isSuccessful) {
            System.out.println("The number of elements in 2 boxes is too large");
        }
        System.out.println(box);
        System.out.println(box1);
    }
}
