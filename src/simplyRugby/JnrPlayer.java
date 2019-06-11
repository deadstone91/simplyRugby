package simplyRugby;

import java.time.LocalDate;
/**
 * Specific information of players who are of the junior playing type
 * @author Livingstone
 *
 */
public class JnrPlayer extends Player{
	
	
	private String guardian1;
	private String g1Relationship;
	private String g1Address;
	private String g1Tel;
	private String guardian2;
	private String g2Relationship;
	private String g2Address;
	private String g2Tel;
	private String docAddress;
		
/**
 * Constructor getting parameters
 * @param name
 * @param address
 * @param postcode
 * @param sruNo
 * @param dob
 * @param telNo
 * @param mobNo
 * @param eMail
 * @param health
 * @param doctor
 * @param docNo
 * @param position
 * @param squadNo
 * @param g1Relationship
 * @param g1Address
 * @param g1Tel
 * @param guardian2
 * @param g2Relationship
 * @param g2Address
 * @param g2Tel
 * @param docAddress
 * @param guardian1
 */
	public JnrPlayer(String name,String address,String postcode, int sruNo, LocalDate dob, String telNo,String mobNo,String eMail, String health, String doctor, String docNo, String position, int squadNo,String g1Relationship,
			String g1Address, String g1Tel, String guardian2, String g2Relationship, String g2Address, String g2Tel,
			String docAddress, String guardian1) {
		super(name,address,postcode,sruNo,dob,telNo,mobNo,eMail,health, doctor, docNo, position,squadNo);
		this.g1Relationship = g1Relationship;
		this.g1Address = g1Address;
		this.g1Tel = g1Tel;
		this.guardian2 = guardian2;
		this.g2Relationship = g2Relationship;
		this.g2Address = g2Address;
		this.g2Tel = g2Tel;
		this.docAddress = docAddress;
		this.guardian1 = guardian1;
		
	}
	
	
	public String getGuardian1() {
		return guardian1;
	}
	
	public void setGuardian1(String guardian1) {
		this.guardian1 = guardian1;
	}
	
	public String getG1Relationship() {
		return g1Relationship;
	}
	public void setG1Relationship(String g1Relationship) {
		this.g1Relationship = g1Relationship;
	}
	public String getG1Address() {
		return g1Address;
	}
	public void setG1Address(String g1Address) {
		this.g1Address = g1Address;
	}
	public String getG1Tel() {
		return g1Tel;
	}
	public void setG1Tel(String g1Tel) {
		this.g1Tel = g1Tel;
	}
	public String getGuardian2() {
		return guardian2;
	}
	public void setGuardian2(String guardian2) {
		this.guardian2 = guardian2;
	}
	public String getG2Relationship() {
		return g2Relationship;
	}
	public void setG2Relationship(String g2Relationship) {
		this.g2Relationship = g2Relationship;
	}
	public String getG2Address() {
		return g2Address;
	}
	public void setG2Address(String g2Address) {
		this.g2Address = g2Address;
	}
	public String getG2Tel() {
		return g2Tel;
	}
	public void setG2Tel(String g2Tel) {
		this.g2Tel = g2Tel;
	}
	
	public String getDocAddress() {
		return docAddress;
	}
	public void setDocAddress(String docAddress) {
		this.docAddress = docAddress;
	}
	
	public String toString(){
		return "name: " + name + " sruNo: " + sruNo;
	}
}
