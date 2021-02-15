package tab2xml;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Panel;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Checkbox;
import java.awt.Font;

public class GUI {
	JTextArea viewerText;
	private JFrame frmMusicTabTo;

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
		frmMusicTabTo.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMusicTabTo = new JFrame();
		frmMusicTabTo.setTitle("Music Tab to XML File Convertor");
		frmMusicTabTo.setBounds(0, 0, 1080, 708);
		frmMusicTabTo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMusicTabTo.getContentPane().setLayout(null);
		
		JTabbedPane tabPane = new JTabbedPane(JTabbedPane.TOP);
		tabPane.setBounds(10, 32, 1053, 34);
		frmMusicTabTo.getContentPane().add(tabPane);
		
		JPanel menuPane = new JPanel();
		menuPane.setBounds(10, 11, 1053, 18);
		frmMusicTabTo.getContentPane().add(menuPane);
		
		Panel filesPanel = new Panel();
		filesPanel.setBounds(10, 68, 215, 593);
		frmMusicTabTo.getContentPane().add(filesPanel);
		filesPanel.setLayout(null);
		
		Panel optionPanel = new Panel();
		optionPanel.setBounds(848, 68, 215, 593);
		frmMusicTabTo.getContentPane().add(optionPanel);
		optionPanel.setLayout(null);
		
		JButton convertBtn = new JButton("Convert");
		convertBtn.setBounds(43, 25, 128, 25);
		convertBtn.addActionListener(new optionListener(this));
		optionPanel.add(convertBtn);
		
		JButton fileBtn = new JButton("Select File");
		fileBtn.setBounds(43, 61, 128, 25);
		fileBtn.addActionListener(new optionListener(this));
		optionPanel.add(fileBtn);
		
		Checkbox checkbox = new Checkbox("New check box");
		checkbox.setBounds(10, 106, 92, 21);
		optionPanel.add(checkbox);
		
		Checkbox checkbox_1 = new Checkbox("New check box");
		checkbox_1.setBounds(108, 106, 92, 21);
		optionPanel.add(checkbox_1);
		
		Checkbox checkbox_2 = new Checkbox("New check box");
		checkbox_2.setBounds(10, 134, 92, 21);
		optionPanel.add(checkbox_2);
		
		Checkbox checkbox_3 = new Checkbox("New check box");
		checkbox_3.setBounds(108, 134, 92, 21);
		optionPanel.add(checkbox_3);
		
		Checkbox checkbox_4 = new Checkbox("New check box");
		checkbox_4.setBounds(10, 161, 92, 21);
		optionPanel.add(checkbox_4);
		
		Checkbox checkbox_5 = new Checkbox("New check box");
		checkbox_5.setBounds(108, 161, 92, 21);
		optionPanel.add(checkbox_5);
		
		viewerText = new JTextArea(30,30);
		viewerText.setFont(new Font("Courier New", Font.PLAIN, 12));
		
		JScrollPane viewerPane = new JScrollPane(viewerText,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		viewerPane.setBounds(231, 68, 611, 592);
		frmMusicTabTo.getContentPane().add(viewerPane);
	}
	
	public String getText() {
		return this.viewerText.getText();
	}
	
	public void setText(String text) {
		this.viewerText.setText(text);
	}
}

