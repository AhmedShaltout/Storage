package fx;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AddClass {
	///////////////////AddGlass Objects//////////////////
	GridPane addGlass;
	
	///////////////////Layout Objects////////////////////
	BorderPane layout;
	ImageView background;
	Scene scene;
	Stage window;
	public AddClass(){
		////////////////////AddGlass Components//////////////////
		addGlass=new GridPane();
		addGlass.setId("glass");
		addGlass.setMaxHeight(550);
		addGlass.setMaxWidth(1200);
		addGlass.setVgap(50);
		addGlass.setHgap(30);
		addGlass.setPadding(new Insets(10,10,10,10));
		
		///////////////////Scene Components//////////////////////
		background=new ImageView(new Image(getClass().getResourceAsStream("ss3.jpg")));
		background.setFitHeight(700);
		background.setFitWidth(1360);		
		
		layout=new BorderPane();
		layout.setMinHeight(650);
		layout.setMinWidth(1200);
		layout.getChildren().add(background);
		layout.setCenter(addGlass);
		
		scene=new Scene(layout);
		scene.getStylesheets().add(this.getClass().getResource("Stylesheet.css").toExternalForm());
		////////////////////Window Components///////////////////
		window=new Stage();
		window.setScene(scene);
		window.show();
		window.setResizable(false);		
	}
}
