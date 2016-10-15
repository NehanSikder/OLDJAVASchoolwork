import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class practice2 {

	public static void main(String[] args) throws FileNotFoundException {
		File x = new File("SongList");
		Scanner reader = new Scanner(x);
		ArrayList <String> line = new ArrayList<String>();
		ArrayList <Song> playList = new ArrayList<Song>();
		ArrayList<String> title = new ArrayList<String>();
		ArrayList<String> artist = new ArrayList<String>();
		ArrayList<String> time = new ArrayList<String>();

		while(reader.hasNextLine()){
			String l = reader.nextLine().trim();
			line.add(l);
		}
		for (int i = 3; i < line.size()-1; i +=3){
			if(!line.isEmpty() && line.get(i).contains("")){
				Song s = new Song(line.get(1), line.get(0));
				playList.add(s);
			}
		}
		
		for (int i = 0; i < line.size()-1; i +=4){
			title.add(line.get(i));
		}
		
		for (int i = 1; i < line.size()-1; i +=4){
			artist.add(line.get(i));
		}
		
		for (int i = 2; i < line.size()-1; i +=4){
			time.add((line.get(i)));
		}
		
		for (int i = 0; i < playList.size()-1; i ++){
			playList.get(i).setArtist(artist.get(i));
			playList.get(i).setTitle(title.get(i));
			playList.get(i).setMinutes(Character.getNumericValue((time.get(i).charAt(0))));
		}
		
		//add minutes to the last song on playlist
		//the loop keeps giving 0 so this is a precaution to ensure that the correct numbers get picked
		playList.get(playList.size()-1).setMinutes(Character.getNumericValue((time.get(time.size()-1).charAt(0))));
	
		for (int i = 0; i < playList.size()-1; i ++){
			if(time.get(i).substring(2).length() <= 2){
				playList.get(i).setSeconds(Integer.parseInt(time.get(i).substring(2)));
			} else {
				int sec = Integer.parseInt(time.get(i).substring(2));
				playList.get(i).setSeconds(sec%60);
				playList.get(i).setMinutes(playList.get(i).getMinutes() + sec/60);
			}
		}
		
		//add proper minutes and second to the last song on playlist
		//the loop keeps giving 0 so this is a precaution to ensure that the correct numbers get picked
		if(time.get(time.size()-1).substring(2).length() <= 2){
			playList.get(playList.size()-1).setSeconds(Integer.parseInt(time.get(time.size()-1).substring(2)));
		} else {
			int sec = Integer.parseInt(time.get(time.size()-1).substring(2));
			playList.get(playList.size()-1).setSeconds(sec%60);
			playList.get(playList.size()-1).setMinutes(playList.get(playList.size()-1).getMinutes() + sec/60);
		}
			
		}



}
