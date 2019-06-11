package simplyRugby;
	import java.time.LocalDate;
/**
 * More information about those who are stored in the system
 * @author Livingstone
 *
 */
public abstract class Player extends Member {

		
		protected String health;
		protected String doctor;
		protected String docNo;
		protected String position;
		protected int squadNo;
		
				
		public Player(String name,String address,String postcode,int sruNo,LocalDate dob,String telNo,String mobNo,String eMail,String health, String doctor, String docNo, String position, int squadNo) {
			super(name,address,postcode,sruNo,dob,telNo,mobNo,eMail);
			this.health = health;
			this.doctor = doctor;
			this.docNo = docNo;
			this.position = position;
			this.squadNo = squadNo;
		}

		public int getSquadNo() {
			return squadNo;
		}

		public void setSquadNo(int squadNo) {
			this.squadNo = squadNo;
		}

		public String getHealth() {
			return health;
		}

		public void setHealth(String health) {
			this.health = health;
		}

		public String getDoctor() {
			return doctor;
		}

		public void setDoctor(String doctor) {
			this.doctor = doctor;
		}

		public String getDocNo() {
			return docNo;
		}

		public void setDocNo(String docNo) {
			this.docNo = docNo;
		}

		public String getPosition() {
			return position;
		}

		public void setPosition(String position) {
			this.position = position;
		}
		
		

						


		
}

