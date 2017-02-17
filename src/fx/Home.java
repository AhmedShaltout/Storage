package fx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Home {
	////////////////////Layout Objects//////////////////////////
	Stage window;
	Scene scene;
	BorderPane layout;
	HBox header, footer;
	Label info, org_Name;
	ImageView layoutBackground;
	///////////////////Home Glass Objects//////////////////////
	GridPane homeGlass;
	Button exitButton;
	MenuBar addBar, exchangeBar, reportBar;
	Menu addMenu, exchangeMenu, reportMenu;
	MenuItem dailyAdd, monthlyAdd, yearlyAdd, dailyExchange, monthlyExchange, yearlyExchange,
			dailyReport, monthlyReport, yearlyReport;
	SeparatorMenuItem separator1, separator2;
	
	public Home(){
		///////////////////Header Components/////////////////////
		org_Name=new Label("الجمعيه التعاونيه الزراعيه المركزيه للأئتمان");
		org_Name.setId("org_Name");
		
		header=new HBox();
		header.setPadding(new Insets(12,15,12,15));
		header.getChildren().add(org_Name);
		header.setAlignment(Pos.CENTER);
		header.setId("header");

		///////////////////Home Glass Components/////////////////
		exitButton=new Button("خروج");
		exitButton.setId("exitButton");
		exitButton.setPadding(new Insets(20,20,20,20));
		exitButton.setCursor(Cursor.HAND);
		exitButton.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
				window.close();
				System.exit(0);
			}
		});
		
		addMenu=new Menu("اضافه صنف");
		addMenu.setId("menu");
		addBar=new MenuBar();
		addBar.getMenus().add(addMenu);
		addBar.setId("bar");
		addBar.setCursor(Cursor.HAND);
		
		exchangeMenu=new Menu("صرف صنف");
		exchangeMenu.setId("menu");
		exchangeBar=new MenuBar();
		exchangeBar.getMenus().add(exchangeMenu);
		exchangeBar.setId("bar");
		exchangeBar.setCursor(Cursor.HAND);
		
		reportMenu=new Menu("رؤيه تقرير");
		reportMenu.setId("menu");
		
		dailyReport=new MenuItem("تقرير يومى");
		dailyReport.setId("item");
		monthlyReport=new MenuItem("تقرير شهرى");
		monthlyReport.setId("item");
		yearlyReport=new MenuItem("تقرير سنوى");
		yearlyReport.setId("item");
		separator1=new SeparatorMenuItem();
		dailyAdd=new MenuItem("تقرير اضافه يومى");
		dailyAdd.setId("item");
		monthlyAdd=new MenuItem("تقرير اضافه شهرى");
		monthlyAdd.setId("item");
		yearlyAdd=new MenuItem("تقرير اضافه سنوى");	
		yearlyAdd.setId("item");
		separator2=new SeparatorMenuItem();
		dailyExchange=new MenuItem("تقرير صرف يومى");
		dailyExchange.setId("item");
		monthlyExchange=new MenuItem("تقرير صرف شهرى");
		monthlyExchange.setId("item");
		yearlyExchange=new MenuItem("تقرير صرف سنوى");
		yearlyExchange.setId("item");
		reportMenu.getItems().addAll(dailyReport, monthlyReport, yearlyReport, separator1, dailyAdd, monthlyAdd, yearlyAdd,
									separator2, dailyExchange, monthlyExchange, yearlyExchange);
		reportBar=new MenuBar();
		reportBar.getMenus().add(reportMenu);
		reportBar.setId("bar");
		reportBar.setCursor(Cursor.HAND);
		
		homeGlass=new GridPane();
		homeGlass.setPadding(new Insets(120,20,20,300));
		homeGlass.setHgap(30);
		homeGlass.setVgap(30);
		homeGlass.setId("homeGlass");
		homeGlass.setMaxHeight(550);
		homeGlass.setMaxWidth(1200);
		homeGlass.setVgap(100);
		
		GridPane.setConstraints(addBar, 0,0);
		GridPane.setConstraints(exchangeBar, 1,0);
		GridPane.setConstraints(reportBar, 2,0);
		GridPane.setConstraints(exitButton, 1,1);
		
		homeGlass.getChildren().addAll(exitButton, addBar, exchangeBar, reportBar);
		///////////////////Footer Components/////////////////////
		footer=new HBox();
		info=new Label("Copyright © 2017 All Rights Reserved. A.S team.");
		info.setId("info");
		footer.getChildren().add(info);
		footer.setAlignment(Pos.CENTER);
		footer.setId("footer");
		footer.setPadding(new Insets(7,7,7,7));
		////////////////////Layout Components////////////////////
		layoutBackground=new ImageView(new Image(getClass().getResourceAsStream("ss2.jpg")));
		layoutBackground.setFitHeight(700);
		layoutBackground.setFitWidth(1360);
		
		layout=new BorderPane();
		layout.getChildren().add(layoutBackground);
		layout.setMinHeight(650);
		layout.setMinWidth(1200);
		layout.setTop(header);
		layout.setCenter(homeGlass);
		layout.setBottom(footer);
		
		///////////////////Scene Components//////////////////////
		scene=new Scene(layout);
		scene.getStylesheets().add(this.getClass().getResource("Stylesheet.css").toExternalForm());
		////////////////////Window Components///////////////////
		window=new Stage();
		window.setScene(scene);
		window.show();
		window.setResizable(false);
		
	}
	
}
