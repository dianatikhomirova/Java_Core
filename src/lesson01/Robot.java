package lesson01;

public class Robot implements Entity {
    private String name;

    public Robot (String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("робот " + this.name + " пробежал");
    }

    public void run(Treadmill treadmill) {
        System.out.println("робот " + this.name + " пробежал по дорожке длиной " + treadmill.getLength() + "м");
    }

    public void jump() {
        System.out.println("робот " + this.name + " прыгнул");
    }

    public void jump(Wall wall) {
        System.out.println("робот " + this.name + " прыгнул через стену высотой " + wall.getHeight() + "м");
    }
}