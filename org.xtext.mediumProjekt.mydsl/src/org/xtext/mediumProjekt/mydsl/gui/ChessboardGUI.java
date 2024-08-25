package org.xtext.mediumProjekt.mydsl.gui;




import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ChessboardGUI extends Application{

	//Hauptfenster
	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane schachbrett = new GridPane();
		schachbrett.setAlignment(Pos.CENTER);
		String[] spalten = {"A", "B", "C", "D", "E", "F", "G", "H"};
		Random zufall = new Random();
		List<String> freiePlaetze = new ArrayList<>();
		
		Color lightBrown = Color.web("#F0D9B5");
        Color darkBrown = Color.web("#B58863");
		
		// Alle möglichen SchachbrettPositionen außer A1
		 for (int reihe = 1; reihe <= 8; reihe++) {
	            for (int spalte = 0; spalte < 8; spalte++) {
	                String position = spalten[spalte] + reihe;
	                if (!position.equals("A1")) {  // A1 auslassen
	                    freiePlaetze.add(position);
	                }
	            }
	        }
		 
		// 5 Hindernisse auf zufälligen Positionen 
	        List<String> hindernisse = new ArrayList<>();
	        for (int i = 0; i < 10; i++) {
	            int index = zufall.nextInt(freiePlaetze.size());
	            hindernisse.add(freiePlaetze.remove(index)); // Platz belegen und aus der Liste entfernen
	            System.out.println("Hindernis auf Position: "+ hindernisse);
	        }
	        
	        for (int reihe = 0; reihe < 8; reihe++) {
	            for (int spalte = 0; spalte < 8; spalte++) {
	                // Erstellen und Färben der Felder
	                Rectangle feld = new Rectangle(100, 100);
	                feld.setFill((reihe + spalte) % 2 == 0 ? lightBrown : darkBrown);
	                schachbrett.add(feld, spalte, reihe);  // Felder ohne Randbeschriftung

	                // Hinzufügen der Beschriftung auf den Feldern
	                String position = spalten[spalte] + (8 - reihe);  // Korrekte Positionierung der Beschriftungen
	                Label beschriftung = new Label(position);
	                beschriftung.setTextFill(Color.BLACK);
	                beschriftung.setMinSize(50, 50);
	                beschriftung.setAlignment(Pos.CENTER);
	                schachbrett.add(beschriftung, spalte, reihe);
	                GridPane.setHalignment(beschriftung, HPos.CENTER);
	                GridPane.setValignment(beschriftung, VPos.CENTER);

	                // Hinzufügen des Hindernisses, falls diese Position ein Hindernis hat
	                if (hindernisse.contains(position)) {
	                    Circle hindernis = new Circle(30, Color.RED);
	                    schachbrett.add(hindernis, spalte, reihe);
	                    GridPane.setHalignment(hindernis, HPos.CENTER);
	                    GridPane.setValignment(hindernis, VPos.CENTER);
	                }
	            }
	        }
	        
	        // R2D2 startet bei A1
	        Image r2d2 = new Image(getClass().getResourceAsStream("/r2d2.png"));
	        ImageView r2d2View = new ImageView(r2d2);
	        r2d2View.setFitWidth(100);
	        r2d2View.setFitHeight(100);
	        schachbrett.add(r2d2View, 0, 7);
		
		// Roboter und Hindernisse
		Scene szene = new Scene(schachbrett, 1000, 1000);
		primaryStage.setScene(szene);
		primaryStage.show();
	}

	
	public static void main(String[]args) {
		launch(args);
	}
}
