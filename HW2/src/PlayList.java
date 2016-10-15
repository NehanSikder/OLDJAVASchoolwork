import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Scott Miller (smm7cb) Homework 1 Lab section 103
 **/

public class PlayList implements Playable {

	protected String name;
	protected ArrayList<Playable> playableList = new ArrayList<Playable>();

	public PlayList() {
		/** Making the name of the String "Untitled" **/
		this.name = "Untitled";

	}

	public PlayList(String newName) {
		/** Assigning the name to be that of "newName" **/
		this.name = newName;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Playable> getPlayableList() {
		return playableList;
	}

	public void setPlayableList(ArrayList<Playable> playableList) {
		this.playableList = playableList;
	}

	public boolean loadSongs(String filename) {
		/** Read and load songs from some text file **/

		try (Scanner fileScanner = new Scanner(new File(filename))) {
			while (fileScanner.hasNext()) {
				String title = fileScanner.nextLine().trim();
				String artist = fileScanner.nextLine().trim();
				String time = fileScanner.nextLine().trim();
				String[] timeSplit = time.split(":");
				int minutes = Integer.parseInt(timeSplit[0]) / 60;
				int seconds = Integer.parseInt(timeSplit[1]) % 60;
				fileScanner.nextLine(); // empty line

				Song newOne = new Song(artist, title, minutes, seconds);
				this.addSong(newOne);
			}
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found");
			return false;
		} catch (NoSuchElementException e) {
			System.out.println("The file is not formatted correctly");
			return false;
		}
	}

	public boolean clear() {
		/**
		 * This method clears everything from the ArrayList, and returns which
		 * ones were cleared
		 **/
		return (playableList.removeAll(playableList));
	}

	public boolean addSong(Song s) {
		/** Adding an individual song to the ArrayList, and returns that song **/
		this.playableList.add(this.playableList.size(), s);
		return true;
	}

	public boolean addPlayList(Playable pl) {
		if (this.playableList.contains(pl)) {
			return false;
		} else {
			this.playableList.add(pl);
			return true;
		}
	}

	public Playable getPlayable(int index) {
		return this.playableList.get(index);
	}

	public void play() {
		/** Play the songs that are contained in the ArrayList **/
		for (int i = 0; i < playableList.size(); i++) {
			playableList.get(i).play();
		}
	}

	public int size() {
		/** Returns how many songs are in the "playList" **/
		return playableList.size();
	}

	public String toString() {
		/** Gives the user a readable output to print to the console or such **/
		String output = null;
		for (Playable x : this.playableList) {
			output = x.toString();
		}
		return "Playlist name: " + this.name + "Item: " + output;
	}

	public static void main(String[] args) {
		/** A testing method for the loadSongs() method **/
		PlayList example = new PlayList("testing");
		example.loadSongs("TestFile");
		System.out.println(example.getPlayableList());
	}

	public void sortByName() {
		Collections.sort(this.playableList, new compareByName());
	}

	public void sortByTime() {
		Collections.sort(this.playableList, new compareByTime());
	}

	@Override
	public int getPlayTimeSeconds() {
		int time = 0;
		for (Playable x : this.playableList) {
			time += x.getPlayTimeSeconds();
		}
		return time;
	}
}
