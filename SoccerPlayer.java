package soccerStats;

abstract class SoccerPlayer {
	// Member Variables
		private String name;
		private String position;
		private int age;
		private int goalsScored;
		private int assists;
		private Team team;
		
		// Default constructor
		public SoccerPlayer() {
			this.name = "Unknown";
			this.position = "Unknown";
			this.age = 0;
			this.goalsScored = 0;
			this.assists = 0;
			this.team = new Team();
		}
		
		// Constructor with all parameters
		public SoccerPlayer(String name, String position, int age, int goalsScored, int assists, Team team) {
			this.name = name;
			this.position = position;
			this.age = age;
			this.goalsScored = goalsScored;
			this.assists = assists;
			this.team = team != null ? team : new Team(); // Asked AI for help with this part because I kept getting unknown for team value
		}
		
		// Getter and Setter methods
		public String getName() {return name;}
		public void setName(String name) {this.name = name; }
		
		public String getPosition() { return position; }
	    public void setPosition(String position) { this.position = position; }
	    
	    public int getAge() { return age; }
	    public void setAge(int age) { this.age = age; }
	    
	    public int getGoalsScored() { return goalsScored; }
	    public void setGoalsScored(int goalsScored) { this.goalsScored = goalsScored; }
	    
	    public int getAssists() { return assists; }
	    public void setAssists(int assists) { this.assists = assists; }
	    
	    public Team getTeam() { return team; }
	    public void setTeam(Team team) { this.team = team; }
	    
	    public void scoreGoal() { goalsScored++; }
	    public void makeAssist() { assists++; }
	    
	    public abstract void showValues();
	    public abstract void inputValues();
	    public abstract String playStyle();
}