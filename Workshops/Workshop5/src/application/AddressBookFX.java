/**********************************************
Workshop 5
Course: JAC444 - 4th Semester
Last Name: Do Carmo Saraiva Teixeira
First Name: Pedro Vitor
ID: 100036193
Section: NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: October 26, 2020
**********************************************/

package application;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddressBookFX extends Application{
	static long pos;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		VBox vPane = new VBox();
		HBox fNameHPane = new HBox(10);
		HBox lNameHPane = new HBox(10);
		HBox addressHPane = new HBox(15);
		HBox btnHPane = new HBox(10);
		HBox hBoxArray [] = {fNameHPane, lNameHPane, addressHPane, btnHPane};
		Insets marginSets = new Insets(10,20,10,20);
		
		
		//HBOX PRESETS
		for(int i = 0; i < hBoxArray.length; i++) 
			VBox.setMargin(hBoxArray[i], marginSets);
		
		//FIRST NAME PANE
		Label fnameLabel = new Label("First Name:");
		TextField fnameField = new TextField();
		fnameField.setPrefSize(450, 20);
		
		
		fNameHPane.setAlignment(Pos.BASELINE_CENTER);
		fNameHPane.getChildren().addAll(fnameLabel, fnameField);
		
		
		//LAST NAME PANE
		Label lnameLabel = new Label("Last Name:");
		TextField lnameField = new TextField();
		lnameField.setPrefSize(450, 20);
		
		lNameHPane.setAlignment(Pos.BASELINE_CENTER);
		lNameHPane.getChildren().addAll(lnameLabel, lnameField);
		
		//ADDRESS PANE
		
		Label cityLabel = new Label("City:");
		TextField cityField = new TextField();
		cityField.setPrefSize(100, 20);
		
		String provinces [] = {"AB", "BC", "MB", "NB", "NL", "NS", "ON", "PE", "QC", "SK"};
		Label provinceLabel = new Label("Province:");
		ChoiceBox<String> provinceChoice = new ChoiceBox<String>(FXCollections.observableArrayList(provinces));
		provinceChoice.setPrefSize(100, 20);
		
		
		Label postalLabel = new Label("Postal Code:");
		TextField postalField = new TextField();
		postalField.setPrefSize(100, 20);
		
		addressHPane.setAlignment(Pos.BASELINE_CENTER);
		addressHPane.getChildren().addAll(cityLabel, cityField, provinceLabel, provinceChoice, postalLabel, postalField);
		
		
		//BUTTON PANE
		Button addBtn = new Button ("Add");
		Button firstBtn = new Button ("First");
		Button nextBtn = new Button ("Next");
		Button previousBtn = new Button ("Previous");
		Button lastBtn = new Button ("Last");
		Button updateBtn = new Button ("Update");
		Button arrayBtn [] = {addBtn, firstBtn, nextBtn, previousBtn, lastBtn, updateBtn};
		
		for(int i = 0; i < arrayBtn.length; i++) {
			arrayBtn[i].setPrefSize(80, 20);
		}
		
		btnHPane.getChildren().addAll(addBtn, firstBtn, nextBtn, previousBtn, lastBtn, updateBtn); 
		btnHPane.setAlignment(Pos.BASELINE_CENTER);
		
		//EVENTS HANDLERS
		File file = new File("addressBook.txt");
		
		
		addBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				try(RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw")){
					
					//position: end of the current line
					
					addInfo(randomAccessFile, randomAccessFile.length(), fnameField, lnameField, cityField, provinceChoice, postalField);

				}catch(Exception e) {
					System.out.println("Add function Error");
				}
				System.out.println("Add button was clicked");
				
			}
			
		});
		firstBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				try(RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r")){
					
					//position: begin of the file
						
					retriveInfo(randomAccessFile, 0, fnameField, lnameField, cityField, provinceChoice, postalField);

				}catch(Exception e) {
					System.out.println("First Error" + e);
				}
				
				
			}
			
		});
		nextBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				try(RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r")){
					
					//position: begin of the current line
					
					retriveInfo(randomAccessFile, pos, fnameField, lnameField, cityField, provinceChoice, postalField);
					
				}catch(Exception e) {
					System.out.println("Next Error" + e);
				}
				
			}
			
		});
		previousBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				try(RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r")){
					
					//position: begin of the previous line
					
					retriveInfo(randomAccessFile, (pos - (111*2)), fnameField, lnameField, cityField, provinceChoice, postalField);
					
				}catch(Exception e) {
					System.out.println("Previous Error" + e);
				}
				
			}
			
		});
	
		lastBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				try(RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r")){
					
					//position: begin of last line
					
					retriveInfo(randomAccessFile, randomAccessFile.length() - 111, fnameField, lnameField, cityField, provinceChoice, postalField);
					
				}catch(Exception e) {
					System.out.println("Last Error" + e);
				}
				
			}
			
		});

		updateBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				try(RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw")){
					
					//position: begin of the current line
					
					addInfo(randomAccessFile, (pos - 111), fnameField, lnameField, cityField, provinceChoice, postalField);

				}catch(Exception e) {
					System.out.println("Update Error" + e);
				}
				
			}
			
		});
		
		
		vPane.getChildren().addAll(fNameHPane, lNameHPane, addressHPane, btnHPane);
		Scene scene = new Scene(vPane, 600, 200);
		primaryStage.setTitle("Address Book");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	public static void main (String [] args) {
		launch();
	}
	
	public void retriveInfo(RandomAccessFile raf, long position, TextField fnameField, 
			TextField lnameField, TextField cityField, ChoiceBox provinceChoice, TextField postalField) throws IOException {
			//111
			
		raf.seek(position);
	
		String firstLine = raf.readLine();
		System.out.println(firstLine);
		
		String [] first = firstLine.split("/");
		fnameField.setText(first[0].substring(12).trim());
		lnameField.setText(first[1].substring(11).trim());
		cityField.setText(first[2].substring(6).trim());
		provinceChoice.setValue(first[3].substring(10).trim());
		postalField.setText(first[4].substring(12).trim());
			
		pos = raf.getFilePointer();
		
	}
	
	public void addInfo(RandomAccessFile raf, long position, TextField fnameField, 
			TextField lnameField, TextField cityField, ChoiceBox provinceChoice, TextField postalField) throws IOException {
	
		//Go to the end of the file
		raf.seek(position);		
//		//Add info
		raf.writeBytes("First Name: " + String.format("%-12s", fnameField.getText())
				+ "/Last Name: " + String.format("%-12s", lnameField.getText())
				+ "/City: " + String.format("%-12s", cityField.getText())
				+ "/Province: " + String.format("%-12s", provinceChoice.getValue())
				+ "/Postal Code: " + String.format("%-6s", postalField.getText())
				+"\n");
		
		pos = raf.getFilePointer();
			
	}
	
}
