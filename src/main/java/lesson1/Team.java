package lesson1;

public class Team {
    private String name;
    private Animal[] members;
    private StringBuilder results;

    public Animal[] getMembers() {
        return members;
    }

    public StringBuilder getResults() {
        return results;
    }

    public void setResults(StringBuilder results) {
        this.results = results;
    }

    public Team(String name, Animal[] members) {
        this.name = name;
        this.members = members;
    }

    public void membersInfo() {
        for (Animal member : members) {
            System.out.format("%s %s\n", member.getClass().getSimpleName(), member.getName());
        }
    }

    public void showResults() {
        System.out.println(results);
    }
}
