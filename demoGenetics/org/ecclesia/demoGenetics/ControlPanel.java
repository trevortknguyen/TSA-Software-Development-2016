package org.ecclesia.demoGenetics;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * The management and creation of the Control Panel
 * 
 * @author Sammy Shin
 *
 */

@SuppressWarnings("serial")
public class ControlPanel extends JPanel {

	
	public ControlPanel()
	{	
		createComponents();
	}
	
	private void createComponents() {
		GridBagConstraints gbc = new GridBagConstraints();
		JButton b1;
		JLabel train;
		JTextArea txt;
		setLayout(new GridBagLayout());
		
		gbc.fill = GridBagConstraints.BOTH;
		
		b1 = new JButton("Generate");
		train = new JLabel("Training Neural Networks");
		txt = new JTextArea("sdajsdbjasbdjasbdjqbwjdbqjwbdjqbwjdbqwjbdjqbwejqwbjqwbdjbqwjbqjbdjqbjqbdjqbdjwbqjbqjbdjqqjbdqwbqbjjdqbjb");
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridx = 2;
		gbc.gridy = 4;
		add(b1, gbc);
		
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		add(train, gbc);
		
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		gbc.weightx = .8;
		gbc.weighty = 0.8;
		gbc.gridx = 0;
		gbc.gridy = 2;
		txt.setEditable(false );
		add(txt, gbc);
	}
	
}