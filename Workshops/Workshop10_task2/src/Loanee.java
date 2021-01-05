//REFLECT - Workshop 10
//Course:JAC444 - 4 Semester
//Last Name: Do Carmo Saraiva Teixeira
//First Name: Pedro Vitor
//ID: 100036193
//Section: NDD
//This assignment represents my own work in accordance with Seneca Academic Policy.
//Date: December 08, 2020

public class Loanee {
	private int id;
	private double loaned;
	private boolean bankrupted;
	
	Loanee(int m_id, double m_loaned){
		this.id = m_id;
		this.loaned = m_loaned;
		this.bankrupted = false;
		
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getAmountLoaned() {
		return loaned;
	}
	
	public void setLoaned(int loaned) {
		this.loaned = loaned;
	}

	public boolean isbankrupted() {
		return bankrupted;
	}

	public void setIsbankrupted(boolean isbankrupted) {
		this.bankrupted = isbankrupted;
	}
	
	
	
}
