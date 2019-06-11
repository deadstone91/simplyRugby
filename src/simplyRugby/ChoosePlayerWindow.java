package simplyRugby;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.ListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Code for creating the choose player window
 * @author Livingstone
 *
 */
public class ChoosePlayerWindow extends JFrame {

	private JPanel contentPane;
	ArrayList<String> things = new ArrayList<String>();
	DefaultListModel<String> model = new DefaultListModel<String>();
	JScrollPane scroll;
	JList<String> list;
	JButton btnChoosePlayer ;
	JButton btnViewSkills;
	int counter = 0;
/**
 * Code for creating the window
 * @param Controller c
 */
	public ChoosePlayerWindow(Controller c) {

		setTitle("Choose Your Player");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\me\\Google Drive\\college\\year 2 - HND\\block 2\\Graded unit\\GradedUnit\\icon\\Scottish_rugby_logo.svg.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);




		JComboBox comboSquad = new JComboBox();									//create combobox

		comboSquad.addActionListener(new ActionListener() {						//listening for an action
			public void actionPerformed(ActionEvent arg0) {
				counter++;
				model.removeAllElements();										//removes things from listbox
				System.out.println("does this" + counter );						//testing
				String combo = (String) comboSquad.getSelectedItem();			//get comoBox selectwd item
				System.out.println("Combo is " + combo);   					//testing if paramiters are passing
				things.clear();													//clear arraylist
				things = c.getPlayers(combo);									//fill arraylist
				System.out.println("things size is " + things.size()); 			
				for(String s: things){
					//System.out.println("Checking: " + s);
					model.addElement(s);										//add to listbox
				}
			}
		});
		//comboSquad.add("squads", null);
		comboSquad.setModel(new DefaultComboBoxModel(c.chooseSquad()));			//add squads to comboBox
		comboSquad.setBounds(10, 8, 300, 20);						
		contentPane.add(comboSquad);		

		list = new JList<String>(model);										//create listBox
		list.addListSelectionListener(new ListSelectionListener() {				//listening for action
			public void valueChanged(ListSelectionEvent e) {
				btnChoosePlayer.setEnabled(c.buttonState(list.getSelectedIndex()));	//enable button

			}
		});
		//System.out.println(info);
		list.setBounds(10, 39, 300, 163);
		scroll = new JScrollPane(list);
		scroll.setBounds(10, 39, 300, 163);
		contentPane.add(scroll);


		btnChoosePlayer = new JButton("Edit Skills");
		btnChoosePlayer.setEnabled(false);
		btnChoosePlayer.addActionListener(new ActionListener() {				//listen for action
			public void actionPerformed(ActionEvent arg0) {
				int lValue = list.getSelectedIndex();
				ListModel<String> model = list.getModel();						
				Object o =  model.getElementAt(lValue);
				//System.out.println("List Object " + o);	
				String s = (String) o;
				System.out.println(s);

				openDialog(s,c);												//dialog box to check if want to move on
			}
		});
		btnChoosePlayer.setBounds(320, 135, 124, 67);
		contentPane.add(btnChoosePlayer);



		btnViewSkills = new JButton("view skills");
		btnViewSkills.setEnabled(true);										//enable button
		btnViewSkills.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				int position = list.getSelectedIndex();
				ListModel<String> m = list.getModel();
				String person = null;

				try {														//exception handling
					person = m.getElementAt(position);						
				} catch (IndexOutOfBoundsException e1) {					//if person not chosen error box will appear
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,
							"No Player Choosen!",
							"Whoops",
							JOptionPane.ERROR_MESSAGE);
				}
				String theName = c.whichPlayer(person);


				try {
					System.out.println("The person is " + theName);
				} catch (IndexOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ViewSkillsWindow vsw = new ViewSkillsWindow(theName,c);				//create view skills window
				vsw.setVisible(true);
			}
		});
		btnViewSkills.setBounds(320, 99, 124, 23);
		contentPane.add(btnViewSkills);

	}
	/**
	 * Method to ask user if they are sure they want to edit/create skills for player
	 * @param s
	 * @param c
	 */
	protected void openDialog(String s, Controller c) {
		int optionPane1 = JOptionPane.showConfirmDialog(null, "Are YOU sure that you want to\n create/edit " + s + "\nSkills", "Edit player", JOptionPane.YES_NO_OPTION);
		if (optionPane1 == JOptionPane.YES_OPTION){
			String thePlayer = c.whichPlayer(s);	

			SkillWindow2 sw = new SkillWindow2(thePlayer,c.tempSquad,c,this);

			for(Skill sk: c.m.skills){							//forEach
				int userId = sk.getUserId();			
				for(Player pl: c.m.players){					//nested loops 
					if(thePlayer == pl.getName()){				
						if(sk.getUserId() == pl.getSruNo()){
							boolean exists = true;
						}

					}
				}
			}

			sw.setVisible(true);

		}
	}


}
