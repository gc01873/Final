
package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

//import Home.MYPlayer;
import Home.Playlist;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

public class AlbumViewerController implements Initializable {

	public void MenuScreen(ActionEvent event) throws IOException{
		Parent MenuView = FXMLLoader.load(getClass().getResource("MenuViewer.fxml"));
		Scene MenuScene = new Scene(MenuView);
		Stage Window = (Stage)((Node)event.getSource()).getScene().getWindow();
		Window.setScene(MenuScene);
		Window.show();
	}
	public ObservableList<String> list = FXCollections.observableArrayList();
	@FXML 
	public  ListView <String>AlbumsListBox;
	public ArrayList<String> Albums = Main.itunes.displayAlbums();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

loadData();
	}

	public  void loadData() {
		list.removeAll(list);
		list.addAll(Albums);
		AlbumsListBox.getItems().addAll(list);

	}
	
	public void playAlbum(MouseEvent event) throws InterruptedException  {
		String Guy = AlbumsListBox.getSelectionModel().getSelectedItem();
		
			//Main.itunes.playStream(Main.itunes.AlbumMap.get(Guy));
			//MYPlayer.playStreamer(Main.itunes.AlbumMap.get(Guy));
		
	}
	
	
	}





