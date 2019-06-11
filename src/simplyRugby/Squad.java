package simplyRugby;
/**
 * Creates the squad objects
 * @author Livingstone
 *
 */
public class Squad {
 private String squadName = "";
 private int squadNumber = 0;


 	public Squad(String squadName, int squadNumber){
	 this.squadName = squadName;
	 this.squadNumber = squadNumber;
 	}

 	public String getSquadName() {
		return squadName;
	}
	
	public void setSquadName(String squadName) {
		this.squadName = squadName;
	}
	
 	public int getSquadNumber(){
 		return squadNumber;
 	}
 	
 	public void setSquadNumber(int squadNumber) {
		this.squadNumber = squadNumber;
	}

 	public String toString(){
 		return "squad: " + squadName + " - " + squadNumber;
 	}
}
