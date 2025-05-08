package MusicRecord;

public class MusicRecord {
    private String recordID;
    private String artist;
    private String songName;
    private String genre;
    private int releaseYear;

    public MusicRecord(String recordID, String artist, String songName, String genre, int releaseYear) {
        this.recordID = recordID;
        this.artist = artist;
        this.songName = songName;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }

    public String getRecordID() {
        return recordID;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return String.format("%-8s %-25s %-30s %-15s %-6d",
                recordID, artist, songName != null ? songName : "[No Title]", genre, releaseYear);
    }

    public String toCSV() {
        return String.join(",", recordID, artist, songName, genre, String.valueOf(releaseYear));
    }
}
