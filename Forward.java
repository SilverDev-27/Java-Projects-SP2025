package soccerStats;

class Forward extends SoccerPlayer implements Trainable{
	private int shotsOnTarget;
	private int offsides;
	
	public Forward() {
		super();
		this.shotsOnTarget = 0;
		this.offsides = 0;
	}
	
	public Forward(String name, int age, int goals, int assists, Team team, int shotsOnTarget, int offsides) {
		super(name, "Forward", age, goals, assists, team);
		this.shotsOnTarget = shotsOnTarget;
		this.offsides = offsides;
	}
	
	public int getShotsOnTarget() { return shotsOnTarget; }
	public void setShotsOnTarget(int shotsOnTarget) { this.shotsOnTarget = shotsOnTarget; }
	
	public int getOffsides() { return offsides; }
	public void setOffsides(int offsides) { this.offsides = offsides; }
	
	@Override
	public void showValues() {
		System.out.println("[Forward] " + getName() + " | Age: " + getAge() + " | Goals: " + getGoalsScored() +
                " | Assists: " + getAssists() + " | Shots on Target: " + shotsOnTarget +
                " | Offsides: " + offsides + " | " + getTeam());
	}
	
	@Override
    public void inputValues() {
        setName("Aldo Pacheco");
        setPosition("Forward");
        setAge(25);
        setGoalsScored(20);
        setAssists(10);
        setTeam(new Team("La Esperanza", "Coach Silver"));
        shotsOnTarget = 45;
        offsides = 5;
    }

    @Override
    public String playStyle() { return "Wide Playmaker."; }

    @Override
    public void train() { System.out.println(getName() + " is doing finishing drills."); }

    @Override
    public void rest() { System.out.println(getName() + " is resting and recovering."); }
}
