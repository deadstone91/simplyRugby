package simplyRugby;

public class Skill {
	private int category;
	private int value;
	private String skillName;
	private int userId;
	
	/**
	 * Parameters the skill class
	 * @param category
	 * @param value
	 * @param skillName
	 * @param userId
	 */

	public Skill(int category,int value,String skillName, int userId){
		this.category = category;
		this.value = value;
		this.skillName = skillName;
		this.userId = userId;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int catagory) {
		this.category = catagory;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
