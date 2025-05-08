package soccerStats;

public class SoccerStatsApp {
	public static void main(String[] args) {
		SoccerPlayer[] players = new SoccerPlayer[6];

        players[0] = new Forward("Erling Haaland", 23, 30, 7, new Team("Manchester City", "Pep Guardiola"), 100, 10);
        players[1] = new Forward(); players[1].inputValues();

        players[2] = new Midfielder("Jude Bellingham", 21, 37, 23, new Team("Real Madrid", "Carlo Ancelotti"), 47, 262);
        players[3] = new Midfielder(); players[3].inputValues();

        players[4] = new Defender("Ruben Dias", 28, 3, 2, new Team("Manchester City", "Pep Guardiola"), 70, 0, 16);
        players[5] = new Defender(); players[5].inputValues();
		
		System.out.printf("%-20s\n", "Soccer Stats");
        System.out.println("-------------------------------------------------------------------------------------------");

        for (SoccerPlayer p : players) {
            p.showValues();
             /*System.out.printf("%-20s %-10s %-5d %-5d %-5d %-30s %-30s\n",
                    p.getName(), p.getPosition(), p.getAge(), p.getGoalsScored(), p.getAssists(),
                    p.getTeam().getTeamName(), p.playStyle()); */
            
            if (p instanceof Trainable) {
                ((Trainable) p).train();
                ((Trainable) p).rest();
            }
            System.out.println();
        }
	}
}
