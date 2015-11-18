package com.freer.mappercolor;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jxl.read.biff.BiffException;


/**
 * 
 * map color computer interface
 *
 */
public class MainFrame extends JFrame {

	private static final long serialVersionUID = 5844827385596265817L;

	private JButton showButton = null;
	
	private Label label = null;
	private JTextField color1 = new JTextField("red", 5);
	private JTextField color2 = new JTextField("green", 5);
	private JTextField color3 = new JTextField("yellow", 5);
	private JTextField color4 = new JTextField("blue", 5);
	private JTextField number = new JTextField("", 5);
	
	private JButton selectFileButton = null;
	private Label viewFileLabel = new Label();
	
	private MapColorComputer mapColorComputer = new MapColorComputer();
	private FileResolver fileResolver = null;
	
	private int[][] adjacentMatrix;
	private String[] regions;
	
	
	public MainFrame() {
		// color set  panel
		JPanel colorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		colorPanel.setBorder(BorderFactory.createTitledBorder("Colors Set"));
		
		color1.setBounds(new Rectangle(30, 30, 80, 30));
		colorPanel.add(color1);
		color2.setBounds(new Rectangle(30, 30, 80, 30));
		colorPanel.add(color2);
		color3.setBounds(new Rectangle(30, 30, 80, 30));
		colorPanel.add(color3);
		color4.setBounds(new Rectangle(30, 30, 80, 30));
		colorPanel.add(color4);
		
		// file select  panel
		JPanel filePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		filePanel.setBorder(BorderFactory.createTitledBorder("Adjacent Matrix File"));
		selectFileButton = new JButton("Select File");
		selectFileButton.addActionListener(new SelectFileLisener());
		filePanel.add(selectFileButton);
		viewFileLabel.setSize(30, 20);
		filePanel.add(viewFileLabel);
		
		// number set  panel
		JPanel numberPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		numberPanel.setBorder(BorderFactory.createTitledBorder("Regions Number"));
		numberPanel.add(number);
		
		showButton = new JButton("Show Result");
		//Click to calculate mapcolor
		showButton.addActionListener(new ShowLisener());
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
		topPanel.add(colorPanel);
		topPanel.add(filePanel);
		topPanel.add(numberPanel);
		topPanel.add(showButton);
		
		// show map color result
		label = new Label("Result Info");
		
        Container c= this.getContentPane(); 
        c.add(topPanel, BorderLayout.NORTH); 
        c.add(label, BorderLayout.CENTER); 

		setSize(700, 500);
		setTitle("map color computer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200, 150);
    }
	
	/**
	 * 
	 * get four colors
	 * 
	 * @return
	 */
	public String[] getColors() {
		String[] colors = new String[4];
		colors[0] = color1.getText();
		colors[1] = color2.getText();
		colors[2] = color3.getText();
		colors[3] = color4.getText();
		return colors;
	}
	
	
	/**
	 * 
	 * get region number
	 * 
	 * @return
	 */
	public int getRegionsNumber() {
		String inputNum = this.number.getText();
		return Integer.parseInt(inputNum);
	}
	
	/**
	 *  
	 *  select file and read file info to create adjacency matrix data
	 * 
	 */
    class SelectFileLisener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser();
			int resule = fileChooser.showOpenDialog(new JPanel());
			if (resule == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				try {
					fileResolver = new FileResolver(file);
					viewFileLabel.setText(file.getName());
					number.setText(String.valueOf(fileResolver.readHeader().length));
					regions = fileResolver.readHeader();
					adjacentMatrix = fileResolver.readExcel();
				} catch (BiffException | IOException e1) {
					e1.printStackTrace();
				}
			}
        }
    }
	
    /**
     *
     * begin computer the map color and display result to the interface
     * 
     * Algorithms Detail  @See MapColorComputer 
     *
     */
    class ShowLisener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(showButton)){
            	String[] regionColors = getColors(); 
            	int[] colors = mapColorComputer.computerColor(getColors(), getRegionsNumber(), adjacentMatrix);
            	StringBuffer text = new StringBuffer("<html>Region Color <br>");
            	for(int i = 0; i < regions.length; i++) {
            		text.append(regions[i] + "                    " + regionColors[colors[i]] + "<br>");
            	}
            	text.append("</html>");
            	label.setText(text.toString());
            }
        }
    }
}
