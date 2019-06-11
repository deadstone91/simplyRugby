package simplyRugby;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Component;
import javax.swing.Box;
/**
 * allows skills to be viewed
 * @author Livingstone
 *
 */
public class ViewSkillsWindow extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Simple Window for skill information
	 * @param usersName
	 * @param c
	 */
	public ViewSkillsWindow(String usersName, Controller c) {
		setTitle("Skills for " + usersName );
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setText(c.getSkills(usersName));
		textPane.setBounds(10, 11, 414, 202);
		contentPane.add(textPane);
	}
}
