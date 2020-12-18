package p4_group_8_repo;

import java.util.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.*;

/**
 * This class manage the score in array list, read and write the score from or into the file.
 * @author User
 *
 */
public class ScoreManager {
	private ArrayList<Score> scores;
	
	private static final String ScoreFile = "scores.dat";
	
	ObjectOutputStream outputStream = null;
	ObjectInputStream inputStream = null;
	
	/**
	 * Class constructor.
	 * Set a new array list for Score.
	 */
	public ScoreManager() {
		scores = new ArrayList<Score>();
	}
	
	/**
	 * Access to the scores list.
	 * 
	 * @return the scores list after sorted.
	 */
	public ArrayList<Score> getScores(){
		loadScoreFile();
		sort();
		return scores;
	}
	
	/**
	 * Sort the score list in ascending order.
	 */
	private void sort() {
		ScoreComparator comparator = new ScoreComparator();
		Collections.sort(scores,comparator);
	}
	
	/**
	 * Add a new score into the score file.
	 * 
	 * @param name player's name
	 * @param score player's score
	 */
	public void addScore(String name, int score) {
		loadScoreFile();
		scores.add(new Score(name,score));
		updateScoreFile();
	}
	
	/**
	 * Read a score file and load it into score array list.
	 */
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
	
	/**
	 * Write a new score into the score file.
	 * 
	 */
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
	
	/**
	 * Access to the score list and output it as a vbox.
	 * @return information of the score in vbox
	 */
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
