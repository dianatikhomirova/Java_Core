package lesson01;

public class Lesson01 {

    public static void main(String[] args) {

        Cat cat = new Cat("Барсик");
        Human human = new Human("Борис");
        Robot robot = new Robot("Виктор");
        Wall wall = new Wall(5);
        Treadmill treadmill = new Treadmill(15);

        Entity[] participants = {cat, human, robot};

        Object[] obstacles = {wall, treadmill};

        for (int i = 0; i < participants.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                if (obstacles[j] instanceof Wall) {
                    Wall obstacle = (Wall) obstacles[j];
                    participants[i].jump(obstacle);
                } else {
                    Treadmill obstacle = (Treadmill) obstacles[j];
                    participants[i].run(obstacle);
                }
            }
        }
    }
}
