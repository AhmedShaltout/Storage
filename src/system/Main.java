package system;

<<<<<<< HEAD
import fx.Home;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		new Home();
=======
import java.time.LocalDateTime;

public class Main {

	public static void main(String[] args) {
		System.out.println(LocalDateTime.now().minusMonths(1).toLocalDate().toString());
>>>>>>> origin/master
	}

}
