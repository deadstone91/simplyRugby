package simplyRugby;

public class SkillCategory {

	private String comments = ""; 
	private String category = "";
	private int sru = 0;
	
	/**
	 * Setting parameters for the SkillCategory class
	 * @param category
	 * @param comments
	 * @param sru
	 */
	SkillCategory(String category,String comments,int sru){
		this.category = category;
		this.comments = comments;
		this.sru = sru;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getSru() {
		return sru;
	}

	public void setSru(int sru) {
		this.sru = sru;
	}




	
	
}
