package SecondInterFace;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import InterFace.Welcome;

public class About extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel main;
	JPanel about;
	JPanel architecture;
	JPanel addmitance;
	JPanel history;
	JPanel library;

	public static void main(String[] args) {

		new About();
	}

	public About() {
		getContentPane().setBackground(new Color(222, 184, 135));
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(0, 0, 594, 66);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(About.class.getResource("/SecondInterFace/logo.png")));
		label.setBounds(10, 0, 60, 66);
		panel.add(label);

		JLabel lblCollegeOfWinterhold = new JLabel("College of Winterhold");
		lblCollegeOfWinterhold.setBackground(new Color(222, 184, 135));
		lblCollegeOfWinterhold.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblCollegeOfWinterhold.setForeground(Color.BLACK);
		lblCollegeOfWinterhold.setHorizontalAlignment(SwingConstants.CENTER);
		lblCollegeOfWinterhold.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCollegeOfWinterhold.setBounds(0, 23, 594, 32);
		panel.add(lblCollegeOfWinterhold);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY,
				Color.LIGHT_GRAY));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 67, 116, 293);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton addmitanceBt = new JButton("Addmitance");
		addmitanceBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.removeAll();
				main.add(addmitance);
				main.repaint();
				main.revalidate();
				
			}
		});
		addmitanceBt.setBounds(0, 80, 116, 30);
		panel_1.add(addmitanceBt);

		JButton architectureBt = new JButton("Architecture");
		architectureBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.removeAll();
				main.add(architecture);
				main.repaint();
				main.revalidate();
			}
			
		});
		architectureBt.setBounds(0, 130, 116, 30);
		panel_1.add(architectureBt);

		JButton historyBt = new JButton("History");
		historyBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.removeAll();
				main.add(history);
				main.repaint();
				main.revalidate();
			}
		});
		historyBt.setBounds(0, 180, 116, 30);
		panel_1.add(historyBt);

		JButton libraryBt = new JButton("Library");
		libraryBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.removeAll();
				main.add(library);
				main.repaint();
				main.revalidate();
			}
		});
		libraryBt.setBounds(0, 230, 116, 30);
		panel_1.add(libraryBt);

		JButton aboutBt = new JButton("About");
		aboutBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.removeAll();
				main.add(about);
				main.repaint();
				main.revalidate();
			}
		});
		aboutBt.setBounds(0, 30, 116, 30);
		panel_1.add(aboutBt);

		main = new JPanel();
		main.setBounds(135, 72, 449, 225);
		getContentPane().add(main);
		main.setLayout(new CardLayout(0, 0));

		about = new JPanel();
		about.setBackground(new Color(222, 184, 135));
		main.add(about, "name_169376622196860");
		about.setLayout(null);

		JTextArea txtrmagicIsA = new JTextArea();
		txtrmagicIsA.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		JScrollPane scroll = new JScrollPane(txtrmagicIsA);
		scroll.setBounds(0, 0, 449, 225);
		txtrmagicIsA.setCaretColor(Color.BLACK);
		txtrmagicIsA.setWrapStyleWord(true);
		txtrmagicIsA.setLineWrap(true);
		txtrmagicIsA.setText(
				"   The College of Winterhold is a school of magic located in the northern cliffs of Winterhold in the province "
						+ "of Skyrim.  The school is known to be the center of Magicka study in Skyrim and it was created by Arch-Mage Shalidor for this purpose only."
						+ "\r\n   \"Magic is a true power, not something to be shunned by commoners or treated as an amusing diversion by politicians. "
						+ "It shapes worlds, creates and destroys life... It deserves proper respect and study. The College is a place where we can focus"
						+ " on that, without the pressures of the world weighing down on us.\"\r\n\t    - Arch-Mage Savos Aren.\r\n\r\n   "
						+ "The College of Winterhold is a guild of mages centered in Skyrim. It is a faction of magic-users similar to the "
						+ "Mages Guild of Cyrodiil and Morrowind. When the Dragonborn appears, the current Arch-Mage is Savos Aren, with "
						+ "Mirabelle Ervine serving as the Master Wizard. During the faction's main quest, Tolfdir replaces her as Master "
						+ "Wizard. The College is located in the northern section of the city of Winterhold, in northern Skyrim. Instructors"
						+ " of each magical discipline reside within, offering training and various magical wares to members.");
		txtrmagicIsA.setEditable(false);
		about.add(scroll);

		addmitance = new JPanel();
		main.add(addmitance, "name_169437387191103");
		addmitance.setLayout(null);

		JTextArea addmitArea = new JTextArea();
		addmitArea.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		addmitArea.setEditable(false);
		JScrollPane scroll1 = new JScrollPane(addmitArea);
		scroll1.setBounds(0, 0, 449, 225);
		addmitance.add(scroll1);
		addmitArea.setText(
				"   Upon visiting the College, it can be joined by passing a test of merit which requires the casting of a spell. "
						+ "The College must be joined during \"Elder Knowledge\" in order to progress the main quest. However, this can "
						+ "be avoided if the Dragonborn travels directly to Septimus Signus' Outpost to pick up the next part of the "
						+ "quest there.\r\n\r\n   Before entering the College, the gatekeeper, Faralda, will wish to see a "
						+ "demonstration of the Dragonborn's magical powers. She requests to see a spell appropriate for the "
						+ "Dragonborn's level before gaining passage. These spells include: Firebolt, Fear,Fury,Magelight,Healing Hands,"
						+ "Conjure Flame Atronach,Conjure Familiar,Fireball.\r\n\r\n   Several of the spells require more than the starting "
						+ "100 Magicka so perks, leveling, or enchanted equipment may be necessary. Although she does not state it "
						+ "explicitly, some spells (e.g. Fear) must be cast at the emblem on the ground or she ignores it. If the spell "
						+ "she requests has not yet been learned, she offers to sell it for 30 GoldIcon. The gate beyond the bridge does"
						+ " not open until the proper spell has been demonstrated for Faralda.");
		addmitArea.setLineWrap(true);
		addmitArea.setWrapStyleWord(true);

		architecture = new JPanel();
		main.add(architecture, "name_169441239597928");
		architecture.setLayout(null);
		
		JTextArea archArea = new JTextArea();
		archArea.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		archArea.setText("   The College of Winterhold is located atop of a tall ice formation that is not connected to the city of"
				+ " Winterhold. The only way to reach the school is an ancient bridge that connects from the mainland, on the "
				+ "western end of town. \r\n   The College is centered around a square with a pool of Magicka streaming out into a "
				+ "pillar and large statue of a young Shalidor. \r\n   The main hall is called the Hall of the Elements, where many "
				+ "students practice their skills whether it is a Fireball spell or a Lesser Ward spell. Above the Hall is The "
				+ "Arcanaeum, a vast collection of books that date back to the Merethic Era and have information on the mystical "
				+ "Elder Scrolls. \r\n   The Hall of Countenance and the Hall of Attainment are where the students and teachers "
				+ "live respectively. Underneath the College is the Midden, a dungeon where many members go to perform experiments. "
				+ "\r\n   The College of Winterhold is located just north of Winterhold, on a large cliff. "
				+ "A narrow bridge in a state of disrepair connects the city to the College. The central courtyard is dominated "
				+ "by a statue of the first Arch-Mage of the College, Shalidor, who is also the supposed founder of the city; "
				+ "this is the hub of the facility, offering access back out to the bridge and into the three Halls. \r\n   "
				+ "The exterior windows offer exceptional views of the coastline. The courtyard branches off to the three halls "
				+ "of the College. The Hall of Attainment, the living quarters for mage apprentices, is off to the left upon "
				+ "entering the College, while the Hall of Countenance, the living quarters for more advanced mages, is off to the "
				+ "right. Straight ahead lies the Hall of the Elements, the lecture hall of the College. From the Hall of the "
				+ "Elements, the Arch-Mage's Quarters branches off on the left while The Arcanaeum, the College's library, "
				+ "branches off on the right. \r\n   The Midden, a prison or storage area beneath the College, houses the Atronach "
				+ "Forge, the Augur of Dunlain, and a Daedric Relic encountered in the quest \"Forgotten Names.\" Ice Wraiths, "
				+ "Draugr, and Frostbite Spiders inhabit the halls of The Midden. A tunnel here leads to the outside just outside "
				+ "of the College.");
		archArea.setEditable(false);
		archArea.setLineWrap(true);
		archArea.setWrapStyleWord(true);
		JScrollPane scroll2 = new JScrollPane(archArea);
		scroll2.setBounds(0, 0, 449, 225);
		architecture.add(scroll2);

		history = new JPanel();
		history.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 11));
		main.add(history, "name_169443973714276");
		history.setLayout(null);
		
		JTextArea historyArea = new JTextArea();
		historyArea.setText("    Papers kept in the College's library reportedly date back to the late Second Era. Serana in the Dawnguard add-on corroborates this date, recalling that the College existed when she was entombed between the Reman and Septim empires. Additionally, documents from as early as 2E 373 suggest academic collaboration between the Reman Empire and the College. However, Mirabelle Ervine states in her tour of the grounds that the College has been a \"fixture\" of Skyrim for thousands of years, its inception being credited to Arch-Mage Shalidor in the First Era.\r\n\r\nThird Era\r\n   During the Oblivion Crisis in 3E 433, the city of Winterhold was flourishing with a new renaissance of power and wealth. Several refugees from Morrowind travel to Winterhold and bring their culture into the city as well as their old mercantile spirit. Scholars from all over Tamriel went to the College of Winterhold to bring books since the Ysmir Collective was established in the College. It became the academic cornerstone in Northern Tamriel.\r\n\r\nFourth Era\r\n\r\n   In 4E 122, much of the city of Winterhold collapsed into the sea in an event known as The Great Collapse, although the College of Winterhold was left unharmed by the cataclysm. This prompted suspicion among many citizens of Winterhold, who believed that the institution may have had a hand in the collapse. Although the College denied any involvement in the event, suggesting that the College was unharmed because of \"protective magicks\" placed around it many years previously, the populace of Winterhold continued to harbor great distrust for the mages at the College.\r\n\r\n   During the Dragon Crisis in 4E 201, the Arch-Mage of the College was Savos Aren, and the Master Wizard was Mirabelle Ervine. Members of the College led by Tolfdir traveled to the ancient city of Saarthal to study the Atmoran architecture. Deep within Saarthal was a device called the Eye of Magnus, it had the ability to disperse large quantities of Magicka and was considered very powerful and dangerous. To quell the dangers it poses, an aspiring student of the College traveled to the vast ruins of the Labyrinthian to find the Staff of Magnus after an adventure in Mzulft. Ancano, an agent of the Thalmor was tampering with the Eye of Magnus and caused a magical explosion on the campus, including the ruined city of Winterhold. After dealing with the threat in the city, the student used the Staff of Magnus and weakened Ancano. They eventually defeated him and saved the college. That student was then promoted to the rank of Arch-Mage and Tolfdir was made the new Master Wizard of Winterhold.");
		historyArea.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		historyArea.setCaretColor(Color.BLACK);
		historyArea.setWrapStyleWord(true);
		historyArea.setLineWrap(true);
		historyArea.setEditable(false);
		JScrollPane scroll3 = new JScrollPane(historyArea);
		scroll3.setBounds(0, 0, 449, 225);
		history.add(scroll3);

		library = new JPanel();
		main.add(library, "name_169446049215377");
		library.setLayout(null);
		
		JTextArea libraryArea = new JTextArea();
		libraryArea.setText("   The Arcanaeum or the Ysmir Collective serves as the library for the College of Winterhold in The Elder Scrolls V: Skyrim and is overseen by Urag gro-Shub. It houses over 100 books, and hardly any of them are doubles. Books can be read, but not removed from the library.\r\n\r\n   The most current knowledge suggests that the locked bookshelves do not have a key, nor can the lock be picked. However, they can be unlocked using the console command \"unlock,\" selecting the bookcase within the command console to get the code, then typing it in. These seem to contain the same books that are already available around the library.\r\n\r\n   There is also an \"Investigators chest\" with a master lock. It contains four ornamental rings that are needed to complete a quest that involves a Daedra summoning ritual in the Midden Dark.\r\n\r\n   If the Dragonborn has the Elder Scroll, it can be given to Urag gro-Shub. Whenever it is given, there is no way the player can retrieve it again until Dawnguard.\r\n\r\n   The books inside the Arcanaeum were made after the Second Era. Most of them are old, but well-preserved, because of Urag gro-Shub. Without him, it is likely that some of the books would no longer exist. Through the centuries, many books have come and gone, but many still remain. Urag tries to keep as much knowledge available to the mages as he can and takes his job very seriously.\r\n\r\n   There are several skill books to be found within the Arcanaeum:\r\n   A Dance in Fire, Book I\r\n   A Dance in Fire, Book III\r\n   A Dance in Fire, Book IV\r\n   Mystery of Talara, Book I");
		libraryArea.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		libraryArea.setCaretColor(Color.BLACK);
		libraryArea.setWrapStyleWord(true);
		libraryArea.setLineWrap(true);
		libraryArea.setEditable(false);
		JScrollPane scroll4 = new JScrollPane(libraryArea);
		scroll4.setBounds(0, 0, 449, 225);
		library.add(scroll4);

		JLabel lblGoBackTo = new JLabel("Go back to Main");
		lblGoBackTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Welcome wel = new Welcome();
				wel.setVisible(true);
				wel.setLocationRelativeTo(null);
				wel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
				About.this.dispose();
			}
		});
		lblGoBackTo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGoBackTo.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		lblGoBackTo.setForeground(Color.BLACK);
		lblGoBackTo.setIcon(new ImageIcon(About.class.getResource("/SecondInterFace/back1.png")));
		lblGoBackTo.setBounds(449, 346, 135, 25);
		getContentPane().add(lblGoBackTo);
		this.setSize(600, 400);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width / 2) - (this.getWidth() / 2);
		int yPos = (dim.height / 2) - (this.getHeight() / 2);
		this.setLocation(xPos, yPos);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Welcome to the College of Winterhold");
		this.setResizable(false);

		this.setVisible(true);
	}
}
