package simplyRugby;

import java.time.LocalDate;

/**
 * more player information
 * @author Livingstone
 *
 */
public class SnrPlayer extends Player{
	
	private String nextOfKin;
	private String kinTel;
	
	
	
	
	public SnrPlayer(String name, String address, String postcode, int sruNo, LocalDate dob, String telNo, String mobNo,
			String eMail, String health, String doctor, String docNo, String possition, int squadNo, String nextOfKin,
			String kinTel) {
		super(name, address, postcode, sruNo, dob, telNo, mobNo, eMail, health, doctor, docNo, possition,squadNo);
		this.nextOfKin = nextOfKin;
		this.kinTel = kinTel;
		
	}
	public String getNextOfKin() {
		return nextOfKin;
	}
	public void setNextOfKin(String nextOfKin) {
		this.nextOfKin = nextOfKin;
	}
	public String getKinTel() {
		return kinTel;
	}
	public void setKinTel(String kinTel) {
		this.kinTel = kinTel;
	}
	
	public String toString(){
		return "name: " + name + " sruNo: " + sruNo;
	}
	
}
