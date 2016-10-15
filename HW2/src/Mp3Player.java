import java.util.ArrayList;
import java.util.Scanner;

public class Mp3Player {

	protected PlayList memory;
	protected PlayList main;

	public Mp3Player() {
		this.memory = new PlayList("Main Playlist");
		this.main = new PlayList();
	}

	public void start() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Filename: ");
		String input = keyboard.next();
		this.main.loadSongs(input);
	}

	public static void main(String[] args) {
		Mp3Player x = new Mp3Player();
		x.start();
	}

	public PlayList getDefaultPlaylist() {
		return this.main;
	}

	public PlayList getPlaylist() {
		return this.memory;
	}

}