package p4_group_8_repo;

import java.io.Serializable;

/**
 * This class create the name and score for the user.
 * 
 * @author User
 * @see Serializable
 *
 */
public class Score implements Serializable {
	/**
	 * The player's score
	 */
	private int score;
	/**
	 * The player's name
	 */
	private String name;
	
	/**
	 * Access to the player's score.
	 * @return score
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Access to the player's name.
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Class constructor.
	 * Set the score and name of the player.
	 * 
	 * @param name player's name
	 * @param score player's score
	 */
	public Score(String name, int score) {
		this.score = score;
		this.name = name;
	}

}
