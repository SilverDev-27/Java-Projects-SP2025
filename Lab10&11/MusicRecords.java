package MusicRecord;
import java.io.*;
import java.util.*;

public class MusicRecords {
    private ArrayList<MusicRecord> records;

    public MusicRecords() {
        records = new ArrayList<>();
    }

    public void loadFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // skip blank lines
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String id = parts[0].trim();
                    String artist = parts[1].trim();
                    String songName = parts[2].trim();
                    String genre = parts[3].trim();
                    int releaseYear = Integer.parseInt(parts[4].trim());
                    records.add(new MusicRecord(id, artist, songName, genre, releaseYear));
                } else {
                    System.out.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public void displayAll() {
        System.out.printf("%-8s %-25s %-30s %-15s %-6s\n", "ID", "Artist", "Song Name", "Genre", "Year");
        System.out.println("--------------------------------------------------------------------------------------");
        for (MusicRecord r : records) {
            System.out.println(r);
        }
    }

    public void addRecord(MusicRecord record) {
        records.add(record);
        System.out.println("Record added.");
    }

    public void deleteRecord(String id) {
        boolean removed = records.removeIf(r -> r.getRecordID().equalsIgnoreCase(id));
        if (removed) {
            System.out.println("Record deleted.");
        } else {
            System.out.println("Record not found.");
        }
    }

    public void modifyRecord(String id, Scanner scanner) {
        for (MusicRecord r : records) {
            if (r.getRecordID().equalsIgnoreCase(id)) {
                System.out.print("Enter new artist: ");
                r.setArtist(scanner.nextLine());
                System.out.print("Enter new song name: ");
                r.setSongName(scanner.nextLine());
                System.out.print("Enter new genre: ");
                r.setGenre(scanner.nextLine());
                System.out.print("Enter new year: ");
                r.setReleaseYear(Integer.parseInt(scanner.nextLine()));
                System.out.println("Record modified.");
                return;
            }
        }
        System.out.println("Record not found.");
    }

    public void filterByArtist(String artist) {
        System.out.printf("%-8s %-25s %-30s %-15s %-6s\n", "ID", "Artist", "Song Name", "Genre", "Year");
        System.out.println("--------------------------------------------------------------------------------------");
        for (MusicRecord r : records) {
            if (r.getArtist().equalsIgnoreCase(artist)) {
                System.out.println(r);
            }
        }
    }

    public void saveToFile(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (MusicRecord r : records) {
                pw.println(r.toCSV());
            }
            System.out.println("Records saved to file.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
