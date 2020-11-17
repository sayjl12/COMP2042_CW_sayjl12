package p4_group_8_repo;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class InfoLabel extends Label {
	public InfoLabel(String text) {
		setText(text);
		setWrapText(true);
		setFont(new Font("Berlin Sans FB",18));
	}

	public InfoLabel(int i) {
		String intString = Integer.toString(i);
		setText(intString);
		setWrapText(true);
		setFont(new Font("Berlin Sans FB",18));
		setPrefWidth(25);
	}
	
}
