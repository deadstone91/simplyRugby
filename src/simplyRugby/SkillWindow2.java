package simplyRugby;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SkillWindow2 extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Constructor for skillWindow2 allowing creation of the window itself
	 * @param player
	 * @param squad
	 * @param c
	 * @param cpw
	 */
	public SkillWindow2(String player, ArrayList<Squad> squad, Controller c,ChoosePlayerWindow cpw) {
		
		ArrayList<Skill> tempSkill = c.m.skills;					
		ArrayList<JSlider> slide = new ArrayList<>();				//arrayLists
		
		
		
			
		
		setTitle("Player Skill Tracking of " + player);				//dynamic player heading
		setIconImage(Toolkit.getDefaultToolkit().getImage("\\GradedUnit\\icon\\Scottish_rugby_logo.svg.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 530, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 64, 494, 248);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Passing", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 300, 220);
		panel.add(panel_1);
		
		JSlider slrPass1 = new JSlider();
		for(Skill s: tempSkill){							///forEach 
			if(s.getSkillName().toLowerCase().equals("passing Standard".toLowerCase()) && s.getUserId() == c.getTheId(player)){ //use of validatation methods
				slrPass1.setValue(s.getValue());  			//set value as what is stored in skill object 
			}else{
				slrPass1.setValue(1);						//if doesnt exist set as 1
			}
		}
		slrPass1.setSnapToTicks(true);
		slrPass1.setPaintTicks(true);
		slrPass1.setPaintLabels(true);
		slrPass1.setMinorTickSpacing(1);
		slrPass1.setMinimum(1);
		slrPass1.setMaximum(5);
		slrPass1.setMajorTickSpacing(1);
		slrPass1.setBounds(90, 11, 200, 40);
		panel_1.add(slrPass1);
		slide.add(slrPass1);
		
		JLabel label_1 = new JLabel("Standard");
		label_1.setBounds(10, 11, 80, 14);
		panel_1.add(label_1);
		
		
		JLabel label_2 = new JLabel("Spin");
		label_2.setBounds(10, 62, 61, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Pop");
		label_3.setBounds(10, 113, 67, 14);
		panel_1.add(label_3);
		
		JSlider slrPass2 = new JSlider();
		for(Skill s: tempSkill){
			if(s.getSkillName().toLowerCase().equals("passing Spin".toLowerCase()) && s.getUserId() == c.getTheId(player)){
				slrPass1.setValue(s.getValue());
			}else{
				slrPass1.setValue(1);
			}
		}
		slrPass2.setSnapToTicks(true);
		slrPass2.setPaintTicks(true);
		slrPass2.setPaintLabels(true);
		slrPass2.setMinorTickSpacing(1);
		slrPass2.setMinimum(1);
		slrPass2.setMaximum(5);
		slrPass2.setMajorTickSpacing(1);
		slrPass2.setBounds(90, 62, 200, 40);
		panel_1.add(slrPass2);
		slide.add(slrPass2);
		
		JSlider slrPass3 = new JSlider();
		for(Skill s: tempSkill){
			if(s.getSkillName().toLowerCase().equals("passing Pop".toLowerCase()) && s.getUserId() == c.getTheId(player)){
				slrPass1.setValue(s.getValue());
			}else{
				slrPass1.setValue(1);
			}
		}
		slrPass3.setSnapToTicks(true);
		slrPass3.setPaintTicks(true);
		slrPass3.setPaintLabels(true);
		slrPass3.setMinorTickSpacing(1);
		slrPass3.setMinimum(1);
		slrPass3.setMaximum(5);
		slrPass3.setMajorTickSpacing(1);
		slrPass3.setBounds(90, 114, 200, 40);
		panel_1.add(slrPass3);
		slide.add(slrPass3);
		
		JLabel label_4 = new JLabel("Comments");
		label_4.setBounds(310, 33, 78, 14);
		panel.add(label_4);
		
		JTextArea comments1 = new JTextArea(c.getComments(player, "passing"));			//fill comments hopefully
		comments1.setLineWrap(true);
		comments1.setRows(10);
		comments1.setBounds(310, 58, 179, 162);
		panel.add(comments1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Kicking", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(0, 0, 300, 220);
		panel_2.add(panel_6);
		
		JLabel label_10 = new JLabel("Front");
		label_10.setBounds(10, 11, 44, 14);
		panel_6.add(label_10);
		
		JLabel label_11 = new JLabel("Rear");
		label_11.setBounds(10, 62, 44, 14);
		panel_6.add(label_11);
		
		JLabel label_12 = new JLabel("Side");
		label_12.setBounds(10, 114, 44, 14);
		panel_6.add(label_12);
		
		JLabel label_13 = new JLabel("Scrabble");
		label_13.setBounds(10, 165, 80, 14);
		panel_6.add(label_13);
		
		JSlider slrKick1 = new JSlider();
		for(Skill s: tempSkill){
			if(s.getSkillName().toLowerCase().equals("Kicking Front".toLowerCase()) && s.getUserId() == c.getTheId(player)){
				slrKick1.setValue(s.getValue());
			}else{
				slrKick1.setValue(1);
			}
		}
		slrKick1.setSnapToTicks(true);
		slrKick1.setPaintTicks(true);
		slrKick1.setPaintLabels(true);
		slrKick1.setMinorTickSpacing(1);
		slrKick1.setMinimum(1);
		slrKick1.setMaximum(5);
		slrKick1.setMajorTickSpacing(1);
		slrKick1.setBounds(90, 11, 200, 40);
		panel_6.add(slrKick1);
		slide.add(slrKick1);
		
		JSlider slrKick2 = new JSlider();
		for(Skill s: tempSkill){
			if(s.getSkillName().toLowerCase().equals("Kicking Rear".toLowerCase()) && s.getUserId() == c.getTheId(player)){
				slrKick2.setValue(s.getValue());
			}else{
				slrKick2.setValue(1);
			}
		}
		slrKick2.setSnapToTicks(true);
		slrKick2.setPaintTicks(true);
		slrKick2.setPaintLabels(true);
		slrKick2.setMinorTickSpacing(1);
		slrKick2.setMinimum(1);
		slrKick2.setMaximum(5);
		slrKick2.setMajorTickSpacing(1);
		slrKick2.setBounds(90, 62, 200, 40);
		panel_6.add(slrKick2);
		slide.add(slrKick2);
		
		JSlider slrKick3 = new JSlider();
		for(Skill s: tempSkill){
			if(s.getSkillName().toLowerCase().equals("Kicking Side".toLowerCase()) && s.getUserId() == c.getTheId(player)){
				slrKick3.setValue(s.getValue());
			}else{
			slrKick3.setValue(1);
			}
		}
		slrKick3.setSnapToTicks(true);
		slrKick3.setPaintTicks(true);
		slrKick3.setPaintLabels(true);
		slrKick3.setMinorTickSpacing(1);
		slrKick3.setMinimum(1);
		slrKick3.setMaximum(5);
		slrKick3.setMajorTickSpacing(1);
		slrKick3.setBounds(90, 114, 200, 40);
		panel_6.add(slrKick3);
		slide.add(slrKick3);
		
		JSlider slrKick4 = new JSlider();
		for(Skill s: tempSkill){
			if(s.getSkillName().toLowerCase().equals("Kicking Scrabble".toLowerCase()) && s.getUserId() == c.getTheId(player)){
				slrKick4.setValue(s.getValue());
			}else{
				slrKick4.setValue(1);
			}
		}
		slrKick4.setSnapToTicks(true);
		slrKick4.setPaintTicks(true);
		slrKick4.setPaintLabels(true);
		slrKick4.setMinorTickSpacing(1);
		slrKick4.setMinimum(1);
		slrKick4.setMaximum(5);
		slrKick4.setMajorTickSpacing(1);
		slrKick4.setBounds(90, 169, 200, 40);
		panel_6.add(slrKick4);
		slide.add(slrKick4);
		
		JLabel lblComments = new JLabel("Comments");
		lblComments.setBounds(310, 33, 78, 14);
		panel_2.add(lblComments);
		
		JTextArea comments2 = new JTextArea(c.getComments(player, "kicking"));
		comments2.setLineWrap(true);
		comments2.setRows(20);
		comments2.setBounds(310, 58, 179, 162);
		panel_2.add(comments2);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Tackling", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(0, 0, 300, 220);
		panel_3.add(panel_5);
		
		JLabel label_5 = new JLabel("Drop");
		label_5.setBounds(10, 11, 44, 14);
		panel_5.add(label_5);
		
		JLabel label_6 = new JLabel("Punt");
		label_6.setBounds(10, 62, 44, 14);
		panel_5.add(label_6);
		
		JLabel label_7 = new JLabel("Grubber");
		label_7.setBounds(10, 114, 64, 14);
		panel_5.add(label_7);
		
		JLabel label_8 = new JLabel("Goal");
		label_8.setBounds(10, 169, 44, 14);
		panel_5.add(label_8);
		
		JSlider slrTack1 = new JSlider();
		for(Skill s: tempSkill){
			if(s.getSkillName().toLowerCase().equals("Tackling Drop".toLowerCase()) && s.getUserId() == c.getTheId(player)){
				slrTack1.setValue(s.getValue());
			}else{
				slrTack1.setValue(1);
			}
		}
		
		slrTack1.setSnapToTicks(true);
		slrTack1.setPaintTicks(true);
		slrTack1.setPaintLabels(true);
		slrTack1.setMinorTickSpacing(1);
		slrTack1.setMinimum(1);
		slrTack1.setMaximum(5);
		slrTack1.setMajorTickSpacing(1);
		slrTack1.setBounds(90, 11, 200, 40);
		panel_5.add(slrTack1);
		slide.add(slrTack1);
		
		JSlider slrTack2 = new JSlider();
		for(Skill s: tempSkill){
			if(s.getSkillName().toLowerCase().equals("Tackling Punt".toLowerCase()) && s.getUserId() == c.getTheId(player)){
				slrTack2.setValue(s.getValue());
			}else{
				slrTack2.setValue(1);
			}
		}
		
		slrTack2.setSnapToTicks(true);
		slrTack2.setPaintTicks(true);
		slrTack2.setPaintLabels(true);
		slrTack2.setMinorTickSpacing(1);
		slrTack2.setMinimum(1);
		slrTack2.setMaximum(5);
		slrTack2.setMajorTickSpacing(1);
		slrTack2.setBounds(90, 62, 200, 40);
		panel_5.add(slrTack2);
		slide.add(slrTack2);
		
		JSlider slrTack3 = new JSlider();
		for(Skill s: tempSkill){
			if(s.getSkillName().toLowerCase().equals("Tackling Grubber".toLowerCase()) && s.getUserId() == c.getTheId(player)){
				slrTack3.setValue(s.getValue());
			}else{
				slrTack3.setValue(1);
			}
		}
		
		slrTack3.setSnapToTicks(true);
		slrTack3.setPaintTicks(true);
		slrTack3.setPaintLabels(true);
		slrTack3.setMinorTickSpacing(1);
		slrTack3.setMinimum(1);
		slrTack3.setMaximum(5);
		slrTack3.setMajorTickSpacing(1);
		slrTack3.setBounds(90, 114, 200, 40);
		panel_5.add(slrTack3);
		slide.add(slrTack3);
		
		JSlider slrTack4 = new JSlider();
		for(Skill s: tempSkill){
			if(s.getSkillName().toLowerCase().equals("Tackling Goal".toLowerCase()) && s.getUserId() == c.getTheId(player)){
				slrTack4.setValue(s.getValue());
			}else{
				slrTack4.setValue(1);
			}
		}
		
		slrTack4.setSnapToTicks(true);
		slrTack4.setPaintTicks(true);
		slrTack4.setPaintLabels(true);
		slrTack4.setMinorTickSpacing(1);
		slrTack4.setMinimum(1);
		slrTack4.setMaximum(5);
		slrTack4.setMajorTickSpacing(1);
		slrTack4.setBounds(90, 169, 200, 40);
		panel_5.add(slrTack4);
		slide.add(slrTack4);
		
		JTextArea comments3 = new JTextArea(c.getComments(player, "tackling"));
		comments3.setLineWrap(true);
		comments3.setRows(20);
		comments3.setBounds(310, 58, 179, 162);
		panel_3.add(comments3);
		
		JLabel label = new JLabel("Comments");
		label.setBounds(310, 33, 78, 14);
		panel_3.add(label);
		
		JButton btnEnterData = new JButton("Save");						//button that does all the work
		btnEnterData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean save = openDialog(player);   //if yes is pressed save = true
				int sru = c.findSruNo(player);
				System.out.println("JButton \"save\" - the sru is: " + sru + "save Bool: " + save);
				
				if(save == true){									//this code saves all that is in this window
					System.out.println("This saves line 379\nslrPass " + slrPass1.getValue());
					c.saveSkills(slrPass1,slrPass2,slrPass3,slrKick1,slrKick2,slrKick3,slrKick4,slrTack1, slrTack2, slrTack3, slrTack4,sru);
					c.saveComments(comments1, comments2, comments3,c.getTheId(player));
					System.out.println("saved");
					
					//cpw.btnViewSkills.setEnabled(true);
					c.m.jSon();						//some json saving
					c.m.jSon2();
					
					c.m.testingSkill();				//testing again
					dispose();
					
				}
				
				
			}
		});
		btnEnterData.setBounds(387, 323, 117, 23);
		contentPane.add(btnEnterData);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(154, 11, 350, 67);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		
		
		
		JLabel lblName = new JLabel("NAME: " + player);
		lblName.setBounds(10, 11, 132, 14);
		panel_4.add(lblName);
		
		
		JLabel lblSquad = new JLabel("SQUAD: " + (c.whichSquad()));
		lblSquad.setBounds(152, 11, 188, 14);
		panel_4.add(lblSquad);
		
		JLabel lblSruNumber = new JLabel("SRU NO: " +(Integer.toString(c.getTheId(player))));
		lblSruNumber.setBounds(77, 36, 178, 14);
		panel_4.add(lblSruNumber);
		
		
		
		
		
	}
	/**
	 * Dialog box asking if they sure they want to save
	 * @param p
	 * @return boolean
	 */
	protected Boolean openDialog(String p) {
			int optionPane1 = JOptionPane.showConfirmDialog(null, "Are YOU sure that you want to save   " + p + "Skills?", "Set skills", JOptionPane.YES_NO_OPTION);
			if (optionPane1 == JOptionPane.YES_OPTION){
					return true;
			}
			return false;
	}
	
	
}