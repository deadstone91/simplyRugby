package simplyRugby;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.swing.JSlider;
import javax.swing.JTextArea;

import com.google.gson.GsonBuilder;
/**
 * Controller initialises needed classes and ArrayLists that the program needs  
 *
 * 
 */
public class Controller {
	Model m = new Model();	//Creates an instance of the model



	ArrayList<Player> tempPlayer = m.players; //sets up an ArrayList with values from players
	ArrayList<Squad> tempSquad = m.squ; //sets up an arrayList with values from squ
	ArrayList<String> toReturn = new ArrayList<String>(); //creates an arraylist
	ChoosePlayerWindow cpWindow = new ChoosePlayerWindow(this); //creates an instance of the choose player window
	boolean one = false;
	boolean two = false;
	boolean three = false;
	boolean four = false;
	boolean five = false;
	boolean six = false;
	boolean seven = false;
	boolean eight = false;
	boolean nine = false;
	boolean ten = false;
	boolean eleven = false;

	Controller(){
		populateSkills();
		populateComments();
		//calls this method
		cpWindow.setVisible(true); //creates the choose player window
		chooseSquad(); //calls this method


	}
	/**
	 * This checks if a json file of skills exists and then restores the ArrayList with it
	 */
	public void populateSkills(){
		Type skillType = new TypeToken<ArrayList<Skill>>(){}.getType(); 
		File f = null;
		boolean found = false;
		f = new File("Skills.json");
		if(f.exists()){
			System.out.println("file Exists");
			try{			//exception check to see if file is real or not
				Reader reader = new FileReader("Skills.json");
				//m.skills.clear();

				m.skills = new Gson().fromJson(reader, skillType);
			}catch (FileNotFoundException e){
				System.out.println("file not found");
			}

		}else{
			System.out.println("file not found");
		}
	} 
	/**
	 * This checks if a json file of comments exists and then restores the ArrayList with it
	 */
	public void populateComments(){
		Type skillType = new TypeToken<ArrayList<SkillCategory>>(){}.getType(); //gets the type of the class
		File f = null;  														//initialise file
		boolean found = false;													//initialise boolean

		f = new File("Comments.json");											//file becomes equal to Comments.json
		if(f.exists()){															//if this file exists then output it does or doesnt
			System.out.println("file Exists");
			try{																//exception check to see if file is real or not
				Reader reader = new FileReader("Comments.json");				//if it does this then reads the file into the reader
				//m.skills.clear();

				m.comments = new Gson().fromJson(reader, skillType); 			//converts it from json and puts in arrayList
			}catch (FileNotFoundException e){
				System.out.println("file not found");							//exeption handling
			}

		}else{
			System.out.println("file not found");
		}
	}

	/**
	 * 
	 * @return 
	 * 	returns an array of string that contains squads for the comboBox
	 *  called from the comboBox
	 */
	public String[] chooseSquad(){
		int counter = 0;													//Initialise counter
		String[] squad = new String[3]; 									//creates the String array
		for(Squad sq: m.squ){  												//forEach loop going through the squad arrayList
			//System.out.println(m.squ.size());
			//System.out.println(m.squ.toString());

			squad[counter] = sq.toString(); 
			counter++;
			//System.out.println(sq.toString());
		}
		return squad; 														//returns the array
	}
	/**
	 * 
	 *  This method takes as a parameter from the JComboBox and compares integer values parsed from it to players and adds those players to an arraylist
	 * @param combo
	 * @return ArrayList "toReturn" containing players in toString style
	 */
	public ArrayList getPlayers(String combo){
		int squadNo = 0;
		int playerSquad = 0;
		String[] stuffToReturn = new String[100];

		String[] comboSplit = combo.split("-"); 						//takes in variable combo and splits at the "-"
		int comboSquad = Integer.parseInt(comboSplit[1].trim()); 		//takes 2nd variable in cobmoSplit and makes into int 
		//System.out.println(comboSquad);

		for(Player p: tempPlayer){ 										//forEach going through the tempPlayers
			//System.out.println("testing line 61 controller " + p.getSquadNo());
			if(comboSquad == p.getSquadNo()){ 							//comparison between int form above against the squad number in the TempPlayer arrayList
				//System.out.println("\nYou are in the getPlayers method " + p.getSquadNo());


				toReturn.add(p.toString()); 							// if the comparison is tru then it gets added to the toReturn arraylist
			}
		}
		return toReturn; 												//returns arraylist
	}
	/**
	 * Small piece of code that enables or disables a button in ChoosePlayerWindow
	 * @param index
	 * @return boolean open
	 *  
	 */
	public boolean buttonState(int index){
		boolean open;									//Initialise boolean variable

		if(index >= 0){
			open = true;								//boolean to true
		}else{
			open = false;								//boolean to false
		}
		return open;
	}
	/**
	 * this method splits the toString from  an earlier method and gets just the name of the player.
	 * @param s
	 * @return String r
	 * 
	 */
	public String whichPlayer(String s){
		String[] split;
		String r = null;

		for(Player pl: tempPlayer){
			split = s.split(":"); 										//splits the string "s" at this symbol into 3 parts 
			//e.g "name: Zak Laing sruNo: 123464" split[0] = "name", split[1] = " Zak Laing sruNo"
			//split[2] = " 123464" before trim
			if(Integer.parseInt(split[2].trim()) == pl.getSruNo()){		//verifies if this is the right user //trim() takes all spaces before and after string away
				String[] split2 = split[1].trim().split(" "); 			//splits again to get just the name 
				for (String st: split2){
					//System.out.println("look here " + st);
				}
				r =  split2[0].trim() + " " + split2[1]; 
			}

		}
		return r;


	}
	/**
	 * finds the sru number for the user
	 * @param player
	 * @return String "sruNo: Dynamic number"
	 * 
	 */
	public String findPlayer(String player){
		String sru = "";
		for(Player p: tempPlayer){									//example of a forEach loop - traverses through each object in the tenpPlayer arrayList
			if(player == p.getName()){
				//System.out.println("the player is " + player);
				sru = Integer.toString(p.getSruNo()); 				//changes the int as a String
			}
		}
		return "sruNo: " + sru;
	}
	/**
	 * This method gets the squad for a certain player
	 * @return String "Sqaud: squadName"
	 * 
	 */
	public String whichSquad(){
		String squad = "";
		for(Squad s: tempSquad){
			for(Player p: tempPlayer){						//nested forEach comparing all players to each squad
				if (s.getSquadNumber() == p.squadNo){
					squad = s.getSquadName();
				}
			}
		}
		return "Squad:" + squad;
	}
	/**
	 *  method finds what the sru number is but unlike before returns it as an int
	 * @param player
	 * @return int sru
	 *
	 */
	public int findSruNo(String player){
		int sru = 0;														//initialise variable

		//System.out.println("findSruNo() the player is :" + player);
		for(Player p: m.players){
			//System.out.println("findSruNo() the player.getName() is :" + p.getName());
			if(player.trim().equals(p.getName().trim()) ){					//string comparison different to other types and need .equals() rather than ==
				sru =  p.getSruNo();
				break;
			}
		}
		return sru;
	}
	/**
	 * This method gets the comments from the skillWindow and saves them in the skillCategory class
	 * @param comment1
	 * @param comment2
	 * @param comment3
	 * @param sru
	 */
	public void saveComments(JTextArea comment1,JTextArea comment2, JTextArea comment3,int sru){
		String category = "";
		String commentOne = "";
		String commentTwo = "";
		String commentThree = "";
		int sruNo = 0;

		commentOne = comment1.getText();
		commentTwo = comment2.getText();
		commentThree = comment3.getText();
		sruNo = sru;


		SkillCategory sc1 = new SkillCategory("passing",commentOne,sruNo);				//creating the objects
		SkillCategory sc2 = new SkillCategory("kicking",commentTwo,sruNo);
		SkillCategory sc3 = new SkillCategory("tackling",commentThree,sruNo);
		m.comments.add(sc1);															//saving the objects to arraylist in m(Model)
		m.comments.add(sc2);
		m.comments.add(sc3);
	}





	/**
	 *  method is designed to take the slider values form the skill window if this has already happened it just saves new value, if not it creates a new skill and saves it into arraylist
	 * @param pass1
	 * @param pass2
	 * @param pass3
	 * @param kick1
	 * @param kick2
	 * @param kick3
	 * @param kick4
	 * @param tack1
	 * @param tack2
	 * @param tack3
	 * @param tack4
	 * @param sru
	 *
	 */
	public void saveSkills(JSlider pass1,JSlider pass2,JSlider pass3,JSlider kick1, JSlider kick2, JSlider kick3, JSlider kick4,JSlider tack1, JSlider tack2, JSlider tack3, JSlider tack4, int sru){

		System.out.println("save passing skills slider pass1: " + pass1.getValue());			//some console testing
		System.out.println("skills empty? -" + m.skills.isEmpty() + m.skills.size());			
		boolean inSkill = false;																//boolean intialisation

		for(Skill s: m.skills){																	//if the players id found in skill object arraylist = true
			if(s.getUserId() == sru){
				inSkill = true;
			}
		}
		if(inSkill == false){																	//if not found, create new skills for this user
			Skill pStandard  = new Skill(1, pass1.getValue(), "passing Standard",sru);
			m.skills.add(pStandard);
			Skill pSpin  = new Skill(1, pass2.getValue(), "passing Spin",sru);
			m.skills.add(pSpin);
			Skill pPop  = new Skill(1, pass3.getValue(), "passing Pop",sru);
			m.skills.add(pPop);
			Skill kFront  = new Skill(2, kick1.getValue(), "Kicking Front",sru);
			m.skills.add(kFront);
			Skill kRear  = new Skill(2, kick2.getValue(), "Kicking Rear",sru);
			m.skills.add(kRear);
			Skill kSide  = new Skill(2, kick3.getValue(), "Kicking Side",sru);
			m.skills.add(kSide);
			Skill kScrabble  = new Skill(2, kick4.getValue(), "Kicking Scrabble",sru);
			m.skills.add(kScrabble);
			Skill t1  = new Skill(3, tack1.getValue(), "Tackling Drop",sru);
			m.skills.add(t1);
			Skill t2  = new Skill(3, tack2.getValue(), "Tackling Punt",sru);
			m.skills.add(t2);
			Skill t3  = new Skill(3, tack3.getValue(), "Tackling Grubber",sru);
			m.skills.add(t3);
			Skill t4  = new Skill(3, tack4.getValue(), "Tackling Goal",sru);
			m.skills.add(t4);
		}


																							//Validation
		if(m.skills.isEmpty()){																//if skill arraylist is empty create new arraylist
			Skill pStandard  = new Skill(1, pass1.getValue(), "passing Standard",sru);		//this shouldn't need to be done if Json works correctly
			m.skills.add(pStandard);
			Skill pSpin  = new Skill(1, pass2.getValue(), "passing Spin",sru);
			m.skills.add(pSpin);
			Skill pPop  = new Skill(1, pass3.getValue(), "passing Pop",sru);
			m.skills.add(pPop);
			Skill kFront  = new Skill(2, kick1.getValue(), "Kicking Front",sru);
			m.skills.add(kFront);
			Skill kRear  = new Skill(2, kick2.getValue(), "Kicking Rear",sru);
			m.skills.add(kRear);
			Skill kSide  = new Skill(2, kick3.getValue(), "Kicking Side",sru);
			m.skills.add(kSide);
			Skill kScrabble  = new Skill(2, kick4.getValue(), "Kicking Scrabble",sru);
			m.skills.add(kScrabble);
			Skill t1  = new Skill(3, tack1.getValue(), "Tackling Drop",sru);
			m.skills.add(t1);
			Skill t2  = new Skill(3, tack2.getValue(), "Tackling Punt",sru);
			m.skills.add(t2);
			Skill t3  = new Skill(3, tack3.getValue(), "Tackling Grubber",sru);
			m.skills.add(t3);
			Skill t4  = new Skill(3, tack4.getValue(), "Tackling Goal",sru);
			m.skills.add(t4);
		}else{
			for(Skill s: m.skills){		//if not empty but user was found edits their skills in objects, doesnt need to dreate new ones

				System.out.println("savePassingSkills() testing - sru: " + sru + "\nuserId: " + s.getUserId()  );

				if(sru == s.getUserId() && s.getSkillName().trim().toLowerCase().equals("Passing Standard".toLowerCase().trim())){
					s.setValue(pass1.getValue());
					one = true;
				}
				if(sru == s.getUserId() && s.getSkillName().trim().toLowerCase().equals("Passing Spin".toLowerCase().trim())){
					s.setValue(pass2.getValue());
					two = true;
				}
				if(sru == s.getUserId() && s.getSkillName().trim().toLowerCase().equals("Passing Pop".toLowerCase().trim())){
					s.setValue(pass3.getValue());
					three = true;
				}
				if(sru == s.getUserId() && s.getSkillName().trim().toLowerCase().equals("Kicking Front".toLowerCase().trim())){
					s.setValue(kick1.getValue());
					four = true;
				}
				if(sru == s.getUserId() && s.getSkillName().trim().toLowerCase().equals("Kicking Rear".toLowerCase().trim())){
					s.setValue(kick2.getValue());
					five = true;
				}
				if(sru == s.getUserId() && s.getSkillName().trim().toLowerCase().equals("Kicking Side".toLowerCase().trim())){
					s.setValue(kick3.getValue());
					six = true;
				}
				if(sru == s.getUserId() && s.getSkillName().trim().toLowerCase().equals("Kicking Scrabble".toLowerCase().trim())){
					s.setValue(kick4.getValue());
					seven = true;
				}
				if(sru == s.getUserId() && s.getSkillName().trim().toLowerCase().equals("Tackling Drop".toLowerCase().trim())){
					s.setValue(tack1.getValue());
					eight = true;
				}
				if(sru == s.getUserId() && s.getSkillName().trim().toLowerCase().equals("Tackling Punt".toLowerCase().trim())){
					s.setValue(tack2.getValue());
					nine = true;
				}
				if(sru == s.getUserId() && s.getSkillName().toLowerCase().trim().equals("Tackling Grubber".trim().toLowerCase())){
					s.setValue(tack3.getValue());
					ten = true;
				}
				if(sru == s.getUserId() && s.getSkillName().toLowerCase().trim().equals("Tackling Goal".trim().toLowerCase())){
					s.setValue(tack4.getValue());
					eleven = true;	
				}
			}

			System.out.println(one);											//bunch of testing/validation
			System.out.println(two);
			System.out.println(three);
			System.out.println(four);
			System.out.println(five);
			System.out.println(six);
			System.out.println(seven);
			System.out.println(eight);
			System.out.println(nine);
			System.out.println(ten);
			System.out.println(eleven);

		}

		for(Skill s: m.skills){
			System.out.println(s.getSkillName());
		}
		//System.out.println("\nStandard" + m.skills.get(0).getValue() + "\nSpin" + pass2.getValue() + "\nPop" + pass3.getValue());
	}


	/**
	 * gets the user id 
	 * @param playerString
	 * @return int userId
	 * 
	 */
	public int getTheId(String playerString){
		int userId = 0;

		for(Player p: tempPlayer){
			if(playerString.equals(p.getName())){
				userId = p.getSruNo();
			}
		}
		return userId;

	}

	
	/**
	 * Created to produce skill data for users on the viewSkills page
	 * @param name
	 * @return String skillInfo
	 */
	public String getSkills(String name){


		int nameId =  getTheId(name);
		System.out.println("getSkills testing: " + nameId);
		String temp = null;
		String skillInfo = null;



		for(Skill s: m.skills){

			if(s.getUserId() == nameId){
				temp = "\n" + s.getSkillName() + ": " + s.getValue();


				skillInfo = skillInfo + temp;


				System.out.println(skillInfo);
			}
		}
		return skillInfo;

	}

	/**
	 * Method gets comments to return to the skillWindow
	 * @param name
	 * @param cat
	 * @return String commentInfo
	 */
	public String getComments(String name,String cat){
		int nameId = getTheId(name);
		String temp = null;
		String commentInfo = null;

		for(SkillCategory sc: m.comments){
			if(sc.getSru() == nameId){
				System.out.println("getting comments");
				if(sc.getCategory() == cat ){
					commentInfo = sc.getComments();
					System.out.println(commentInfo);
				}
			}
		}
		return commentInfo ;

	}
}
