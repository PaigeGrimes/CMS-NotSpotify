package NotSpotify;
/**
 * Paige Grimes
 * NotSpotify.Playlist.java
 * The NotSpotify.Playlist class (Parent) receives a name from the user and allows the user to add/remove songs.
 * The user is also able to "listen" to the playlist with the playAllSongs() method.
 */

import java.util.ArrayList;

public class Playlist {
    // Declare String name, and ArrayList songs
    private String name;
    public ArrayList<Song> songs = new ArrayList<>();

    // Getters and setters for
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {
        // Add a song object to the songs Arraylist
        if (!this.songs.contains(song)) { // If the song is not already in the list
            songs.add(song); // Add the song
            System.out.println("Your song has been added."); // Let the user know

        } else { // Otherwise, tell the user the song is already in the playlist
            System.out.println("This song is already in the playlist.");
        }
    }

    public void removeSong(Song song) {
        // Remove a song object from the songs Arraylist
        if ((songs.contains(song))) { // If the song is in the playlist
            songs.remove(song); // remove the song
            System.out.println("Your song has been removed."); // Let the user know it has been removed
        } else { // Let the user know they song is not in the playlist
            System.out.println("This song is not in the playlist.");
        }
    }

    public void playAllSongs() {
        // For each song in songs, tell the user what they are listening to
        if (!songs.isEmpty()) { // If the songs' list is not empty, play the songs!
            System.out.println("NotSpotify.Playlist: " + getName()); // Show the playlist name
            // For each song in the songs Arraylist
            for (Song song : this.songs) {
                // Display them to the user; or, "Play" them.
                System.out.println("Now playing: ");
                System.out.println("Title: " + song.getTitle() + ", Artist: " + song.getArtist() + ", Duration: " + song.getDuration() + " min.");
            }
        } else { // If the song list is empty, tell the user.
            System.out.println("There are no songs in the playlist.");
        }
    }
}
