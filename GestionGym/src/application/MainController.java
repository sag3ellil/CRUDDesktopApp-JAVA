package application;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController {
	@FXML
    private Button connect;
	@FXML
	private TextField email;
	public TextField getEmail() {
		return email;
	}
	public void setEmail(TextField email) {
		this.email = email;
	}
	@FXML
	private PasswordField motdepass;
	@FXML
	public void depl_log(ActionEvent event) throws IOException
	{    Cxion c=new Cxion();
	     Requete re=new Requete(c.getConn());
	     List<Admin> l=re.ListAdmin();
	     Iterator<Admin> it =l.iterator();
	     Boolean b=false;
	     while(it.hasNext())
	     {
	    	 Admin p=it.next();
	    	 System.out.println(email.getText());
	    	 System.out.println(motdepass.getText());
	    	 System.out.println(getMotdepass());
	    	 if (p.getLogin().equals(email.getText())) {
					if (p.getMotpass().equals(motdepass.getText())) {
						b = true;
						Parent root=FXMLLoader.load(getClass().getResource("/application/eventdispo.fxml"));
						Scene scene = new Scene(root);
						Stage app_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
						app_stage.setScene(scene);
						app_stage.show();
						
					}
				}
	    	 if (b == false && !it.hasNext()) {
					Alert dialogW = new Alert(AlertType.WARNING);
					dialogW.setTitle("Attention!");
					dialogW.setHeaderText(null); // No header
					dialogW.setContentText("Caution : Login ou mot de passe incorrect  !");
					dialogW.showAndWait();

				}
		
	     }
	     }
	public PasswordField getMotdepass() {
		return motdepass;
	}
	public void setMotdepass(PasswordField motdepass) {
		this.motdepass = motdepass;
	}
	public void depl_inscri(ActionEvent event) throws IOException
	{Parent root=FXMLLoader.load(getClass().getResource("/application/Inscription.fxml"));
	Scene scene = new Scene(root);
	Stage app_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
	app_stage.setScene(scene);
	app_stage.show();
	
		
	}
}
