package system;

import java.net.InetAddress;
import java.net.NetworkInterface;

import javax.swing.JOptionPane;
import fx.Home;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static void main(String[] args)  {
		launch(args);
	}
	
	@Override
	public void start(Stage arg0){
		String mac=getMac();
		String activatedMac=DB.getAllowedMac();
		if(mac!=null&&activatedMac!=null)
			if(activatedMac.equals(mac))
				new Home();
			else{
				JOptionPane.showMessageDialog(null, "    Program is not activated or\nYou arn't connected to the server","Error",JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		else{
			JOptionPane.showMessageDialog(null, "    Program is not activated or\nYou arn't connected to the server","Error",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
	private String getMac(){
        StringBuilder sb = new StringBuilder();
		try {
            byte[] mac = NetworkInterface.getByInetAddress(InetAddress.getLocalHost()).getHardwareAddress();
            for (int i = 0; i < mac.length; i++){
                sb.append(String.format("%02X%s", mac[i],(i< mac.length - 1)?"-":""));
            }
        } 
        catch (Exception e) {}
		return sb.toString();
	}
}
