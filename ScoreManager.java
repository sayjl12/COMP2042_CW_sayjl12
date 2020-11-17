package p4_group_8_repo;

import java.util.*;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.*;

public class ScoreManager {
	private ArrayList<Score> scores;
	
	private static final String ScoreFile = "scores.dat";
	
	ObjectOutputStream outputStream = null;
	ObjectInputStream inputStream = null;
	
	public ScoreManager() {
		scores = new ArrayList<Score>();
	}
	
	public ArrayList<Score> getScores(){
		loadScoreFile();
		sort();
		return scores;
	}
	
	private void sort() {
		ScoreComparator comparator = new ScoreComparator();
		Collections.sort(scores,comparator);
	}
	
	public void addScore(String name, int score) {
		loadScoreFile();
		scores.add(new Score(name,score));
		updateScoreFile();
	}
	
	public void loadScoreFile() {
		try {
			inputStream = new ObjectInputStream(new FileInputStream(ScoreFile));
			scores = (ArrayList<Score>) inputStream.readObject();
		}catch (FileNotFoundException e) {
			System.out.println("[Load] FNF Error: "+e.getMessage());
		}catch (IOException e) {
			System.out.println("[Load] IO Error: "+e.getMessage());
		}catch (ClassNotFoundException e) {
			System.out.println("[Load] CNF Error: "+e.getMessage());
		}finally {
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			}catch (IOException e) {
				System.out.println("[Load] IO Error: "+e.getMessage());
			}
		}
	} 
	
	public void updateScoreFile() {
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(ScoreFile));
			outputStream.writeObject(scores);
		}catch (FileNotFoundException e) {
			System.out.println("[Update] FNF Error: "+e.getMessage());
		}catch (IOException e) {
			System.out.println("[Update] IO Error: "+e.getMessage());
		}finally {
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			}catch (IOException e) {
				System.out.println("[Update] IO Error: "+e.getMessage());
			}
		}
	}
	
	public VBox getHighscoreString() {
      
        int max = 10;

        ArrayList<Score> scores;
        scores = getScores();

        int i=0;
        int x = scores.size();
        if (x > max) {
            x = max;
        }
        VBox vbox = new VBox(3);
        vbox.setLayoutX(60);
        vbox.setLayoutY(70);
        
        InfoLabel rankTitle = new InfoLabel("Rank");
        rankTitle.setPrefWidth(60);
        InfoLabel nameTitle = new InfoLabel("Name");
        nameTitle.setPrefWidth(200);
        InfoLabel scoreTitle = new InfoLabel("Score");
        scoreTitle.setPrefWidth(100);
        
        HBox hboxtitle = new HBox();
        hboxtitle.getChildren().addAll(rankTitle,nameTitle,scoreTitle);
        hboxtitle.setPrefHeight(30);
        
        vbox.getChildren().add(hboxtitle);
        for (i=0;i<x;i++) {
        	HBox hbox = new HBox();
        	InfoLabel rank = new InfoLabel(i+1+".");
        	rank.setPrefWidth(60);
        	InfoLabel name = new InfoLabel(scores.get(i).getName());
        	name.setPrefWidth(200);
        	InfoLabel score = new InfoLabel(scores.get(i).getScore());
        	score.setPrefWidth(100);
        	hbox.getChildren().addAll(rank,name,score);  
        	
        	vbox.getChildren().add(hbox);
        }
        
       
        return vbox;
	}
	
}
