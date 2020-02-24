package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Requete {
	private Connection con = null;
	private Statement ps = null;
	private ResultSet rs = null;

	public Requete(Connection con) {
		this.con = con;
	}
    public void deletePart(int i)
    {
    	String requete = "delete from participant where id_participant ="+i;
    	try {
    	ps = con.createStatement();
		 ps.executeUpdate(requete);
    	}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    public void addPar(String n,String p ,String dd,String df,String pa,String s)
    {
    	String requete = "insert into participant (Nom,Prenom,datedebut,datefin,payement,status) values('"+n+"','"+p+"','"+dd+"','"+df+"','"+pa+"','"+s+"')";
    	try {
    	ps = con.createStatement();
		ps.executeUpdate(requete);
    	}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void updatePar(int id,String n,String p ,String dd,String df,String pa,String s)
    {
    	String requete = "update participant set Nom='"+n+"',Prenom='"+p+"',datedebut='"+dd+"',datefin='"+df+"',payement='"+pa+"',status='"+s+"' where id_participant="+id+"";
    	try {
    	ps = con.createStatement();
		ps.executeUpdate(requete);
    	}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public ObservableList<Participant> Listpar() {
		
		ObservableList<Participant> data= FXCollections.observableArrayList();
		List<Participant> listp = new ArrayList<>();
		String requete = "select * from participant ";
		try {
			ps = con.createStatement();
			rs = ps.executeQuery(requete);
			while (rs.next()) {
				int id = rs.getInt("id_participant");
				String nom = rs.getString("Nom");
				String prenom = rs.getString("Prenom");
				String datedebut = rs.getString("datedebut");
				String datefin = rs.getString("datefin");
				String payement = rs.getString("payement");
				String status = rs.getString("status");
				listp.add(new Participant(nom, prenom, datedebut, datefin, payement,status, id));
                data.add(new Participant(nom, prenom, datedebut, datefin, payement,status, id));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

/*	public Participant userConn(String email, String motdepass) {
		List<Participant> l = this.Listpar();
		Iterator<Participant> it = l.iterator();
		Participant p1=null;
		while (it.hasNext()) {
			Participant p = it.next();
			if (p.getEmail().equals(email)) {
				if (p.getMotdepass().equals(motdepass)) {
					p1=p;
				}
			}
        }
		return p1;
	}*/
	
	
	
	
	public List<Admin> ListAdmin() {
		List<Admin> listp = new ArrayList<>();
		String requete = "select * from admin ";
		try {
			ps = con.createStatement();
			rs = ps.executeQuery(requete);
			while (rs.next()) {
				//int id = rs.getInt("id");
				String login = rs.getString("login");
				String motpass = rs.getString("motpass");
				String profil = rs.getString("profil");
				
				listp.add(new Admin( login, motpass, profil));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listp;
	}


}
