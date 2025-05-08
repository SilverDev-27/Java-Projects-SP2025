package soccerStats;

class Midfielder extends SoccerPlayer implements Trainable {
	private int passesCompleted;
    private int tackles;

    public Midfielder() {
        super();
        this.passesCompleted = 0;
        this.tackles = 0;
    }

    public Midfielder(String name, int age, int goals, int assists, Team team, int passesCompleted, int tackles) {
        super(name, "Midfielder", age, goals, assists, team);
        this.passesCompleted = passesCompleted;
        this.tackles = tackles;
    }

    public int getPassesCompleted() { return passesCompleted; }
    public void setPassesCompleted(int passesCompleted) { this.passesCompleted = passesCompleted; }

    public int getTackles() { return tackles; }
    public void setTackles(int tackles) { this.tackles = tackles; }

    @Override
    public void showValues() {
        System.out.println("[Midfielder] " + getName() + " | Age: " + getAge() + " | Goals: " + getGoalsScored() +
                           " | Assists: " + getAssists() + " | Passes: " + passesCompleted +
                           " | Tackles: " + tackles + " | " + getTeam());
    }

    @Override
    public void inputValues() {
        setName("Charlie Carbajal");
        setPosition("Midfielder");
        setAge(28);
        setGoalsScored(10);
        setAssists(15);
        setTeam(new Team("La Esperanza", "Coach Silver"));
        passesCompleted = 100;
        tackles = 20;
    }

    @Override
    public String playStyle() { return "Playmaker with defensive duties."; }

    @Override
    public void train() { System.out.println(getName() + " is practicing passing accuracy."); }

    @Override
    public void rest() { System.out.println(getName() + " is having a recovery day."); }
}
