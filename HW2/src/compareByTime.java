import java.util.Comparator;

public class compareByTime implements Comparator<Playable> {

	@Override
	public int compare(Playable o1, Playable o2) {
		return o1.getPlayTimeSeconds() - o2.getPlayTimeSeconds();
	}


}
