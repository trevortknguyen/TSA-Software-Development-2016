package org.ecclesia.demoGenetics;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * The management and creation of the Control Panel
 * 
 * @author Sammy Shin
 *
 */

public class ControlPanel extends JPanel {

	GridBagConstraints gbc = new GridBagConstraints();
	JButton b1;
	
	public ControlPanel()
	{	
		setLayout(new GridBagLayout());
		
		gbc.fill = GridBagConstraints.BOTH;
		
		b1 = new JButton("this");
		gbc.gridwidth = 4;
		gbc.gridx = 2;
		gbc.gridy = 4;
		add(b1, gbc);

	}
	
}