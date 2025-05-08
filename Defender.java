package soccerStats;

class Defender extends SoccerPlayer implements Trainable {
	private int blocks;
	private int redCards;
	private int yellowCards;
	
	public Defender() {
		super();
		this.blocks = 0;
		this.redCards = 0;
		this.yellowCards = 0;
	}
	
	public Defender(String name, int age, int goals, int assists, Team team, int blocks, int redCards, int yellowCards) {
		super(name, "Defender", age, goals, assists, team);
		this.blocks = blocks;
		this.redCards = redCards;
		this.yellowCards = yellowCards;
	}
	
	public int getBlocks() { return blocks; }
    public void setBlocks(int blocks) { this.blocks = blocks; }

    public int getRedCards() { return redCards; }
    public void setRedCards(int redCards) { this.redCards = redCards; }

    public int getYellowCards() { return yellowCards; }
    public void setYellowCards(int yellowCards) { this.yellowCards = yellowCards; }

    @Override
    public void showValues() {
        System.out.println("[Defender] " + getName() + " | Age: " + getAge() + " | Goals: " + getGoalsScored() +
                           " | Assists: " + getAssists() + " | Blocks: " + blocks +
                           " | Red Cards: " + redCards + " | Yellow Cards: " + yellowCards + " | " + getTeam());
    }

    @Override
    public void inputValues() {
        setName("Kiko Carrillo");
        setPosition("Defender");
        setAge(30);
        setGoalsScored(2);
        setAssists(5);
        setTeam(new Team("La Esperanza", "Coach Silver"));
        blocks = 80;
        redCards = 23;
        yellowCards = 59;
    }

    @Override
    public String playStyle() { return "Strong, defensive and disciplined."; }

    @Override
    public void train() { System.out.println(getName() + " is doing defensive drills."); }

    @Override
    public void rest() { System.out.println(getName() + " is stretching and cooling down."); }
}
