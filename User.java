package NotSpotify; /**
 * Paige Grimes
 * NotSpotify.User.java
 * The NotSpotify.User class allows the user to have a username and playlists. The user can create and delete playlists.
 * The user can also add and remove songs from their playlists.
 */

import java.util.ArrayList;

public class User {
    // Declare attributes
    private String username;
    public ArrayList<Playlist> playlists = new ArrayList<>();

    // Create a constructor for NotSpotify.User
    public User(String username) {
        this.username = username;
    }

    // Getters and Setters
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void createPlaylist(String name, String type) {
        // Creates a playlist of a specified type (Rock, Pop, Jazz)
        if (type.toLowerCase().equals("jazz")) { // Convert type to lowercase and see if it equals jazz
            JazzPlaylist jazzPlaylists = new JazzPlaylist(); // Create a NotSpotify.JazzPlaylist object
            jazzPlaylists.setName(name); // Give it a name
            this.playlists.add(jazzPlaylists); // Add the playlist to the arraylist of playlists

            // Do the same for the following if statements
        } else if (type.toLowerCase().equals("rock")) {
            RockPlaylist rockPlaylist = new RockPlaylist();
            rockPlaylist.setName(name);
            this.playlists.add(rockPlaylist);
        } else if (type.toLowerCase().equals("pop")) {
            PopPlaylist popPlaylist = new PopPlaylist();
            popPlaylist.setName(name);
            this.playlists.add(popPlaylist);
        } else { // If the genre isn't recognized, add it to the parent NotSpotify.Playlist class
            Playlist other = new Playlist();
            other.setName(name);
            this.playlists.add(other);
        }
    }

    public void deletePlaylist(Playlist playlist) {
        // Deletes a specific playlist
        if (playlists.contains(playlist)) { // Has the playlist been created?
            playlists.remove(playlist); // Remove the playlist
            System.out.println("NotSpotify.Playlist has been deleted."); // Let the user know it has been deleted
        } else { // Let the user know that the playlist doesn't exist
            System.out.println("That playlist does not exist.");
        }

    }

    public void addSongToPlaylist(Playlist playlist, Song song) {
        // Add song to playlist
        if (!(playlist.getName().contains(song.getArtist()))) { // Is the song not in the playlist already?
            playlist.addSong(song); // Then, add the song to the playlist
        } else { // Let the user know the song is already in the playlist
            System.out.println("That song is already in the playlist.");
        }
    }

    public void removeSongFromPlaylist(Playlist playlist, Song song) {
        // Remove a song from the playlist
        if (playlist.getSongs().contains(song)) { // Is the song in the playlist?
            playlist.removeSong(song);
        } else {
            System.out.println("That song is not in the playlist."); // Le
        }
    }
}
