package lesson1;

public class Course {
    private Object[] obstacles;

    public Course(Object[] obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        Animal[] competitors = team.getMembers();
        StringBuilder results = new StringBuilder();
        for (int i = 0; i < competitors.length; i++) {
            boolean canSwim = competitors[i] instanceof CanSwim;
            boolean canJump = competitors[i] instanceof CanJump;
            for (int j = 0; j < obstacles.length; j++) {
                if (obstacles[j] instanceof Wall) {
                    Wall obstacle = (Wall) obstacles[j];
                    if (canJump) {
                        CanJump competitor = (CanJump) competitors[i];
                        String result = competitors[i].getClass().getSimpleName() + " " + competitors[i].getName() + " jumped in " + competitor.jump(obstacle) + "\n";
                        results.append(result);
                    }
                } else {
                    Pool obstacle = (Pool) obstacles[j];
                    if (canSwim) {
                        CanSwim competitor = (CanSwim) competitors[i];
                        String result = competitors[i].getClass().getSimpleName() + " " + competitors[i].getName() + " swam in " + competitor.swim(obstacle) + "\n";
                        results.append(result);
                    }
                }
            }
        }
        team.setResults(results);
    }
}
