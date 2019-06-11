package simplyRugby;
	import java.time.LocalDate;
/**
 * Beginnings of the information stored about the players in the system
 * @author Livingstone
 *
 */
	public class Member {
		protected String name;
		protected String address;
		protected String postcode;
		protected int sruNo;
		protected LocalDate dob;
		protected String telNo;
		protected String mobNo;
		protected String eMail;
		
		/**
		 * 
		 * @param name
		 * @param address
		 * @param postcode
		 * @param sruNo
		 * @param dob
		 * @param telNo
		 * @param mobNo
		 * @param eMail
		 */
		
		
			public Member(String name,String address,String postcode,int sruNo,LocalDate dob,String telNo,String mobNo,String eMail) {
			super();
			this.name = name;
			this.address = address;
			this.postcode = postcode;
			this.sruNo = sruNo;
			this.dob = dob;
			this.telNo = telNo;
			this.mobNo = mobNo;
			this.eMail = eMail;
		}

		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPostcode() {
			return postcode;
		}
		public void setPostcode(String postcode) {
			this.postcode = postcode;
		}
		public int getSruNo() {
			return sruNo;
		}
		public void setSruNo(int sruNo) {
			this.sruNo = sruNo;
		}
		public LocalDate getDob() {
			return dob;
		}
		public void setDob(LocalDate dob) {
			this.dob = dob;
		}
		public String getTelNo() {
			return telNo;
		}
		public void setTelNo(String telNo) {
			this.telNo = telNo;
		}
		public String getMobNo() {
			return mobNo;
		}
		public void setMobNo(String mobNo) {
			this.mobNo = mobNo;
		}
		public String geteMail() {
			return eMail;
		}
		public void seteMail(String eMail) {
			this.eMail = eMail;
		}
		
		
		
	}


