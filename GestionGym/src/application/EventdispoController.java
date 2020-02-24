package application;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.log.Log;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class EventdispoController {
	@FXML
    private Button ajouter;
	@FXML
    private Button modifier;
	@FXML
    private Button supprimer;
	@FXML
    private Button rafraishir;
	
	    @FXML
	    private TableColumn<Participant, String> nom;
	    @FXML
	    private TableColumn<Participant, String> prenom;
	    @FXML
	    private TableColumn<Participant, String> datedebut;
	    @FXML
	    private TableColumn<Participant, String> datefin;
	    @FXML
	    private TableColumn<Participant, String> payement;
	    @FXML
	    private TableColumn<Participant, String> status;
	    
	    @FXML
	    private TextField tnom;
	    @FXML
	    private TextField tprenom;
	    @FXML
	    private DatePicker tdatedebut;
	    @FXML
	    private DatePicker tdatefin;
	    @FXML
	    private TextField tpayement;
	    @FXML
	    private TextField tstatus;
	    
	    @FXML
	    private TableColumn<Participant, Integer> id;
	    @FXML
        private TableView<Participant> table;
	    
	 private ObservableList<Participant> data= FXCollections.observableArrayList();
	/* public void initialise()
	 {
		 nom.setCellValueFactory(cellData -> cellData.getValue().getNom());
         prenom.setCellValueFactory(cellData -> cellData.getValue().getPrenom());
         datedebut.setCellValueFactory(cellData -> cellData.getValue().getDatedebut());
         datefin.setCellValueFactory(cellData -> cellData.getValue().getDatefin());
         payement.setCellValueFactory(cellData -> cellData.getValue().getPayement());
         status.setCellValueFactory(cellData -> cellData.getValue().getStatus());
         
	 }*/ 
	 @FXML
	    public void add() 
		 {
			 
			 System.out.println(tnom.getText()); 
			 System.out.println(tdatedebut.getValue().toString()); 
		//	 Participant p = new Participant(tnom.getText(),tprenom.getText(),tdatedebut.getValue().toString(),tdatefin.getValue().toString())
		 try{
	        	 Cxion c=new Cxion();
	    	     Requete re=new Requete(c.getConn());
 re.addPar(tnom.getText(),tprenom.getText(),tdatedebut.getValue().toString(),tdatefin.getValue().toString(),tpayement.getText(),tstatus.getText());
	    		//refraich
	    	   data=re.Listpar();
	       	
	    		 System.out.print(data); 
	    	     id.setCellValueFactory(new PropertyValueFactory<Participant,Integer>("id_participant"));
	    	     nom.setCellValueFactory(new PropertyValueFactory<Participant,String>("nom"));
	    	     prenom.setCellValueFactory(new PropertyValueFactory<Participant,String>("prenom"));
	    	     datedebut.setCellValueFactory(new PropertyValueFactory<Participant,String>("datedebut"));
	    	     datefin.setCellValueFactory(new PropertyValueFactory<Participant,String>("datefin"));
	    	     payement.setCellValueFactory(new PropertyValueFactory<Participant,String>("payement"));
	    	     status.setCellValueFactory(new PropertyValueFactory<Participant,String>("status"));
	    	  
	    	        table.setItems(data);
			 }catch(Exception e){
		            e.printStackTrace();
		            System.out.println("Error on Building Data");             
		        }
		 }
	 
	 
	 
	 
	 
	 @FXML
    public void delete() 
	 {
		 Participant p = table.getSelectionModel().getSelectedItem();
		 System.out.println(p.getId_participant()); 
		 try{
        	 Cxion c=new Cxion();
    	     Requete re=new Requete(c.getConn());
    	   re.deletePart(p.getId_participant());
    	   
    	   
    	   //refraichir table
    	   data=re.Listpar();
        	
    		 System.out.print(data); 
    	     id.setCellValueFactory(new PropertyValueFactory<Participant,Integer>("id_participant"));
    	     nom.setCellValueFactory(new PropertyValueFactory<Participant,String>("nom"));
    	     prenom.setCellValueFactory(new PropertyValueFactory<Participant,String>("prenom"));
    	     datedebut.setCellValueFactory(new PropertyValueFactory<Participant,String>("datedebut"));
    	     datefin.setCellValueFactory(new PropertyValueFactory<Participant,String>("datefin"));
    	     payement.setCellValueFactory(new PropertyValueFactory<Participant,String>("payement"));
    	     status.setCellValueFactory(new PropertyValueFactory<Participant,String>("status"));
    	  
    	        table.setItems(data);
		 }catch(Exception e){
	            e.printStackTrace();
	            System.out.println("Error on Building Data");             
	        }
		 
	
  	 
		
	 }
	 
	 @FXML
	public void buildData(){
		//this.initialise();
	
        try{
        	 Cxion c=new Cxion();
    	     Requete re=new Requete(c.getConn());
    	     data=re.Listpar();
    	
    		 System.out.print(data); 
    	     id.setCellValueFactory(new PropertyValueFactory<Participant,Integer>("id_participant"));
    	     nom.setCellValueFactory(new PropertyValueFactory<Participant,String>("nom"));
    	     prenom.setCellValueFactory(new PropertyValueFactory<Participant,String>("prenom"));
    	     datedebut.setCellValueFactory(new PropertyValueFactory<Participant,String>("datedebut"));
    	     datefin.setCellValueFactory(new PropertyValueFactory<Participant,String>("datefin"));
    	     payement.setCellValueFactory(new PropertyValueFactory<Participant,String>("payement"));
    	     status.setCellValueFactory(new PropertyValueFactory<Participant,String>("status"));
    	  
    	        table.setItems(data);

       
         

          //FINALLY ADDED TO TableView
          
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");             
        }
    }
     public int id1=0;
	 @FXML
	 public void getRow()
	 { Participant p = table.getSelectionModel().getSelectedItem();
	 tnom.setText(p.getNom());
	 tprenom.setText(p.getPrenom());
	 this.id1=p.getId_participant();
	 
	 LocalDate localDatedebut = LocalDate.parse(p.getDatedebut());
	 
	 LocalDate localDatefin = LocalDate.parse(p.getDatefin());
	 tdatedebut.setValue(localDatedebut);
	 tdatefin.setValue(localDatefin);
	 tpayement.setText(p.getPayement());
	 tstatus.setText(p.getStatus());
		 System.out.println(tnom.getText()); 
		 System.out.println(tdatedebut.getValue().toString()); 
		 
	 }


	 @FXML
	    public void update() 
		 {
		 Participant p = table.getSelectionModel().getSelectedItem();
		
			 System.out.println(tnom.getText()); 
			 System.out.println(tdatedebut.getValue().toString()); 
			 System.out.println("id :"+p.getId_participant()); 
		//	 Participant p = new Participant(tnom.getText(),tprenom.getText(),tdatedebut.getValue().toString(),tdatefin.getValue().toString())
		 try{
	        	 Cxion c=new Cxion();
	    	     Requete re=new Requete(c.getConn());
    	     	re.updatePar(this.id1,tnom.getText(),tprenom.getText(),tdatedebut.getValue().toString(),tdatefin.getValue().toString(),tpayement.getText(),tstatus.getText());
		    		//refraich
	    	   data=re.Listpar();
	       	
	    		 System.out.print(data); 
	    	     id.setCellValueFactory(new PropertyValueFactory<Participant,Integer>("id_participant"));
	    	     nom.setCellValueFactory(new PropertyValueFactory<Participant,String>("nom"));
	    	     prenom.setCellValueFactory(new PropertyValueFactory<Participant,String>("prenom"));
	    	     datedebut.setCellValueFactory(new PropertyValueFactory<Participant,String>("datedebut"));
	    	     datefin.setCellValueFactory(new PropertyValueFactory<Participant,String>("datefin"));
	    	     payement.setCellValueFactory(new PropertyValueFactory<Participant,String>("payement"));
	    	     status.setCellValueFactory(new PropertyValueFactory<Participant,String>("status"));
	    	  
	    	        table.setItems(data);
			 }catch(Exception e){
		            e.printStackTrace();
		            System.out.println("Error on Building Data");             
		        }
		 }
	 
	 
	 public void logout(ActionEvent event) throws IOException
	 {
		 Parent root=FXMLLoader.load(getClass().getResource("/application/eventdispo.fxml"));
			Scene scene = new Scene(root);
			Stage app_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
			app_stage.setScene(scene);
			app_stage.show();
	 }
	 
}
