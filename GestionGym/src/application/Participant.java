package application;



	public class Participant {
		
		private String nom,prenom,datedebut,datefin,payement,status;
		private int id_participant;
		
		public Participant(String nom, String prenom, String datedebut , String datefin , String payement , String status,int id) {
			super();
			this.nom = nom;
			this.prenom = prenom;
			this.datedebut = datedebut;
			this.datefin = datefin;
			this.payement = payement;
			this.status = datedebut;
			this.id_participant = id;
			
			
		}
		
		
		
		
		
		
		
		public boolean equals(Object obj1,Object obj2)
		{String ch1,ch2;
		
			 ch1 = (String) obj1;
		
			ch2=(String) obj2;
		
		if (ch1.equals(ch2))
		return true;
		else return false;
		}







		public String getNom() {
			return nom;
		}







		public void setNom(String nom) {
			this.nom = nom;
		}







		public String getPrenom() {
			return prenom;
		}







		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}







		public String getDatedebut() {
			return datedebut;
		}







		public void setDatedebut(String datedebut) {
			this.datedebut = datedebut;
		}







		public String getDatefin() {
			return datefin;
		}







		public void setDatefin(String datefin) {
			this.datefin = datefin;
		}







		public String getPayement() {
			return payement;
		}







		public void setPayement(String payement) {
			this.payement = payement;
		}







		public String getStatus() {
			return status;
		}







		public void setStatus(String status) {
			this.status = status;
		}







		public int getId_participant() {
			return id_participant;
		}







		public void setId_participant(int id_participant) {
			this.id_participant = id_participant;
		}

	}


