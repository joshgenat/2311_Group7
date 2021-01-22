package tab2xml;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI_2 {

	private JFrame f;
	private JPanel p;
	private JButton b1, b2, b3;
	private JLabel lab;

	
	
	GUI_2 (String c) {
		f = new JFrame("Selected: " + c);
		f.setVisible(true);
		f.setSize(500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p = new JPanel();
		p.setLayout(null);
		p.setBackground(Color.DARK_GRAY);
		
		lab = new JLabel("Select an Instrument");
		
		b1 = new JButton("A");
		b2 = new JButton("B");
		b3 = new JButton("C");
		
		b1.setFont(new Font(null, Font.BOLD, 25));
		b2.setFont(new Font(null, Font.BOLD, 25));
		b3.setFont(new Font(null, Font.BOLD, 25));
		
		b1.setBounds(100, 20, 300, 50);
		b2.setBounds(100, 100, 300, 50);
		b3.setBounds(100, 180, 300, 50);
		
		b1.setForeground(Color.white);
		b1.setBackground(Color.GRAY);
		b2.setForeground(Color.white);
		b2.setBackground(Color.GRAY);
		b3.setForeground(Color.white);
		b3.setBackground(Color.GRAY);
		
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(lab);
		
		f.add(p);
	}
}
