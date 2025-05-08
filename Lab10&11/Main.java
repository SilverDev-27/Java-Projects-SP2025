package MusicRecord;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicRecords musicRecords = new MusicRecords();

        System.out.print("Enter the filename to load music records: ");
        String filename = scanner.nextLine();
        musicRecords.loadFromFile(filename);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Display Complete List of Items in Original Order");
            System.out.println("2. Add a new Item");
            System.out.println("3. Delete an Item");
            System.out.println("4. Modify an Item");
            System.out.println("5. Generate a Report Filtered by Artist");
            System.out.println("6. Create updated .CSV file with the new List of Items");
            System.out.println("7. Exit Program");
            System.out.print("Enter your choice (1-7): ");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter a number (1-7): ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    musicRecords.displayAll();
                    break;
                case 2:
                    System.out.print("Enter record ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter artist: ");
                    String artist = scanner.nextLine();
                    System.out.print("Enter song name: ");
                    String songName = scanner.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter year: ");
                    int releaseYear = Integer.parseInt(scanner.nextLine());
                    musicRecords.addRecord(new MusicRecord(id, artist, songName, genre, releaseYear));
                    break;
                case 3:
                    System.out.print("Enter record ID to delete: ");
                    musicRecords.deleteRecord(scanner.nextLine());
                    break;
                case 4:
                    System.out.print("Enter record ID to modify: ");
                    musicRecords.modifyRecord(scanner.nextLine(), scanner);
                    break;
                case 5:
                    System.out.print("Enter artist name to filter by: ");
                    musicRecords.filterByArtist(scanner.nextLine());
                    break;
                case 6:
                    System.out.print("Enter filename to save to: ");
                    musicRecords.saveToFile(scanner.nextLine());
                    break;
                case 7:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 1–7.");
            }
        } while (choice != 7);
    }
}
