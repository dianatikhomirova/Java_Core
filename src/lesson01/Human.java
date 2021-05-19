package lesson01;

public class Human implements Entity {
    private String name;

    public Human(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("человек " + this.name + " пробежал");
    }

    public void run(Treadmill treadmill) {
        System.out.println("человек " + this.name + " пробежал по дорожке длиной " + treadmill.getLength() + "м");
    }

    public void jump() {
        System.out.println("человек " + this.name + " прыгнул");
    }

    public void jump(Wall wall) {
        System.out.println("человек " + this.name + " прыгнул через стену высотой " + wall.getHeight() + "м");
    }
}

