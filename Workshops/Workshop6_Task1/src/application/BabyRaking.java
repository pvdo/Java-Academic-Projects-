/**********************************************
Workshop 6
Course: JAC444 - 4th Semester
Last Name: Do Carmo Saraiva Teixeira
First Name: Pedro Vitor
ID: 100036193
Section: NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Date: November 9, 2020
**********************************************/
package application;
	
import java.io.File;
import java.io.RandomAccessFile;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class BabyRaking extends Application {
	

	
	@Override
	public void start(Stage primaryStage) throws Exception{
			

			
		//--------------FIRST SCREEN --------------------//
			
			VBox vPane = new VBox();
			HBox yearPane = new HBox(10);
			HBox genderPane = new HBox(10);
			HBox namePane = new HBox(10);
			HBox btnPane = new HBox(10);
			HBox hBoxArray [] = {yearPane, genderPane, namePane, btnPane};
			Insets marginSets = new Insets(10,20,10,20);
			
			//HBOX PRESETS
			for(int i = 0; i < hBoxArray.length; i++) 
				VBox.setMargin(hBoxArray[i], marginSets);
			
			//Year Pane
			Label yearLabel = new Label("Enter the Year:");
			TextField yearField = new TextField();
			yearLabel.setPrefWidth(100);
			yearField.setPrefSize(200, 20);
			
			
			yearPane.setAlignment(Pos.BASELINE_LEFT);
			yearPane.getChildren().addAll(yearLabel, yearField);
			
			
			//Gender Name
			String gender [] = {"M", "F"};
			Label genderLabel = new Label("Enter the Gender:");
			ChoiceBox<String> genderChoice = new ChoiceBox<String>(FXCollections.observableArrayList(gender));
			genderLabel.setPrefWidth(100);
			genderChoice.setPrefSize(50, 20);
			
			genderPane.setAlignment(Pos.BASELINE_LEFT);
			genderPane.getChildren().addAll(genderLabel, genderChoice);
			
			//Name Field
			
			Label nameLabel = new Label("Enter the Name:");
			TextField nameField = new TextField();
			nameLabel.setPrefWidth(100);
			nameField.setPrefSize(200, 20);
			
			
			namePane.setAlignment(Pos.BASELINE_LEFT);
			namePane.getChildren().addAll(nameLabel, nameField);
			
			
			//BUTTON PANE
			Button submitBtn = new Button ("Submit");
			Button exitBtn = new Button ("Exit");

			Button arrayBtn [] = {submitBtn, exitBtn};
			
			for(int i = 0; i < arrayBtn.length; i++) {
				arrayBtn[i].setPrefSize(80, 20);
			}
			
			btnPane.getChildren().addAll(submitBtn, exitBtn); 
			btnPane.setAlignment(Pos.BASELINE_CENTER);

			

			
			
			//--------------SECOND SCREEN --------------------//

			VBox vSecondPane = new VBox();
			HBox infoPane = new HBox(10);
			HBox questionPane = new HBox(10);
			HBox yesNoPane = new HBox(10);
			HBox secondBoxArray [] = {infoPane, questionPane, yesNoPane};
			
			//HBOX PRESETS
			for(int i = 0; i < secondBoxArray.length; i++) 
				VBox.setMargin(secondBoxArray[i], marginSets);
			
			//Info Pane
			
			Label infoLabel = new Label();
			infoLabel.setPrefWidth(300);
			
			
			infoPane.setAlignment(Pos.BASELINE_LEFT);
			infoPane.getChildren().add(infoLabel);
			
			
			//Gender Name
			Label questionLabel = new Label("Do you want to search another name?");
			questionLabel.setPrefWidth(300);
			
			
			questionPane.setAlignment(Pos.BASELINE_LEFT);
			questionPane.getChildren().add(questionLabel);
			
			
			//BUTTON PANE
			Button yesBtn = new Button ("Yes");
			Button noBtn = new Button ("No");

			Button ynBtn [] = {submitBtn, exitBtn};
			
			for(int i = 0; i < ynBtn.length; i++) {
				ynBtn[i].setPrefSize(80, 20);
			}
			
			yesNoPane.getChildren().addAll(yesBtn, noBtn); 
			yesNoPane.setAlignment(Pos.BASELINE_CENTER);
			
			vPane.getChildren().addAll(yearPane, genderPane, namePane, btnPane);
			Scene scene = new Scene(vPane, 350, 200);
			primaryStage.setTitle("Baby Ranking");

			
			vSecondPane.getChildren().addAll(infoPane, questionPane, yesNoPane);
			Scene sceneTwo = new Scene(vSecondPane, 350, 200);
			
			primaryStage.setScene(scene);
			
			primaryStage.show();
			
			//EVENT HANDLERS
			
			//EVENTS HANDLERS
			submitBtn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					int year = Integer.parseInt(yearField.getText());
					if(year < 2009 || year > 2018) {
						infoLabel.setText("Year must be between 2009 to 2018");
					}else {
						String file = "babynamesranking" + yearField.getText() + ".txt";
						try(RandomAccessFile raf = new RandomAccessFile(file, "rw")){
							String lineString;
							String babyName = null;
							String babyRank;
							String babyGender = null;
							
							String firstCapital = nameField.getText().trim().substring(0,1).toUpperCase();
							String stringLower = nameField.getText().substring(1,nameField.getText().length()).toLowerCase().trim();
							String fieldName = firstCapital + stringLower;
							
							while((lineString = raf.readLine()) != null)
							{							
								
								String [] listString = lineString.split("\t");
								babyRank = listString[0];
								if(genderChoice.getValue() == "M") {
									babyName  = listString[1].trim();
									
									babyGender = "Boy";
								}
								if(genderChoice.getValue() == "F") {
									babyName  = listString[3].trim();
									babyGender = "Girl";
								}
	
								String result;
								if(babyName.equals(fieldName)) {
									result = babyGender + " name " + babyName + " is ranked #" + babyRank + " in " + yearField.getText() + " year" ;
									infoLabel.setText(result);
									raf.seek(raf.length());
									
								}
								System.out.println(babyName);
	
							}
							if(!babyName.equals(fieldName)) {
								infoLabel.setText("Name Not Found");
							}
							
						
						

					}catch(Exception e) {
						System.out.println(e);
					}
				}
					primaryStage.setScene(sceneTwo);
				}
				
			});
			
			exitBtn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					
					primaryStage.close();
				}
				
			});
			
			yesBtn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					
					nameField.clear();
					yearField.clear();
					genderChoice.getSelectionModel().clearSelection();
					primaryStage.setScene(scene);

				}
				
			});
			
			noBtn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					
					primaryStage.close();


				}
				
			});
			
			


			
			

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
