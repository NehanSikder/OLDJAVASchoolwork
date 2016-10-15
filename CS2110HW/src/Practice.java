import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Practice {

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
			char min =(time.get(i).charAt(0));
			playList.get(i).setMinutes(Character.getNumericValue(min));
		}
			System.out.println(time.toString());
			
		}

}
