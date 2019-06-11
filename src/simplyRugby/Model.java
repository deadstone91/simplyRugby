package simplyRugby;

import static java.time.LocalDate.parse;

	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.Writer;
	import java.time.LocalDate;
	import java.util.ArrayList;
	import com.google.gson.Gson;
	import com.google.gson.GsonBuilder;
	import com.google.gson.reflect.TypeToken;
	
public class Model {
	ArrayList<Player> players;
	ArrayList<Skill> skills;
	ArrayList<Squad> squ;
	ArrayList<SkillCategory> comments;
	
	/**
	 * initialise stuff needed for the whole class
	 */
		Model(){
			
			players = new ArrayList<Player>();
			skills = new ArrayList<Skill>();
			squ = new ArrayList<Squad>();			
			comments = new ArrayList<>();
			
			thePlayers();
			createSquads();
			//jSon();
			
			

		}
			
			
		/**
		 * Creates player and adds them into arrayList
		 */
		public void thePlayers(){
		
			SnrPlayer snr1 = new SnrPlayer("James Bell", "33 That Street Somewhere", "hg11 gfd", 123456, parse("1990-12-01"), "07888888888", "07888888888", "jamesb@that.com", "random health issues", "Dr Brown Bear", "01335 847854", "forward",54323, "Ringa Bell", "07888458745" );
			SnrPlayer snr2 = new SnrPlayer("Robert Small", "1 some street, kirkcaldy", "ky6 5gh", 123457, parse("2000-01-01"), null, "07564278954", "rs234@g.co.uk", "No Health issues", "Dr Tiger Paws", "01335 847853", "forward",54323, "Rick Shaw", "07258741238");
			SnrPlayer snr3 = new SnrPlayer("sean Ball", "15 Another Street, dalgety bay", "Db15 6as", 123458, parse("1995-11-05"), null, "07658231459", "ballin@blueyonder.com", "Epelepsy", "Dr Brown Bear", "01335 847854", "Scrum half",54322, "Throwa Ball", "07596571200");
			SnrPlayer snr4 = new SnrPlayer("Robert Abel", "15 Another Street, dalgety bay", "Db15 6as", 123459, parse("1995-11-05"), null, "07658231459", "ballin@blueyonder.com", "Epelepsy", "Dr Brown Bear", "01335 847854", "Scrum half",0, "Throwa Ball", "07596571200");
			SnrPlayer snr5 = new SnrPlayer("Euan Crawley", "15 Another Street, dalgety bay", "Db15 6as", 123460, parse("1995-11-05"), null, "07658231459", "ballin@blueyonder.com", "Epelepsy", "Dr Brown Bear", "01335 847854", "Scrum half",54321, "Throwa Ball", "07596571200");
			SnrPlayer snr6 = new SnrPlayer("Derrick Lim", "15 Another Street, dalgety bay", "Db15 6as", 123461, parse("1995-11-05"), null, "07658231459", "ballin@blueyonder.com", "Epelepsy", "Dr Brown Bear", "01335 847854", "Scrum half",54323, "Throwa Ball", "07596571200");
			SnrPlayer snr7 = new SnrPlayer("Andrei Bowden", "15 Another Street, dalgety bay", "Db15 6as", 123462, parse("1995-11-05"), null, "07658231459", "ballin@blueyonder.com", "Epelepsy", "Dr Brown Bear", "01335 847854", "Scrum half",54323, "Throwa Ball", "07596571200");
			SnrPlayer snr8 = new SnrPlayer("Kavan Mckenzie", "15 Another Street, dalgety bay", "Db15 6as", 123463, parse("1995-11-05"), null, "07658231459", "ballin@blueyonder.com", "Epelepsy", "Dr Brown Bear", "01335 847854", "Scrum half",54321, "Throwa Ball", "07596571200");
			SnrPlayer snr9 = new SnrPlayer("Zak Laing", "15 Another Street, dalgety bay", "Db15 6as", 123464, parse("1995-11-05"), null, "07658231459", "ballin@blueyonder.com", "Epelepsy", "Dr Brown Bear", "01335 847854", "Scrum half",54321, "Throwa Ball", "07596571200");
			SnrPlayer snr10 = new SnrPlayer("Charley Hartley", "15 Another Street, dalgety bay", "Db15 6as", 123465, parse("1995-11-05"), null, "07658231459", "ballin@blueyonder.com", "Epelepsy", "Dr Brown Bear", "01335 847854", "Scrum half",54322, "Throwa Ball", "07596571200");
			
			JnrPlayer jnr1 = new JnrPlayer("Jeff Mulen", "47 Fife College, Kirkcaldy", "ky5 7hf", 123476, parse("2009-08-12"), null, "07123876572", "jeff@ygritte.uk", "Baldness", "Dr Jennifer Goodwan", "01335 741596", null,54321,"father", "47 Fife College, Kirkcaldy", "07853697415", "Gwendaline Mulen", "Mother", "47 Fife College, Kirkcaldy", "07965423841", "43 Somewhere street", "Father");
			JnrPlayer jnr2 = new JnrPlayer("Silas Fletcher", "47 Fife College, Kirkcaldy", "ky5 7hf", 123477, parse("2009-08-12"), null, "07123876572", "jeff@ygritte.uk", "Baldness", "Dr Jennifer Goodwan", "01335 741596", null,54321,"father", "47 Fife College, Kirkcaldy", "07853697415", "Gwendaline Mulen", "Mother", "47 Fife College, Kirkcaldy", "07965423841", "43 Somewhere street", "Father");
			JnrPlayer jnr3 = new JnrPlayer("Ozan Spence", "47 Fife College, Kirkcaldy", "ky5 7hf", 123478, parse("2009-08-12"), null, "07123876572", "jeff@ygritte.uk", "Baldness", "Dr Jennifer Goodwan", "01335 741596", null,54321,"father", "47 Fife College, Kirkcaldy", "07853697415", "Gwendaline Mulen", "Mother", "47 Fife College, Kirkcaldy", "07965423841", "43 Somewhere street", "Father");
			JnrPlayer jnr4 = new JnrPlayer("Ahmed Rocha", "47 Fife College, Kirkcaldy", "ky5 7hf", 123479, parse("2009-08-12"), null, "07123876572", "jeff@ygritte.uk", "Baldness", "Dr Jennifer Goodwan", "01335 741596", null,54321,"father", "47 Fife College, Kirkcaldy", "07853697415", "Gwendaline Mulen", "Mother", "47 Fife College, Kirkcaldy", "07965423841", "43 Somewhere street", "Father");
			JnrPlayer jnr5 = new JnrPlayer("Barry Bateman", "47 Fife College, Kirkcaldy", "ky5 7hf", 123480, parse("2009-08-12"), null, "07123876572", "jeff@ygritte.uk", "Baldness", "Dr Jennifer Goodwan", "01335 741596", null,54321,"father", "47 Fife College, Kirkcaldy", "07853697415", "Gwendaline Mulen", "Mother", "47 Fife College, Kirkcaldy", "07965423841", "43 Somewhere street", "Father");
			JnrPlayer jnr6 = new JnrPlayer("Anika Meza", "47 Fife College, Kirkcaldy", "ky5 7hf", 123481, parse("2009-08-12"), null, "07123876572", "jeff@ygritte.uk", "Baldness", "Dr Jennifer Goodwan", "01335 741596", null,54321,"father", "47 Fife College, Kirkcaldy", "07853697415", "Gwendaline Mulen", "Mother", "47 Fife College, Kirkcaldy", "07965423841", "43 Somewhere street", "Father");
			JnrPlayer jnr7 = new JnrPlayer("Lowen Bolton", "47 Fife College, Kirkcaldy", "ky5 7hf", 123482, parse("2009-08-12"), null, "07123876572", "jeff@ygritte.uk", "Baldness", "Dr Jennifer Goodwan", "01335 741596", null,54321,"father", "47 Fife College, Kirkcaldy", "07853697415", "Gwendaline Mulen", "Mother", "47 Fife College, Kirkcaldy", "07965423841", "43 Somewhere street", "Father");
			JnrPlayer jnr8 = new JnrPlayer("Isaiah Robin", "47 Fife College, Kirkcaldy", "ky5 7hf", 123483, parse("2009-08-12"), null, "07123876572", "jeff@ygritte.uk", "Baldness", "Dr Jennifer Goodwan", "01335 741596", null,54321,"father", "47 Fife College, Kirkcaldy", "07853697415", "Gwendaline Mulen", "Mother", "47 Fife College, Kirkcaldy", "07965423841", "43 Somewhere street", "Father");
			JnrPlayer jnr9 = new JnrPlayer("Oscar Dunn", "47 Fife College, Kirkcaldy", "ky5 7hf", 123484, parse("2009-08-12"), null, "07123876572", "jeff@ygritte.uk", "Baldness", "Dr Jennifer Goodwan", "01335 741596", null,54321,"father", "47 Fife College, Kirkcaldy", "07853697415", "Gwendaline Mulen", "Mother", "47 Fife College, Kirkcaldy", "07965423841", "43 Somewhere street", "Father");
			JnrPlayer jnr10 = new JnrPlayer("Raheem Barton", "47 Fife College, Kirkcaldy", "ky5 7hf", 123485, parse("2009-08-12"), null, "07123876572", "jeff@ygritte.uk", "Baldness", "Dr Jennifer Goodwan", "01335 741596", null,54321,"father", "47 Fife College, Kirkcaldy", "07853697415", "Gwendaline Mulen", "Mother", "47 Fife College, Kirkcaldy", "07965423841", "43 Somewhere street", "Father");
			
			
			players.add(snr1);
			players.add(snr2);
			players.add(snr3);
			players.add(snr4);
			players.add(snr5);
			players.add(snr6);
			players.add(snr7);
			players.add(snr8);
			players.add(snr9);
			players.add(snr10);
			players.add(jnr1);
			players.add(jnr2);
			players.add(jnr3);
			players.add(jnr4);
			players.add(jnr5);
			players.add(jnr6);
			players.add(jnr7);
			players.add(jnr8);
			players.add(jnr9);
			players.add(jnr10);
		
		}
		
		/**
		 * 
		 */
		void jSon(){
			String j = "";
			Gson g = new GsonBuilder().setPrettyPrinting().create();
			j = g.toJson(skills);
			
			try(Writer w = new FileWriter("Skills.json")){
				g.toJson(skills,w);
				System.out.println("Written to file");
			}catch(IOException e){
				System.out.println("error writng to file");
				e.printStackTrace();
			}
		}
		
		/**
		 * Method creates a json file for comments, allowing for persistant data 
		 */
		void jSon2(){
			String j = "";
			Gson g = new GsonBuilder().setPrettyPrinting().create();
			j = g.toJson(comments);
			
			try(Writer w = new FileWriter("Comments.json")){
				g.toJson(comments,w);
				System.out.println("Written to file");
			}catch(IOException e){
				System.out.println("error writng to file");
				e.printStackTrace();
			}
		}
		
		/**
		 * Creates the Squads that players are added to 
		 */
		public void createSquads(){
			System.out.println("this happens");					//some testing
			Squad s1 = new Squad("Methil Magicians",54323);
			Squad squ1 = new Squad("Fife Rugby",54321);
			Squad squ2 = new Squad("Kinross Rugby",54322);
			
			squ.add(s1);
			squ.add(squ1);
			squ.add(squ2);
			System.out.println(squ.toString());				//more testing
			
			
		}
		/**
		 * Method used to check if thing are working
		 */
		public void testingSkill(){
			for(Skill s: skills){
				System.out.println("testing SKill " + s.getSkillName() + " " + s.getUserId());
			}
			
			
			
		}
	}


