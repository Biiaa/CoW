package SecondInterFace;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BorrowedPub extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new BorrowedPub();
	}

	public BorrowedPub() {
		this.setSize(400, 300);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width / 2) - (this.getWidth() / 2);
		int yPos = (dim.height / 2) - (this.getHeight() / 2);
		this.setLocation(xPos, yPos);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 394, 59);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblYourBorrowedPublications = new JLabel("Your borrowed publications");
		lblYourBorrowedPublications.setBounds(98, 22, 184, 14);
		panel.add(lblYourBorrowedPublications);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBounds(28, 74, 330, 100);
		getContentPane().add(panel_1);
		
		JTable table = new JTable();
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(0, 0, 330, 100);
		panel_1.setLayout(null);
		panel_1.add(scroll);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBounds(145, 195, 89, 23);
		getContentPane().add(btnReturn);
		
		
		
		
		
		this.setVisible(true);
	}
}
