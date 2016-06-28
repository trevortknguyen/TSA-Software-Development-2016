package org.ecclesia.demoGenetics;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;

import org.ecclesia.demoTemplate.Demonstration;

/**
 * The functioning class that calls the GUI template and appends the proper
 * content to the content panel and the proper content to the control panel
 * 
 * @author Sammy Shin
 *
 */
public class CancerGenomicAnalysis extends Demonstration {
	private GeneticsLogic geneticsLogic;

	public CancerGenomicAnalysis() {
		super("Cancer Genetic Studies");
		this.setIntroduction(Demonstration.getInstructionsFromFile(new File("demoGenetics/introduction.txt")));
	}

	@Override
	public void run() {
		geneticsLogic = new GeneticsLogic();
		this.setContentPanel(new ContentPanel());
		this.setControlPanel(new ControlPanel());
	}

	@SuppressWarnings("serial")
	class ControlPanel extends JPanel {

		public ControlPanel() {
			createComponents();
		}

		private void createComponents() {

			GridLayout experimentLayout = new GridLayout(0, 2);
			setLayout(experimentLayout);

			JButton train = new JButton("Train Current Neural Network");
			JButton generate = new JButton("Generate New Neural Network");

			train.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					geneticsLogic.train();
				}
			});

			generate.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					geneticsLogic.setNetwork();
				}
			});

			add(train);
			add(generate);

		}

	}

	class ContentPanel extends JPanel {

		protected char[] ntSequence;

		public ContentPanel() {
			createComponents();
			ntSequence = new char[10];
		}

		private void createComponents() {
			// this.setLayout(new BorderLayout(0, 15));

			JLabel norm = new JLabel("Genetic Oncogene Analysis", JLabel.CENTER);
			norm.setFont(norm.getFont().deriveFont(Font.BOLD, 20f));
			add(norm, BorderLayout.NORTH);

			add(new JComponent() {
				{
					setLayout(new SpringLayout());
					JLabel fixed = new JLabel("Non-mutated EGFR gene:");
					add(fixed);

					for (Character c : "ATGCGACCCT".toCharArray()) {
						JLabel label = new JLabel(c.toString(), JLabel.CENTER);
						label.setFont(label.getFont().deriveFont(Font.BOLD));
						add(label);
					}

					JRadioButton[][] buttonArray = new JRadioButton[4][10];

					for (int i = 0; i < 10; i++) {
						ButtonGroup group = new ButtonGroup();
						for (int j = 0; j < 4; j++) {
							JRadioButton button = new JRadioButton();
							buttonArray[j][i] = button;

							final int index = j;
							final int seqIndex = i;

							button.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									char c;

									switch (index) {
									case 0:
										c = 'A';
										break;
									case 1:
										c = 'C';
										break;
									case 2:
										c = 'G';
										break;
									case 3:
									default:
										c = 'T';
										break;
									}

									ntSequence[seqIndex] = c;
									geneticsLogic.changeList(ntSequence);
								}
							});

							group.add(button);
						}
					}

					String nts = "ACGT";
					for (int i = 0; i < 4; i++) {
						JLabel label = new JLabel("" + nts.charAt(i));
						this.add(label);

						for (int j = 0; j < 10; j++) {
							this.add(buttonArray[i][j]);
						}
					}

					SpringUtilities.makeCompactGrid(this, 5, 11, 3, 3, 3, 3);
				}
			}, BorderLayout.SOUTH);
			
			JLabel results = new JLabel("Results: ");
			JButton generate = new JButton("Generate");
			
			
			generate.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					results.setText("Results: "+ Arrays.toString(geneticsLogic.changeList(ntSequence)));
				}
			});

			add(results);
			add(generate);
//			JTextPane modify = new JTextPane();
//			modify.setContentType("text/html");
//		//	modify.setText(Demonstration.getInstructionsFromFile(new File("demoGenetics/profile.txt")));
//			modify.setEditable(false);
//			modify.setBackground(this.getBackground());
//			// modify.setPreferredSize(new Dimension(0, 0));
//			add(modify, BorderLayout.CENTER);
		}
	}

}
