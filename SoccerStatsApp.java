package soccerStats;
import java.util.ArrayList;

// Class representing a Soccer Player
class SoccerPlayer {
	// Member Variables
	private String name;
	private String position;
	private int age;
	private int goalsScored;
	private int assists;
	
	// Default constructor
	public SoccerPlayer() {
		this.name = "Unknown";
		this.position = "Unknown";
		this.age = 0;
		this.goalsScored = 0;
		this.assists = 0;
	}
	
	// Constructor with name and position
	public SoccerPlayer(String name, String position) {
		this.name = name;
		this.position = position;
		this.age = 0;
		this.goalsScored = 0;
		this.assists = 0;
	}
	
	// Constructor with all parameters
	public SoccerPlayer(String name, String position, int age, int goalsScored, int assists) {
		this.name = name;
		this.position = position;
		this.age = age;
		this.goalsScored = goalsScored;
		this.assists = assists;
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
    
    // Method to display player details
    public void showValues() {
    	System.out.println("Soccer Player Details:");
    	System.out.println("Name: "+ name);
    	System.out.println("Position: "+ position);
    	System.out.println("Age: "+ age);
    	System.out.println("Goals Scored: "+ goalsScored);
    	System.out.println("Assists: "+ assists + "\n");
    }
    
    // Method to update goals scored
    public void scoreGoal() {
    	goalsScored++;
    	System.out.println(name + " scored a goal! Total Goals: " + goalsScored + "\n");
    }
    
    // Method to update assists
    public void makeAssist() {
    	assists++;
    	System.out.println(name + " made an assist! Total Assists: "+ assists + "\n");
    }
}

public class SoccerStatsApp {
	public static void main(String[] args) {
		// Creating SoccerPlayer objects using different constructors
		SoccerPlayer player1 = new SoccerPlayer();
		SoccerPlayer player2 = new SoccerPlayer("Cole Palmer", "Winger");
		SoccerPlayer player3 = new SoccerPlayer("Frank Lampard", "Midfielder", 46, 177, 102);
		
		// Modifying values using setter methods
		player1.setName("Thierry Henry");
		player1.setPosition("Forward");
		player1.setAge(47);
		player1.setGoalsScored(175);
		player1.setAssists(74);
		
		player2.setAge(22);
		player2.setGoalsScored(14);
		player2.setAssists(6);
		
		// Storing players in an ArrayList
		ArrayList<SoccerPlayer> players = new ArrayList<>();
		players.add(player1);
		players.add(player2);
		players.add(player3);
		
		// Displaying details and demonstrating methods
		for (SoccerPlayer player : players) {
			player.showValues();
			player.scoreGoal(); // Player scores a goal
			player.makeAssist(); // Player makes an assist
		}
	}
}
