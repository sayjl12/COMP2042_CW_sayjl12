package p4_group_8_repo;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * This class create texts to be implemented onto the subscene.
 * @author User
 * @see Label
 *
 */
public class InfoLabel extends Label {
	/**
	 * Class constructor with string parameter.
	 * Set font and properties of the subscene's texts.
	 * @param text words or sentences to be input into the subscene
	 */
	public InfoLabel(String text) {
		setText(text);
		setWrapText(true);
		setFont(new Font("Berlin Sans FB",18));
	}

	/**
	 * Class constructor with integer parameter.
	 * Set font and properties of the subscene's number texts.
	 * @param i numbers to be input into the subscene
	 */
	public InfoLabel(int i) {
		String intString = Integer.toString(i);
		setText(intString);
		setWrapText(true);
		setFont(new Font("Berlin Sans FB",18));
		setPrefWidth(25);
	}
	
}
