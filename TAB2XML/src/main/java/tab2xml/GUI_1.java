package tab2xml;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class GUI_1 implements ActionListener{
	
	
	private JFrame f;
	private JPanel p;
	private JButton b1, b2, b3;
	private JLabel lab;
	
	public GUI_1() {
		gui();
		
	}
	
	public void gui() {
		// Frame
		f = new JFrame("Select an Instrument");
		f.setVisible(true);
		f.setSize(500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Panels
		p = new JPanel();
		p.setLayout(null);
		p.setBackground(Color.DARK_GRAY);
		
		// Buttons
		b1 = new JButton("Guitar");
		b2 = new JButton("Drums");
		b3 = new JButton("Bass");
		
		b1.setFocusable(false);
		b2.setFocusable(false);
		b3.setFocusable(false);
		
		b1.setFont(new Font("Consolas", Font.BOLD, 25));
		b2.setFont(new Font("Consolas", Font.BOLD, 25));
		b3.setFont(new Font("DialogInput", Font.BOLD, 25));
		
		b1.setBounds(100, 20, 300, 50);
		b2.setBounds(100, 100, 300, 50);
		b3.setBounds(100, 180, 300, 50);
		
		b1.setForeground(Color.white);
		b1.setBackground(Color.GRAY);
		b2.setForeground(Color.white);
		b2.setBackground(Color.GRAY);
		b3.setForeground(Color.white);
		b3.setBackground(Color.GRAY);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		
		p.add(b1);
		p.add(b2);
//		p.add(b3);
		f.add(p);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String choice = b1.getText();
		String choice2 = b2.getText();
		String choice3 = b2.getText();
		
		if (e.getSource() == b1) {
			f.dispose();
			GUI_2 gui2 = new GUI_2(choice);
		}
		if (e.getSource() == b2) {
			f.dispose();
			GUI_2 gui2 = new GUI_2(choice2);
		}
		if (e.getSource() == b3) {
			f.dispose();
			GUI_2 gui2 = new GUI_2(choice3);
		}
	}

}
