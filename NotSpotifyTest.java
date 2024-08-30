package NotSpotify;
/**
 * Paige Grimes
 * NotSpotify.NotSpotifyTest.java
 * This is the main method that allows the user to interact with the !Spotify's system.
 * Resources:
 * https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
 * https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html - to refresh on scanner syntax.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class NotSpotifyTest {
    public static void main(String[] args) {
        // Initialize a playlist object
        Playlist playlist = new Playlist();

        // Random songs from Spotify's summer playlist to initialize songs on !Spotify
        Song birdsOfAFeather = new Song("Birds of a Feather", "Billie Eilish", 3.30);
        Song hotToGo = new Song("Hot to Go", "Chappel Roan", 3.05);
        Song pleasePleasePlease = new Song("Please Please Please", "Sabrina Carpenter", 3.06);
        Song heatWaves = new Song("Heat Waves", "Glass Animals", 3.59);
        Song cruelSummer = new Song("Cruel Summer", "Taylor Swift", 2.58);
        Song asItWas = new Song("As It Was", "Harry Styles", 2.47);

        // Create a list of available songs
        ArrayList<Song> availableSongs = new ArrayList<>();

        availableSongs.add(birdsOfAFeather);
        availableSongs.add(hotToGo);
        availableSongs.add(pleasePleasePlease);
        availableSongs.add(heatWaves);
        availableSongs.add(cruelSummer);
        availableSongs.add(asItWas);

        // Prompt the user to enter their name
        System.out.println("Welcome to !Spotify. What would you like your username to be?");
        Scanner sc = new Scanner(System.in);
        String inputName = sc.next();
        // Create a new user object
        User newUser = new User(inputName);

        // Display the option menu to the user
        System.out.println("----------------------------------------------");
        System.out.println("* " + newUser.getUsername() + "'s Menu *");
        System.out.println("----------------------------------------------");
        System.out.println("1. Create a new playlist.\n2. Add a song to a playlist.\n3. Remove a playlist.\n" +
                "4. Remove a song from a playlist.\n5. Play all songs\n0.Quit");
        System.out.println("----------------------------------------------");

        int choice = sc.nextInt(); // Get user input

        // Loop to control what the user wants to do
        while (choice != 0) {

            if (choice == 1) { // Create a new playlist
                // Get users input on playlist name and type (genre)
                System.out.println("What would you like to call your playlist?");
                String playlistName = sc.next();
                System.out.println("What genre is your playlist?");
                String genre = sc.next();
                newUser.createPlaylist(playlistName, genre);
                playlist.playAllSongs();
                sc.reset();
            } else if (choice == 2) { // Add a song to a playlist
                // Handle if there are no playlists
                if (!(newUser.getPlaylists().isEmpty())) {
                    System.out.println("What playlist would you like to add a song to?");
                    int i = 0;
                    // For each playlist object in the users' list of playlists, print out a number that corresponds to the name of the playlist
                    for (Playlist list : newUser.getPlaylists()) {
                        System.out.println(i + ". " + list.getName());
                        i++;
                    }
                    int listChoice = sc.nextInt();
                    // Find the user's choice by index (get(listChoice)) from the users playlist
                    playlist = newUser.getPlaylists().get(listChoice);
                    // System.out.println(playlist.getName()); // Test

                    // Prompt the user to choose a song from the available songs
                    System.out.println("Choose a song to add: ");
                    int x = 0;
                    // For each song in the availableSongs ArrayList, print the corresponding index number and song title
                    for (Song song : availableSongs) {
                        System.out.println(x + ". " + song.getTitle());
                        x++;
                    }
                    int numChoice = sc.nextInt(); // Get input
                    Song songChoice = availableSongs.get(numChoice);
//                playlist.addSong(songChoice);  // silly me used this rather than the addSongToPlaylist() method
                    // Add the song to the playlist
                    newUser.addSongToPlaylist(playlist, songChoice);
                    playlist.playAllSongs(); // Play all songs in the playlist to test whether it updates correctly
                } else {
                    System.out.println("You haven't created any playlists yet.");
                }
            } else if (choice == 3) { // Remove a playlist
                if ((!(newUser.getPlaylists().isEmpty()))) {
                    // Prompt the user to choose which playlist to remove
                    System.out.println("Which playlist would you like to remove?");
                    int i = 0;
                    // For each plalist object in the user's list of playlists, print out the index and playlist name
                    for (Playlist list : newUser.getPlaylists()) {
                        System.out.println(i + ". " + list.getName());
                        i++;
                    }
                    int listChoice = sc.nextInt(); // Get input
                    // Create a playlist object to represent the user's choice
                    Playlist userChoice = newUser.getPlaylists().get(listChoice);

                    System.out.println("Are you sure you want to delete " + userChoice.getName() + "? (Y/N)");
                    String yN = sc.next(); // Get input on yes or no
                    if (yN.equals("Y") || yN.equals("y")) { // Yes delete
                        newUser.deletePlaylist(userChoice); // Delete the playlist
                        System.out.println(userChoice.getName() + " has been deleted.");
                    } else if (yN.equals("N") || yN.equals("n")) { // No, do not delete
                        System.out.println("You did not delete " + userChoice.getName());
                    } else { // To handle incorrect input
                        System.out.println("That response was not recognized. \nReturning to menu...");
                    }
                } else {
                    System.out.println("There are no playlists to remove.");
                }

            } else if (choice == 4) { // Remove a song from a playlist
                if ((!(newUser.getPlaylists().isEmpty()))) {
                    // Prompt the user to choose a playlist they would like to delete a song from
                    System.out.println("What playlist would you like to remove a song from?");
                    int i = 0;
                    // For each playlist object in the user's playlists, print the index number and the playlist's name
                    for (Playlist list : newUser.getPlaylists()) {
                        System.out.println(i + ". " + list.getName());
                        i++;
                    }
                    int listChoice = sc.nextInt(); // Get input
                    // Assign the user's choice to a playlist object
                    playlist = newUser.getPlaylists().get(listChoice);
                    // System.out.println(playlist.getName());
                    System.out.println("Choose a song to remove: ");
                    int x = 0;
                    // For each song in the playlist's list of songs, print out the index number and song title
                    for (Song song : playlist.getSongs()) {
                        System.out.println(x + ". " + song.getTitle());
                        x++;
                    }
                    int numChoice = sc.nextInt(); // Get user input
                    // Assign the chosen song to a song object
                    Song songChoice = playlist.getSongs().get(numChoice);
                    System.out.println(songChoice.getTitle());
//                playlist.removeSong(songChoice); // Again, used the wrong method to remove song
                    System.out.println("Are you sure you want to delete " + songChoice.getTitle() + "? (Y/N)");
                    String yN = sc.next(); // Get input on yes or no
                    if (yN.equals("Y") || yN.equals("y")) { // Yes delete
                        // Remove the song from the playlist
                        newUser.removeSongFromPlaylist(playlist, songChoice);
                        playlist.playAllSongs(); // Test, play songs to make sure song was deleted
                    } else if (yN.equals("N") || yN.equals("n")) {
                        System.out.println("You did not delete " + songChoice.getTitle());
                    } else { // To handle incorrect input
                        System.out.println("That response was not recognized. \nReturning to menu...");
                    }
                } else {
                    System.out.println("There are no playlists to remove a song from.");
                }
            } else if (choice == 5) {
                if (!(newUser.getPlaylists().isEmpty())) {
                    int i = 0;
                    // For each playlist object in the users' list of playlists, print out a number that corresponds to the name of the playlist
                    for (Playlist list : newUser.getPlaylists()) {
                        System.out.println(i + ". " + list.getName());
                        i++;
                    }
                    int listChoice = sc.nextInt();
                    // Find the user's choice by index (get(listChoice)) from the users playlist
                    playlist = newUser.getPlaylists().get(listChoice);
                    playlist.playAllSongs();
                } else {
                    System.out.println("Please create a playlist to listen to.");
                }

            }
            // Display the menu to the user again
            System.out.println("----------------------------------------------");
            System.out.println("* " + newUser.getUsername() + "'s Menu *");
            System.out.println("----------------------------------------------");
            System.out.println("1. Create a new playlist.\n2. Add a song to a playlist.\n3. Remove a playlist.\n" +
                    "4. Remove a song from a playlist.\n5. Play all songs\n0.Quit");
            System.out.println("----------------------------------------------");
            choice = sc.nextInt(); // Prompt them to choose another menu option or to exit the application
        }
        System.out.println("Thank you for using !Spotify.\nExiting...\nGoodbye.");


    }
}
