package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;



public class LibraryViewerController implements Initializable {
	public ObservableList<String> list = FXCollections.observableArrayList();
	@FXML 
	public  ListView <String>LibraryListBox;
	public ArrayList<String> Cancion = Main.itunes.displaySongs();

	public void MenuScreen(ActionEvent event) throws IOException{
		Parent MenuView = FXMLLoader.load(getClass().getResource("MenuViewer.fxml"));
		Scene MenuScene = new Scene(MenuView);
		Stage Window = (Stage)((Node)event.getSource()).getScene().getWindow();
		Window.setScene(MenuScene);
		Window.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
loadData();

	}
	
	public  void loadData() {
		list.removeAll(list);
		list.addAll(Cancion);
	LibraryListBox.getItems().addAll(list);

	}
	
	public void playSong(MouseEvent event) throws InterruptedException  {
		String Guy = LibraryListBox.getSelectionModel().getSelectedItem();
		
			Main.itunes.playStream(Main.itunes.AlbumMap.get(Guy));
		
		}
	
	public void playAll(MouseEvent event) throws InterruptedException  {
		Main.itunes.playStream(Main.itunes.getSongLibrary());
	}

}
