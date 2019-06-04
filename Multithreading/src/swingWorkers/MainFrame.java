package swingWorkers;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame {
	
	private JLabel count1 = new JLabel("0");
	private JLabel statusLabel = new JLabel("Task not completed");
	private JButton startButton = new JButton("Start");
	
	public MainFrame(String title) {
		super(title);
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.fill = GridBagConstraints.NONE;
		
		gc.gridx =0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		add(count1,gc);
		
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				start();
				
			}
		});
		
		setSize(200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
		
		
		
		
	}

	protected void start() {
		System.out.println("Start..");
		
	}

}
