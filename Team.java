package soccerStats;

public class Team {
	private String teamName;
    private String coachName;

    public Team() {
        this.teamName = "Unknown";
        this.coachName = "Unknown";
    }

    public Team(String teamName, String coachName) {
        this.teamName = teamName;
        this.coachName = coachName;
    }

    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }

    public String getCoachName() { return coachName; }
    public void setCoachName(String coachName) { this.coachName = coachName; }

    @Override
    public String toString() {
        return teamName + " (Coach: " + coachName + ")";
    }
}
