package NotSpotify;

/**
 * Paige Grimes
 * NotSpotify.Song.java
 * The NotSpotify.Song class allows the creation of song objects. The songs must have a title, artist, and the length of the
 * song(duration in minutes). The user can also create (add) and retrieve songs.
 */
public class Song {
    // Declare properties
    private String title;
    private String artist;
    private double duration; // minutes

    // Create a constructor to initialize title, artist, duration
    public Song(String title, String artist, double duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    // Getters and setters
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getDuration() {
        return this.duration;
    }

    public void setArtist(double duration) {
        this.duration = duration;
    }
}
