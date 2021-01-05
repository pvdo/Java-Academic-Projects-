/**********************************************
Workshop 7 - task 1
Course: JAC444 - 4th Semester
Last Name: Do Carmo Saraiva Teixeira
First Name: Pedro Vitor
ID: 100036193
Section: NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Date: November 16, 2020
**********************************************/
package application;
	
import java.util.ArrayList;
import java.util.Collections;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class BabyRaking2 extends Application {
	

	
	@Override
	public void start(Stage primaryStage) throws Exception{
			
		ArrayList<String> equalNameList = new ArrayList<String>();
		ArrayList<String> allNamesList = new ArrayList<String>();
			
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
			
			//BUTTON PANE
			Button submitBtn = new Button ("Submit");
			Button exitBtn = new Button ("Exit");

			Button arrayBtn [] = {submitBtn, exitBtn};
			
			for(int i = 0; i < arrayBtn.length; i++) {
				arrayBtn[i].setPrefSize(80, 20);
			}
			
			btnPane.getChildren().addAll(submitBtn, exitBtn); 
			btnPane.setAlignment(Pos.BASELINE_CENTER);

			

			
			
			//--------------SECOND SCREEN: List Of Equals Names--------------------//

			VBox vSecondPane = new VBox();
			HBox infoPane = new HBox(10);
			ScrollPane namesPane = new ScrollPane();
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
			
			//NAME SCROLLPANE
			
			Label nameListLabel = new Label();
			nameListLabel.setPrefWidth(300);
			namesPane.setContent(nameListLabel);
			
			
			//QUESTION PANE
			Label questionLabel = new Label("Do you want to search another name or see the sorted list?");
			questionLabel.setPrefWidth(300);
			
			
			questionPane.setAlignment(Pos.BASELINE_LEFT);
			questionPane.getChildren().add(questionLabel);
			
			
			//BUTTON PANE
			Button yesBtn = new Button ("Yes");
			Button noBtn = new Button ("No");
			Button sortedListBtn = new Button ("Sorted List");

			Button ynBtn [] = {yesBtn, noBtn, sortedListBtn};
			
			for(int i = 0; i < ynBtn.length; i++) {
				ynBtn[i].setPrefSize(80, 20);
			}
			
			yesNoPane.getChildren().addAll(yesBtn, noBtn, sortedListBtn); 
			yesNoPane.setAlignment(Pos.BASELINE_CENTER);
			
			//--------------THIRD SCREEN: List of All Names sorted, Excluding the Duplicates--------------------//
			
			VBox vThirdPane = new VBox();
			HBox sortPane= new HBox(10);
			ScrollPane allNamesPane = new ScrollPane();
			
			//Info Pane
			
			Label sortLabel = new Label();
			sortLabel.setPrefWidth(300);
			
			
			sortLabel.setAlignment(Pos.BASELINE_LEFT);
			sortPane.getChildren().add(sortLabel);
			
			//NAME SCROLLPANE
			
			Label allNamesListLabel = new Label();
			allNamesListLabel.setPrefWidth(300);
			allNamesPane.setContent(allNamesListLabel);
			

			
			//////////////////////
			
			vPane.getChildren().addAll(yearPane, genderPane, namePane, btnPane);
			Scene scene = new Scene(vPane, 350, 200);
			primaryStage.setTitle("Baby Ranking");

			
			vSecondPane.getChildren().addAll(infoPane, namesPane, questionPane, yesNoPane);
			Scene sceneTwo = new Scene(vSecondPane, 350, 600);
			
			vThirdPane.getChildren().addAll(sortPane, allNamesPane);
			Scene sceneThree = new Scene(vThirdPane, 350, 600);
			
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
							
							ArrayList<String> boysList = new ArrayList<String>();
							ArrayList<String> girlsList = new ArrayList<String>();
							int equalNameCounter = 0;
							String result;
							String list = "";

							
							while((lineString = raf.readLine()) != null)
							{							
								
								String [] listString = lineString.split("\t");
								
								boysList.add(listString[1].trim());
								girlsList.add(listString[3].trim());								
	
							}
							
							for(String boysName : boysList) {
								
								if(!allNamesList.contains(boysName)) {
									allNamesList.add(boysName);
								}
								
								for(String girlsName : girlsList) {
									
									if(!allNamesList.contains(girlsName)) {
										allNamesList.add(girlsName);
									}
									if(boysName.equals(girlsName)) {
										equalNameList.add(girlsName);
										equalNameCounter ++;

											
										}
									}
							}
							
							
							result = equalNameCounter + "  names used for both genders of " + yearField.getText() + "\n";
							int count = 1;
							for (String name : equalNameList){
								list += String.valueOf(count) + ')' + name + '\n';
								count++;
							};
							infoLabel.setText(result);
							nameListLabel.setText(list);

							
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
			sortedListBtn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					
					String list = "";
					
					Collections.sort(allNamesList);
					int count = 1;
					for (String name : allNamesList){
						list += String.valueOf(count) + ')' + name + '\n';
						count++;
					};
					sortLabel.setText("List of all names, excluding duplicates of year " + yearField.getText() + "\n");
					allNamesListLabel.setText(list);
					
					
					primaryStage.setScene(sceneThree);

				}
				
			});
			
			yesBtn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					
					yearField.clear();
					equalNameList.removeAll(equalNameList);
					allNamesList.removeAll(allNamesList);
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
