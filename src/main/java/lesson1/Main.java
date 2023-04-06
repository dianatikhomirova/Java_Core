package lesson1;

import static lesson1.Utils.makeAnimalOlder;

public class Main {
    public static void main(String[] args) {
        Cat competitor1 = new Cat("Морис", "red", 10);
        competitor1.setSwimmingSpeed(2);
        competitor1.setJumpingSpeed(2);
        Wolf competitor2 = new Wolf("Волк", "серый", 12);
        competitor2.setSwimmingSpeed(3);
        competitor2.setJumpingSpeed(1);
        Turtle competitor3 = new Turtle("Черепаха", "зеленая", 100);
        competitor3.setSwimmingSpeed(1.5);
        Rabbit competitor4 = new Rabbit("Заяц", "серый", 2);
        competitor4.setJumpingSpeed(3.15);

        Wall wall = new Wall(5);
        Pool pool = new Pool(35);

        Animal[] competitors = {competitor1, competitor2, competitor3, competitor4};

        Object[] obstacles = {wall, pool};

        Course c = new Course(obstacles);
        Team team = new Team("numberOne", competitors);

        c.doIt(team);
        team.showResults();
    }
}
