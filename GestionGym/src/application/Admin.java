package application;

public class Admin {

	
	
	private String login,motpass,profil;

	
	public Admin(String login, String motpass, String profil) {
		super();
		this.login = login;
		this.motpass = motpass;
		this.profil = profil;
		
		
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getMotpass() {
		return motpass;
	}


	public void setMotpass(String motpass) {
		this.motpass = motpass;
	}


	public String getProfil() {
		return profil;
	}


	public void setProfil(String profil) {
		this.profil = profil;
	}
}
