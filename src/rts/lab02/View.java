package rts.lab02;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class View {

	private JFrame frame;
	private Controller controller;
	private JButton btnStart;
	private JButton btnStop;
	private JTextArea textArea = new JTextArea();

	
	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 466, 274);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{76, 0, 304, 0};
		gridBagLayout.rowHeights = new int[]{206, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
				
						controller = new Controller(textArea);
						
										
								JScrollPane scrollPane = new JScrollPane(textArea);
								textArea.setEditable(false);
								GridBagConstraints gbc_scrollPane = new GridBagConstraints();
								gbc_scrollPane.gridwidth = 3;
								gbc_scrollPane.fill = GridBagConstraints.BOTH;
								gbc_scrollPane.insets = new Insets(10, 10, 5, 0);
								gbc_scrollPane.gridx = 0;
								gbc_scrollPane.gridy = 0;
								frame.getContentPane().add(scrollPane, gbc_scrollPane);
								
										btnStart = new JButton("Start");
										btnStart.addActionListener(new ActionListener() {

											@Override
											public void actionPerformed(ActionEvent e) {
												controller.start();
												
												btnStart.setEnabled(false);
												btnStop.setEnabled(true);
											}
										});
										GridBagConstraints gbc_btnStart = new GridBagConstraints();
										gbc_btnStart.anchor = GridBagConstraints.NORTHWEST;
										gbc_btnStart.insets = new Insets(0, 10, 10, 5);
										gbc_btnStart.gridx = 0;
										gbc_btnStart.gridy = 1;
										frame.getContentPane().add(btnStart, gbc_btnStart);
								
										btnStop = new JButton("Stop");
										btnStop.setEnabled(false);
										btnStop.addActionListener(new ActionListener() {

											@Override
											public void actionPerformed(ActionEvent e) {
												controller.stop();
												btnStart.setEnabled(true);
												btnStop.setEnabled(false);

											}
										});
										GridBagConstraints gbc_btnStop = new GridBagConstraints();
										gbc_btnStop.insets = new Insets(0, 0, 0, 5);
										gbc_btnStop.anchor = GridBagConstraints.NORTHWEST;
										gbc_btnStop.gridx = 1;
										gbc_btnStop.gridy = 1;
										frame.getContentPane().add(btnStop, gbc_btnStop);
	}

}
