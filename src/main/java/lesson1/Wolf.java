package lesson1;

public class Wolf extends Animal implements CanSwim, CanJump {
    private int swimmingSpeed;
    private int jumpingSpeed;

    public Wolf(String name, String color, int age) {
        super(name, color, age);
    }

    public int getSwimmingSpeed() {
        return swimmingSpeed;
    }

    public void setSwimmingSpeed(int swimmingSpeed) {
        this.swimmingSpeed = swimmingSpeed;
    }

    public int getJumpingSpeed() {
        return jumpingSpeed;
    }

    public void setJumpingSpeed(int jumpingSpeed) {
        this.jumpingSpeed = jumpingSpeed;
    }

    @Override
    public void voice() {
        System.out.println("Волк воет!");
    }

    public double swim(Pool pool) {
        System.out.println("Я волк, я плыву!");
        System.out.println("Затратил " + pool.getLength() / swimmingSpeed);
        return pool.getLength() / swimmingSpeed;
    }
    @Override
    public double jump(Wall wall) {
        System.out.println("Я волк, я прыгаю!");
        double time = wall.getHeight() / jumpingSpeed;
        System.out.println("Затратил " + time);
        return time;
    }
}
