package tab2xml;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI_2 implements ActionListener{

	private JFrame f;
	private JPanel p1, p2, p3;
	private JButton b1, b2;
	private JTextField text;
	private JLabel l;
	
	GUI_2 (String c) {
		
		// Panels
		p1 = new JPanel();
		p1.setPreferredSize(new Dimension(100,100));
		
		p2 = new JPanel();
		p2.setPreferredSize(new Dimension(100,100));
		
		p3 = new JPanel();
		p3.setPreferredSize(new Dimension(100,100));
		
		// Label
		l = new JLabel("Copy and Paste Tab or Select a File");
		l.setFont(new Font(null, Font.BOLD, 25));
		
		// Buttons
		b1 = new JButton("Submit");
		b1.addActionListener(this);
		b1.setFont(new Font(null, Font.BOLD, 25));
		
		b2 = new JButton("Select a File");
		b2.addActionListener(this);
		b2.setFont(new Font(null, Font.BOLD, 25));
		
		// Text Field
		text = new JTextField();
		text.setPreferredSize(new Dimension(250,40));
		text.setText("Paste tab here");
		
		// Frame
		f = new JFrame("Selected: " + c);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500,300);
		f.setLayout(new BorderLayout());
		f.setVisible(true);
		
		p1.add(text);
		p1.add(b1);
		p2.add(b2);
		p3.add(l);
		f.add(p3, BorderLayout.NORTH);
		f.add(p1, BorderLayout.CENTER);
		f.add(p2, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b2) {
			Parser parse = new Parser();
			parse.printline();
		}
		
		if (e.getSource() == b1) {
			f.dispose();
			System.out.println(text.getText());
		}
	}
}
