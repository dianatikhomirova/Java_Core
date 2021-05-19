package lesson01;

public class Cat implements Entity {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("котик " + this.name + " пробежал");
    }

    public void run(Treadmill treadmill) {
        System.out.println("котик " + this.name + " пробежал по дорожке длиной " + treadmill.getLength() + "м");
    }

    public void jump() {
        System.out.println("котик " + this.name + " прыгнул");
    }

    public void jump(Wall wall) {
        System.out.println("котик " + this.name + " прыгнул через стену высотой " + wall.getHeight() + "м");
    }
}
