package tab2xml;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class GUI implements ActionListener{

	private JFrame f;
	private JPanel p1, p2, p3;
	private JButton b1, b2;
	private JTextArea text;
	private JLabel l;
	private JScrollPane s;
	
	GUI () {
		f = new JFrame("Music Tab to XML File Convertor");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000,500);
		f.setLayout(new BorderLayout());
		
		// Label
		l = new JLabel("Copy and Paste Tab or Select a File");
		l.setFont(new Font(null, Font.PLAIN, 25));
		
		// Panels
		p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p1.add(l);
		f.add(p1, BorderLayout.NORTH);
		
		p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		f.add(p2, BorderLayout.SOUTH);
		
		p3 = new JPanel();
		p3.setLayout(new FlowLayout());
		f.add(p3, BorderLayout.CENTER);
		// 
		
		// Buttons
		b1 = new JButton("Submit");
		b1.addActionListener(this);
		b1.setFont(new Font(null, Font.PLAIN, 15));
		
		b2 = new JButton("Select a File");
		b2.addActionListener(this);
		b2.setFont(new Font(null, Font.PLAIN, 15));
		
		
		// Text Area
		text = new JTextArea(20, 70);
		s = new JScrollPane(text,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		text.setText("Paste tab here");
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setBackground(Color.white);
		text.setBorder(BorderFactory.createBevelBorder(1));
		
		
		p3.add(s);
		p3.add(b1);
		p2.add(b2);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b2) {
			f.dispose();
			Parser parse = new Parser();
			Tab b = new Tab(parse.getLines());
			System.out.println(b.Type);
			for(int i = 0; i < b.nodes.size();i++) {
				for(int j = 0; j < b.nodes.get(i).nodes.length; j++) {
					for(int k = 0; k < b.nodes.get(i).nodes[j].length; k++) {
						System.out.print(b.nodes.get(i).nodes[j][k]);
					}
					System.out.println();
				}
				System.out.println();
			}
		}
		
		if (e.getSource() == b1) {
			f.dispose();
			String [] parse = text.getText().split("\n");
			ArrayList<Object> lines = new ArrayList<Object>();
			for(int i = 0; i < parse.length; i++) {
				lines.add(parse[i]);
			}
			
			Tab b = new Tab(lines);
			
			System.out.println(b.Type);
			for(int i = 0; i < b.nodes.size();i++) {
				for(int j = 0; j < b.nodes.get(i).nodes.length; j++) {
					for(int k = 0; k < b.nodes.get(i).nodes[j].length; k++) {
						System.out.print(b.nodes.get(i).nodes[j][k]);
					}
					System.out.println();
				}
				System.out.println();
			}
		}
	}
}
