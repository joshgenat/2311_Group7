package src.main.java.tab2mxl;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GUItest implements ActionListener{
	
	
	private JFrame f;
	private JPanel p;
	private JButton b1;
	private JButton b2;
	private JLabel lab;
	
	public GUItest() {
		gui();
	}
	
	public void gui() {
		f = new JFrame("Select an Instrument");
		f.setVisible(true);
		f.setSize(300, 200);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p = new JPanel();
		p.setLayout(null);
		p.setBackground(Color.green);
		
		lab = new JLabel("Select an Instrument");
		b1 = new JButton("Guitar");
		b2 = new JButton("Drums");
		b1.setBounds(70, 20, 160, 25);
		b2.setBounds(70, 50, 160, 25);
		
		b1.addActionListener(new GUItest());
		
		p.add(b1);
		p.add(b2);
		p.add(lab);
		
		f.add(p);
	}
	
	public static void main(String[] args) {
		GUItest test = new GUItest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String choice = b1.getText();
		System.out.println("Selected: " + choice);
	}

}
