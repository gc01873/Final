package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Home.Song;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class MenuViewerController implements Initializable {
	public void MenuScreen(ActionEvent event) throws IOException{
		Parent MenuView = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		Scene MenuScene = new Scene(MenuView);
		Stage Window = (Stage)((Node)event.getSource()).getScene().getWindow();
		Window.setScene(MenuScene);
		Window.show();
	}

	public void AlbumScreen(ActionEvent event) throws IOException{
		Parent MenuView = FXMLLoader.load(getClass().getResource("AlbumViewer.fxml"));
		Scene MenuScene = new Scene(MenuView);
		Stage Window = (Stage)((Node)event.getSource()).getScene().getWindow();
		Window.setScene(MenuScene);
		Window.show();
	}
	public void ArtistScreen(ActionEvent event) throws IOException{
		Parent MenuView = FXMLLoader.load(getClass().getResource("ArtistViewer.fxml"));
		Scene MenuScene = new Scene(MenuView);
		Stage Window = (Stage)((Node)event.getSource()).getScene().getWindow();
		Window.setScene(MenuScene);
	//	ArtistViewerController.loadData();
		Window.show();
	}
	
	public void LibraryScreen(ActionEvent event) throws IOException{
		Parent MenuView = FXMLLoader.load(getClass().getResource("LibraryViewer.fxml"));
		Scene MenuScene = new Scene(MenuView);
		Stage Window = (Stage)((Node)event.getSource()).getScene().getWindow();
		Window.setScene(MenuScene);
		Window.show();
	}
	public void MediaScreen(ActionEvent event) throws IOException{
		Parent MenuView = FXMLLoader.load(getClass().getResource("MediaPlayer.fxml"));
		Scene MenuScene = new Scene(MenuView);
		Stage Window = (Stage)((Node)event.getSource()).getScene().getWindow();
		Window.setScene(MenuScene);
		Window.show();
	}
	
	public void jukeBox(ActionEvent event) throws IOException{
		Parent MenuView = FXMLLoader.load(getClass().getResource("MediaPlayer.fxml"));
		Scene MenuScene = new Scene(MenuView);
		Stage Window = (Stage)((Node)event.getSource()).getScene().getWindow();
		Window.setScene(MenuScene);
		Window.show();
		//Main.itunes.jukeBox();public void Jukebox() {
	
	/*	int index = randomGenerator.nextInt(Main.itunes.getSongLibrary().getListOfSongs().size());
	System.out.println(index);
	
	Song JukeBox = Main.itunes.getSongLibrary().getListOfSongs().get(index);
	MediaPlayerController.setPath(new File("src/media/JukeBox.artistName + \" - \" + \r\n" + JukeBox.getName() + ".mp3" ).getAbsolutePath());

	player = new MediaPlayer(new Media(new File(path).toURI().toString()));
	mv.setMediaPlayer(player);
	player.setOnReady(new Runnable() {
		public void run(){
			player.play();
		}
	});
	player.setOnEndOfMedia(new Runnable(){
		public void run() {
			player.stop(); 
		}

	});
}*/
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
}
