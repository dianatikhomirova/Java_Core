package lesson1;

public class Rabbit extends Animal implements CanJump {
    private double jumpingSpeed;

    public Rabbit(String name, String color, int age) {
        super(name, color, age);
    }

    public double getJumpingSpeed() {
        return jumpingSpeed;
    }

    public void setJumpingSpeed(double jumpingSpeed) {
        this.jumpingSpeed = jumpingSpeed;
    }

    @Override
    public void voice() {
        System.out.println("Заяц хрустит.");
    }

    @Override
    public double jump(Wall wall) {
        System.out.println("Я заяц, я прыгаю!");
        double time = wall.getHeight() / jumpingSpeed;
        System.out.println("Затратил " + time);
        return time;
    }
}
