package application;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
//import java.util.Observable;
import java.util.ResourceBundle;

import Home.Song;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class MediaPlayerController implements Initializable{
	public static Random randomGenerator;
@FXML private MediaView mv;
@FXML private ProgressIndicator progressCircle;

	private	Media media; 
	private   MediaPlayer player; 
@FXML Slider volumeSlider;
	Pane mpane; 
	//  MediaBar bar; 
	private String path;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		randomGenerator = new Random(); //may switch location
		//Jukebox();
		this.setPath(new File("src/media/Chance The Rapper - Cocoa Butter Kisses (feat. Vic Mensa and Twista).mp3").getAbsolutePath());
		this.media = new Media(new File(getPath()).toURI().toString());
		player = new MediaPlayer(media);
		mv.setMediaPlayer(player);
		//player.setAutoPlay(true);
		DoubleProperty width = mv.fitWidthProperty();
		DoubleProperty height = mv.fitHeightProperty();
		width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
		height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));
		progressCircle.setProgress(0.0);
	
volumeSlider.setValue(player.getVolume()*100);
volumeSlider.valueProperty().addListener(new InvalidationListener() {

	public void invalidated(Observable observable) {
		player.setVolume(volumeSlider.getValue()/100);
		
	}
});

	}

	public void play(ActionEvent event) {
		player.play();
		player.setRate(1);
		
	}
	public void pause(ActionEvent event) {
		player.pause();
	}public void fast(ActionEvent event) {
		player.setRate(2);
	}public void slow(ActionEvent event) {
		player.setRate(.5);
	}public void reload(ActionEvent event) {
		player.seek(player.getStartTime());
		player.play();
	}
	public void start(ActionEvent event) {
		player.seek(player.getStartTime());
		player.stop();
	}
	public void last(ActionEvent event) {
		player.seek(player.getTotalDuration());  
		player.stop();
	}
	public void MenuScreenExit(ActionEvent event) throws IOException{
		player.stop();
		Parent MenuView = FXMLLoader.load(getClass().getResource("MenuViewer.fxml"));
		Scene MenuScene = new Scene(MenuView);
		Stage Window = (Stage)((Node)event.getSource()).getScene().getWindow();
		Window.setScene(MenuScene);
		Window.show();
	}
	public void progress() {
		player.getBufferProgressTime();
	}

	

public class bg_Thread implements Runnable{
	
@Override
public void run() {
	// TODO Auto-generated method stub
	for(int i =0;i<100;i++) {
		progressCircle.setProgress(i/100.0);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
public void handleButtonAction(ActionEvent event) {
	Thread th = new Thread(new bg_Thread());
	th.start();
}
public void initialize(URL url, ResourceBundle rb) {
	progressCircle.setProgress(0.0);
}
}

	public MediaView getMv() {
		return mv;
	}

	public void setMv(MediaView mv) {
		this.mv = mv;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public MediaPlayer getPlayer() {
		return player;
	}

	public void setPlayer(MediaPlayer player) {
		this.player = player;
	}
public void Jukebox() {
	
		int index = randomGenerator.nextInt(Main.itunes.getSongLibrary().getListOfSongs().size());
	System.out.println(index);
	//Controlla
	Song JukeBox = Main.itunes.getSongLibrary().getListOfSongs().get(index);
	this.setPath(new File("src/media/JukeBox.artistName + \" - \" + \r\n" + JukeBox.getName() + ".mp3" ).getAbsolutePath());
//path being static may lead to errors later
	this.setPlayer(new MediaPlayer(new Media(new File(getPath()).toURI().toString())));
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
}

public String getPath() {
	return path;
}

public  void setPath(String path) {
	this.path = path;
}
}

