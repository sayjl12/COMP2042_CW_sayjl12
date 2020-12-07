package p4_group_8_repo;

import java.util.Comparator;

/**
 * This class compare scores.
 * 
 * @author User
 *
 */
public class ScoreComparator implements Comparator<Score> {
	
	/**
	 * Comparing the scores and return a boolean message in integer.
	 * 
	 * @return boolean message in integer
	 */
	public int compare(Score score1, Score score2) {
		int s1 = score1.getScore();
		int s2 = score2.getScore();
		
		if (s1 > s2) {
			return -1;
		}else if (s1 < s2) {
			return 1;
		}else {
			return 0;
		}
	}

}
