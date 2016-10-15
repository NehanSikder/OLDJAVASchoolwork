
//Arham Sikder Ans2ur, Lab section 103, HW 1
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PlayList {

	/** Fields **/
	private String name; // contains the name of the playlist
	private ArrayList<Song> songList; // ArrayList of songs that make up the
										// play list

	/** Constructor 1 **/
	public PlayList() {
		this.name = "Untitled";
		songList = new ArrayList<Song>();
	}

	/** Constructor 2 **/
	public PlayList(String newName) {
		this.name = newName;
		songList = new ArrayList<Song>();
	}

	/** Gets name of the playlist **/
	public String getName() {
		return name;
	}

	/** Sets the name of the playlist **/
	public void setName(String name) {
		this.name = name;
	}

	/** Gets returns the arraylist songlist **/
	public ArrayList<Song> getSongList() {
		return songList;
	}

	/** Sets the arraylist songlist **/
	public void setSongList(ArrayList<Song> songList) {
		this.songList = songList;
	}

	/**
	 * Loads information from a text file, creates songs based from the
	 * information and creates a playlist and adds created songs to the playlist
	 **/
	public boolean loadSongs(String fileName) throws FileNotFoundException {
		File x = new File(fileName);
		this.name = fileName;
		Scanner reader = new Scanner(x);
		ArrayList<String> line = new ArrayList<String>();
		ArrayList<String> title = new ArrayList<String>();
		ArrayList<String> artist = new ArrayList<String>();
		ArrayList<String> time = new ArrayList<String>();
		boolean output = false;
		while (reader.hasNextLine()) {
			String l = reader.nextLine().trim();
			line.add(l);
		}
		for (int i = 3; i < line.size() - 1; i += 3) {
			if (!line.isEmpty() && line.get(i).contains("")) {
				Song s = new Song(line.get(1), line.get(0));
				this.songList.add(s);
				output = true;
			}
		}
		for (int i = 0; i < line.size() - 1; i += 4) {
			title.add(line.get(i));
		}
		for (int i = 1; i < line.size() - 1; i += 4) {
			artist.add(line.get(i));
		}
		for (int i = 2; i < line.size() - 1; i += 4) {
			time.add((line.get(i)));
		}

		for (int i = 0; i < songList.size() - 1; i++) {
			songList.get(i).setArtist(artist.get(i));
			songList.get(i).setTitle(title.get(i));
			songList.get(i).setMinutes(Character.getNumericValue((time.get(i).charAt(0))));
		}

		/** add minutes to the last song on playlist **/
		/**
		 * the loop keeps giving 0 so this is a precaution to ensure that the
		 * correct numbers get picked
		 **/
		songList.get(songList.size() - 1).setMinutes(Character.getNumericValue((time.get(time.size() - 1).charAt(0))));

		for (int i = 0; i < songList.size() - 1; i++) {
			if (time.get(i).substring(2).length() <= 2) {
				songList.get(i).setSeconds(Integer.parseInt(time.get(i).substring(2)));
			} else {
				int sec = Integer.parseInt(time.get(i).substring(2));
				songList.get(i).setSeconds(sec % 60);
				songList.get(i).setMinutes(songList.get(i).getMinutes() + sec / 60);
			}
		}

		/** add proper minutes and second to the last song on playlist **/
		/**
		 * the loop keeps giving 0 so this is a precaution to ensure that the
		 * correct numbers get picked
		 **/
		if (time.get(time.size() - 1).substring(2).length() <= 2) {
			songList.get(songList.size() - 1).setSeconds(Integer.parseInt(time.get(time.size() - 1).substring(2)));
		} else {
			int sec = Integer.parseInt(time.get(time.size() - 1).substring(2));
			songList.get(songList.size() - 1).setSeconds(sec % 60);
			songList.get(songList.size() - 1).setMinutes(songList.get(songList.size() - 1).getMinutes() + sec / 60);
		}
		return output;

	}

	/** Test to see if it works **/
	public boolean clear() {
		/** removes all songs **/
		if (!this.songList.isEmpty()) {
			this.songList.clear();
			return true;
		}
		return false;
	}

	public boolean addSong(Song s) {
		/** adds Song s to the end of the play list **/
		this.songList.add(this.songList.size(), s);
		return true;
	}

	public Song removeSong(int index) {
		/** removes Song at index from the list and returns it **/
		Song output = null;
		//try {
			// if (!this.songList.isEmpty()) {
			output = this.songList.get(index);
			this.songList.remove(index);
			// }
		//} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index has to be greater than 0");
		//} catch (IndexOutOfBoundsException e) {
			System.out.println("Playlist is empty");
		//}
		return output;
	}

	public Song removeSong(Song s) {
		/** removes every occurrence of Song s from the list and returns s **/
		if (this.songList.contains(s)) {
			this.songList.removeAll(Collections.singleton(s));
		}
		return s;
	}

	/** gets song from specific index of songlist **/
	public Song getSong(int index) {
		return this.songList.get(index);

	}

	/** plays every song in songlist **/
	public void play() {
		for (int i = 0; i < this.songList.size() - 1; i++) {
			this.songList.get(i).play();
		}
	}

	/** returns the number of songs in the playlist **/
	public int size() {
		return this.songList.size();
	}

	public static void main(String[] args) {
		PlayList x = new PlayList();
		x.removeSong(0);
	}

}
