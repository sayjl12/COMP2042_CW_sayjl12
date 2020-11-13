package p4_group_8_repo;

import javafx.geometry.Insets;
import javafx.scene.control.Label;

public class InfoLabel extends Label {
	public InfoLabel(String text) {
		setPrefHeight(400);
		setPrefWidth(600);
		setPadding(new Insets(40, 40, 40, 40));
		setText(text);
		setWrapText(true);
	}
}
