package swingWorkers;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

public class MainFrame extends JFrame {
	
	private JLabel count1 = new JLabel("0");
	private JLabel statusLabel = new JLabel("Task not completed");
	private JButton startButton = new JButton("Start");
	
	public MainFrame(String title) {
		super(title);
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.fill = GridBagConstraints.NONE;
		
		
		
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				start();
				
			}
		});
		gc.gridx =0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		add(count1,gc);
		
		gc.gridx = 0;
        gc.gridy = 1;
        gc.weightx = 1;
        gc.weighty = 1;
		add(statusLabel,gc);
		
		gc.gridx = 0;
	    gc.gridy = 2;
	    gc.weightx = 1;
	    gc.weighty = 1;
		add(startButton,gc);
		
		setSize(200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
		
		
		
		
	}

	protected void start() {
		SwingWorker<Void,Void> worker = new SwingWorker<Void, Void>(){

			@Override
			protected Void doInBackground() throws Exception {
				for(int i =0;i<30;i++) {
					Thread.sleep(100);
					System.out.println("Hello "+ i);
				}
				return null;
			}
		};
		worker.execute();
	}

}
