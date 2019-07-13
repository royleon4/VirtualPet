package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;

import game.Player;
import game.VirtualPet;
import item.Corpse;
import item.Drink;
import item.Food;
import item.Item;
import item.SeaFood;
import item.Toy;
import map.BugWorld;
import map.CorpseParty;
import map.Grocery;
import map.GrowersMarket;
import map.NeWorld;
import map.SeaWorld;
import map.Store;
import map.ToyLand;
import pet.Cat;
import pet.Dog;
import pet.Pet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import java.awt.Button;
import javax.swing.JPanel;
import java.awt.Label;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Insets;
import javax.swing.JTextPane;
import javax.swing.JProgressBar;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.UIManager;
/**
 * 
 * @author lyh17
 *
 */
public class Progress extends JPanel{
	/**
	 * 
	 */

	private JFrame frame;
	private int day;
	protected ArrayList<Player> players;
	BufferedImage img;
	private JProgressBar pbExercise;
	private JLabel lblAge;
	private JProgressBar pbHappiness;
	private JLabel lblHappiness;
	private JProgressBar pbInjury;
	private JLabel lblInjury;
	private JProgressBar pbSickness;
	private JLabel lblSickness;
	private JLabel lblExercise;
	private JProgressBar pbEnergy;
	private JLabel lblEnergy;
	private JProgressBar pbHygiene;
	private JLabel lblHygiene;
	private JProgressBar pbHunger;
	private JLabel lblHunger;
	private JProgressBar pbHealth;
	private JLabel lblHealth;
	private JLabel lblPetName;
	private Pet currentPet;
	private Player currentPlayer;
	private int currentDay=1;
	private Label lblCurrentDay;
	private int numOfPets;
	private JButton button_1;
	private JButton button_2;
	private JList listFridge;
	private JList listToyBox;
	private JLabel lblPlayerName;
	private JLabel lblNewLabel;
	private JTextField msgBox;
	private JButton btnRevive;
	private Store bugWorld, corpseParty, grocery, growersMarket, neWorld, seaWorld, toyLand;
	private JButton btnBugWorld;
	private JButton btnNeWorld;
	private JButton btnGrocery;
	private JButton btnGrowersMarket;
	private JButton btnToyLand;
	private JButton btnCorpseParty;
	private JButton btnSeaWorld;
	private JLabel lblPay;
	private JButton btnProduct1;
	private JButton btnProduct2;
	private JButton btnProduct3;
	private JButton btnProduct4;
	private JButton btnProduct5;
	private JButton btnProduct7;
	private JButton btnProduct6;
	private JButton btnProduct8;
	private JButton btnProduct9;
	private JButton btnProduct10;
	private JButton btnGoBack;
	private JLayeredPane layeredPaneStores;
	private boolean isFoodStore=true;
	private Store currentStore;
	private final String SOLD = "Sold";
	private JLabel lblBalance;
	private JLabel lblSpecies;
	private JLabel lblAction;
	private JMultiLineToolTip toolTip = new JMultiLineToolTip();
	private JScrollPane toyBox;
	private JScrollPane fridge;
	private JTable table;
	private JLabel lblFeeling;
	private JLabel lblAngry;
	private JLabel lblHappy;
	private JLabel lblSad;
	private JLabel lblDead;
	private JLabel lblHungry;
	private JLabel lblTired;
	private JLabel lblSick;
	private JLabel lblFullfilled;
	private JLabel lblMisbehaving;
	private JLabel lblBackground;
	private JLabel imgPet;
	private JLabel imgItem;
	private JLabel dspItem;
	HashMap<String, ImageIcon> productImgMap;
	private JTextPane storeDescription;
	private JLabel lblCinema;
	private JLabel lblHuntingZone;
	private JLabel lblWoods;
	private JLabel lblClinic;
	private JLabel lblPark;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cat dog1 = new Cat(1, "Cat");
					Dog dog2 = new Dog(1, "Dog");
					Dog dog3 = new Dog(1, "Fat");
					Dog dog4 = new Dog(1, "Pig");
					Player player = new Player(1, "Leon", 32, "Female");
					Player player2 = new Player(2, "test2", 32, "male");
					player.addPet(dog1);
					player.addPet(dog2);
//					player.addPet(dog3);
					player2.addPet(dog3);
					player2.addPet(dog4);
					ArrayList<Player> players = new ArrayList<Player>();
					players.add(player);
					players.add(player2);
//					players.add(player2);
					Progress window = new Progress(players, 50);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * runs the core programme
	 * @param players An ArrayList that contains players (at most three, at least one)
	 * @param day days players want to play
	 */
	
	public void start(ArrayList<Player> players, int day) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Progress window = new Progress(players, day);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Progress(ArrayList<Player> players, int day) {
		this.players = players;
		this.day = day;
		currentPlayer = players.get(0);
		numOfPets = currentPlayer.getAllPets().size();
		
		currentPet = currentPlayer.getAllPets().get(0);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Virtual Pet");
//		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Progress.class.getResource("/com/sun/java/swing/plaf/motif/icons/DesktopIcon.gif")));
		frame.setBounds(100, 100, 900, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		
		JMenu mnSetting = new JMenu("Settings");
		menuBar.add(mnSetting);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mnSetting.add(mntmHelp);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Restart");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = {"Yes, please",
                "No way!"};
				int n = JOptionPane.showOptionDialog(frame,
								"Do you really want to restart?\n(You may lose your progress)",
								"Restart",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE,
								null,     //do not use a custom Icon
								options,  //the titles of buttons
								options[0]); //default button title
				//if(optionPane.get)
				}
			
		});
		mnSetting.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Save");
		mnSetting.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Load");
		mnSetting.add(mntmNewMenuItem);
		
		currentPlayer = players.get(0);
		currentPet = players.get(0).getAllPets().get(0);
		frame.getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(694, 597, 45, -617);
		separator.setBackground(new Color(240, 230, 140));
		separator.setForeground(new Color(0, 0, 0));
		separator.setOrientation(SwingConstants.VERTICAL);
		frame.getContentPane().add(separator);
		
		lblBalance = new JLabel("");
		lblBalance.setBounds(11, 549, 151, 22);
		lblBalance.setHorizontalAlignment(SwingConstants.CENTER);
		lblBalance.setForeground(new Color(255, 255, 255));
		lblBalance.setBackground(new Color(230, 230, 250));
		frame.getContentPane().add(lblBalance);
		updateBalance();
		
		lblPlayerName = new JLabel(currentPlayer.getName());
		lblPlayerName.setBounds(11, 148, 152, 31);
		lblPlayerName.setForeground(new Color(0, 0, 0));
		lblPlayerName.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(lblPlayerName);
		lblPlayerName.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));
		lblPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 171, 152, 385);
		frame.getContentPane().add(lblNewLabel);
		if(currentPlayer.getGender().equals("Male")){
			lblNewLabel.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/male.png")).getImage()));
		}else{
			
		lblNewLabel.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/female.png")).getImage()));
	}
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 8, 153, 128);
		panel.setBackground(new Color(238, 232, 170));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel labelDay = new JLabel("Day:");
		labelDay.setFont(new Font("Tahoma", Font.ITALIC, 13));
		labelDay.setBounds(10, 0, 47, 20);
		panel.add(labelDay);
		
		JLabel lblDays = new JLabel(Integer.toString(day));
		lblDays.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDays.setBounds(116, 96, 33, 20);
		panel.add(lblDays);
		
		JLabel lblSlash = new JLabel("/");
		lblSlash.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSlash.setBounds(103, 89, 25, 31);
		panel.add(lblSlash);
		
		lblCurrentDay = new Label(Integer.toString(currentDay));
		lblCurrentDay.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 59));
		lblCurrentDay.setBounds(10, 20, 87, 85);
		panel.add(lblCurrentDay);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setBounds(814, 568, 70, 22);
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listToyBox.getSelectedIndex()>=0){
					int index = listToyBox.getSelectedIndex();
					currentPlayer.playWith(currentPlayer.getToyBox().get(index), currentPet);
					updateToyBox();
					updateStats();
				}
				
			}
		});
		frame.getContentPane().add(btnPlay);
		
		JButton btnFeed = new JButton("Feed");		
		btnFeed.setBounds(814, 397, 70, 22);
		btnFeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listFridge.getSelectedIndex()>=0){
					int index = listFridge.getSelectedIndex();
					currentPlayer.feed(currentPlayer.getFridge().get(index), currentPet);
					updateFridge();
					updateStats();
				}
				
			}
		});
		frame.getContentPane().add(btnFeed);
		
		JLabel lblFridge = new JLabel("Fridge");
		lblFridge.setBounds(706, 226, 181, 22);
		lblFridge.setFont(new Font("Sitka Display", Font.PLAIN, 18));
		lblFridge.setForeground(Color.BLACK);
		lblFridge.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblFridge);
		
		JLabel lblToyBox = new JLabel("Toy Box");
		lblToyBox.setBounds(694, 431, 204, 22);
		lblToyBox.setForeground(Color.BLACK);
		lblToyBox.setFont(new Font("Sitka Display", Font.PLAIN, 18));
		lblToyBox.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblToyBox);
		
		imgPet = new JLabel("");
		imgPet.setBounds(176, 12, 240, 193);
		frame.getContentPane().add(imgPet);
//		lblNewLabel.setIcon(new ImageIcon(Progress.class.getResource("/img/bubble.png")));
		
		JButton button = new JButton("Change Player");
		button.setBounds(12, 568, 145, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n;
				Object[] options;
				if(players.size()==2){
					options = new Object[]{players.get(0).getName(),
							players.get(1).getName()};					
				
				}else{
					options = new Object[] {players.get(0).getName(),
							players.get(1).getName(),
							players.get(2).getName()};
					
					
				}
				n = JOptionPane.showOptionDialog(frame,
						"Choose one, Please.",
						"Changing player",
						JOptionPane.INFORMATION_MESSAGE,
						JOptionPane.QUESTION_MESSAGE,
						null,     //do not use a custom Icon
						options,  //the titles of buttons
						options[0]);//default button title
				if(n>=0){
					setCurrentPlayer(players.get(n));
				}
				updateToyBox();
				updateFridge();
				updateBalance();
			
			}
			
		});
		frame.getContentPane().add(button);
		if(players.size()==1){
			button.setEnabled(false);
		}
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(421, 8, 256, 267);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		lblPetName = new JLabel("");
		lblPetName.setBounds(7, 7, 199, 19);
		lblPetName.setFont(new Font("Samanata", Font.BOLD | Font.ITALIC, 15));
		panel_2.add(lblPetName);
		
		lblHealth = new JLabel("Health");
		lblHealth.setBounds(17, 71, 60, 16);
		panel_2.add(lblHealth);
		
		pbHealth = new JProgressBar();
		pbHealth.setBounds(113, 69, 135, 19);
		pbHealth.setStringPainted(true);
		panel_2.add(pbHealth);

		
		lblHunger = new JLabel("Hunger");
		lblHunger.setBounds(17, 94, 60, 16);
		panel_2.add(lblHunger);
		
		
		pbHunger = new JProgressBar();
		pbHunger.setBounds(113, 92, 135, 19);
		pbHunger.setStringPainted(true);
		panel_2.add(pbHunger);

		
		lblHygiene = new JLabel("Hygiene");
		lblHygiene.setBounds(17, 115, 60, 16);
		panel_2.add(lblHygiene);
		
		pbHygiene = new JProgressBar();
		pbHygiene.setBounds(113, 115, 135, 19);
		pbHygiene.setStringPainted(true);
		panel_2.add(pbHygiene);

		
		lblEnergy = new JLabel("Energy");
		lblEnergy.setBounds(17, 143, 60, 16);
		panel_2.add(lblEnergy);
		
		pbEnergy = new JProgressBar();
		pbEnergy.setBounds(113, 138, 135, 19);
		pbEnergy.setStringPainted(true);
		panel_2.add(pbEnergy);
		
		lblHappiness = new JLabel("Happiness");
		lblHappiness.setBounds(17, 166, 78, 16);
		panel_2.add(lblHappiness);
		
		pbHappiness = new JProgressBar();
		pbHappiness.setBounds(113, 165, 135, 19);
		pbHappiness.setStringPainted(true);
		panel_2.add(pbHappiness);
		
		
		
		lblAge = new JLabel("Age:");
		lblAge.setBounds(7, 26, 147, 16);
		panel_2.add(lblAge);
		
				
		lblExercise = new JLabel("Exercise");
		lblExercise.setBounds(17, 190, 60, 16);
		panel_2.add(lblExercise);
				
		lblSickness = new JLabel("Sickness");
		lblSickness.setBounds(17, 213, 78, 16);
		panel_2.add(lblSickness);
		
		lblInjury = new JLabel("Injury");
		lblInjury.setBounds(17, 236, 60, 16);
		panel_2.add(lblInjury);
		
		pbInjury = new JProgressBar();
		pbInjury.setBounds(113, 236, 135, 19);
		panel_2.add(pbInjury);
		pbInjury.setStringPainted(true);

		pbSickness = new JProgressBar();
		pbSickness.setBounds(113, 213, 135, 19);
		panel_2.add(pbSickness);
		pbSickness.setStringPainted(true);

		pbExercise = new JProgressBar();
		pbExercise.setBounds(113, 190, 135, 19);
		panel_2.add(pbExercise);
		pbExercise.setStringPainted(true);							
		
		btnRevive = new JButton("Revive");
		btnRevive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRevive.setBounds(121, 4, 117, 25);
		panel_2.add(btnRevive);
		if(!currentPet.isDead()){
		btnRevive.setVisible(false);}
		else{
			btnRevive.setVisible(true);
		}
		
		lblSpecies = new JLabel("Species:");
		lblSpecies.setBounds(7, 44, 147, 15);
		panel_2.add(lblSpecies);
		
		lblAction = new JLabel("New label");
		lblAction.setBounds(168, 27, 80, 30);
		panel_2.add(lblAction);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(165, 260, 518, 267);
		frame.getContentPane().add(tabbedPane);
		
		JLayeredPane layeredPaneHome = new JLayeredPane();
		tabbedPane.addTab("Home", null, layeredPaneHome, null);
		layeredPaneHome.setLayout(null);
		
		JButton btnDiscipline = new JButton("Discipline");
		btnDiscipline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPlayer.discipline(currentPet);
				updateStats();
			}
		});
		btnDiscipline.setBounds(12, 12, 115, 73);
		layeredPaneHome.add(btnDiscipline);
		btnDiscipline.setFont(new Font("Dialog", Font.BOLD, 10));
		
		JButton btnToilet = new JButton("Toilet");
		btnToilet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPet.toileting();
				updateStats();
			}
		});
		btnToilet.setBounds(139, 12, 115, 73);
		layeredPaneHome.add(btnToilet);
		
		JButton btnSleep = new JButton("Sleep");
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPet.sleep();
				updateStats();
			}
		});
		btnSleep.setBounds(266, 12, 108, 73);
		layeredPaneHome.add(btnSleep);
		
		JButton btnNextDay = new JButton("Next Day");
		btnNextDay.setBounds(386, 12, 121, 73);
		layeredPaneHome.add(btnNextDay);
		btnNextDay.setFont(new Font("Dialog", Font.BOLD, 10));
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(currentDay!=day){
				currentDay+=1;
				lblCurrentDay.setText(Integer.toString(currentDay));
				nextDay();
				}
			}
		});
		
		layeredPaneStores = new JLayeredPane();
		tabbedPane.addTab("Stores", null, layeredPaneStores, null);
		
		btnNeWorld = new JButton("NeWorld");
		btnNeWorld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayProducts(neWorld);
				storeDescription.setVisible(true);
			}
		});
		btnNeWorld.setBounds(236, 89, 104, 65);
		layeredPaneStores.add(btnNeWorld);
		
		btnGrowersMarket = new JButton("Grower's Market");
		btnGrowersMarket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayProducts(growersMarket);
				storeDescription.setVisible(true);
			}
		});
		btnGrowersMarket.setBounds(12, 174, 161, 60);
		layeredPaneStores.add(btnGrowersMarket);
		
		btnSeaWorld = new JButton("Sea World");
		btnSeaWorld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayProducts(seaWorld);
				storeDescription.setVisible(true);
			}
		});
		btnSeaWorld.setBounds(396, 12, 117, 65);
		layeredPaneStores.add(btnSeaWorld);
		
		btnGrocery = new JButton("Grocery");
		btnGrocery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayProducts(grocery);
				storeDescription.setVisible(true);
			}
		});
		btnGrocery.setBounds(185, 174, 143, 60);
		layeredPaneStores.add(btnGrocery);
		
		btnBugWorld = new JButton("Bug World");
		btnBugWorld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayProducts(bugWorld);
				storeDescription.setVisible(true);
				storeDescription.setText(bugWorld.introduction());
			}
		});
		btnBugWorld.setBounds(236, 12, 148, 65);
		layeredPaneStores.add(btnBugWorld);
		
		btnToyLand = new JButton("Toy Land");
		btnToyLand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayProducts(toyLand);
				storeDescription.setVisible(true);
			}
		});
		btnToyLand.setBounds(340, 174, 173, 60);
		layeredPaneStores.add(btnToyLand);
		
		btnCorpseParty = new JButton("Corpse Party");
		btnCorpseParty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayProducts(corpseParty);
				storeDescription.setVisible(true);
			}
		});
		btnCorpseParty.setBounds(345, 89, 168, 65);
		layeredPaneStores.add(btnCorpseParty);
		
		lblPay = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/cashier.jpg")).getImage();
		lblPay.setIcon(new ImageIcon(img));
		lblPay.setBounds(12, 10, 213, 152);
		layeredPaneStores.add(lblPay);
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("Places", null, layeredPane, null);
		
		JButton btnWoods = new JButton("");
		btnWoods.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/places/woods.jpg")).getImage()));
		btnWoods.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnWoods.setBounds(160, 12, 164, 92);
		layeredPane.add(btnWoods);
		
		JButton btnPark = new JButton("");
		btnPark.setBounds(12, 12, 137, 92);
		btnPark.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/places/Park.jpg")).getImage()));
		layeredPane.add(btnPark);
		
		JButton btnHuntingZone = new JButton("");
		btnHuntingZone.setBounds(160, 142, 347, 65);
		btnHuntingZone.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/places/huntingZone.png")).getImage()));
		layeredPane.add(btnHuntingZone);
		
		JButton btnCinema = new JButton("");
		btnCinema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCinema.setBounds(12, 142, 137, 65);
		btnCinema.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/places/cinema.jpg")).getImage()));
		layeredPane.add(btnCinema);
		
		JButton btnClinic = new JButton("");
		btnClinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClinic.setBounds(326, 12, 181, 92);
		btnClinic.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/places/hospital.jpg")).getImage()));
		layeredPane.add(btnClinic);
		
		lblCinema = new JLabel("Cinema");
		lblCinema.setHorizontalAlignment(SwingConstants.CENTER);
		lblCinema.setBounds(12, 213, 137, 15);
		layeredPane.add(lblCinema);
		
		lblHuntingZone = new JLabel("Hunting Zone");
		lblHuntingZone.setHorizontalAlignment(SwingConstants.CENTER);
		lblHuntingZone.setBounds(170, 213, 337, 15);
		layeredPane.add(lblHuntingZone);
		
		lblWoods = new JLabel("Woods");
		lblWoods.setHorizontalAlignment(SwingConstants.CENTER);
		lblWoods.setBounds(170, 116, 154, 15);
		layeredPane.add(lblWoods);
		
		lblClinic = new JLabel("Clinic");
		lblClinic.setHorizontalAlignment(SwingConstants.CENTER);
		lblClinic.setBounds(326, 116, 181, 15);
		layeredPane.add(lblClinic);
		
		lblPark = new JLabel("Park");
		lblPark.setHorizontalAlignment(SwingConstants.CENTER);
		lblPark.setBounds(12, 116, 137, 15);
		layeredPane.add(lblPark);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 10, 10);
		layeredPaneStores.add(panel_1);
		
		btnProduct1 = new JButton("");
		btnProduct1.setToolTipText("hello,\nI am Awesome\nhahaha\n");
		
		btnProduct1.setFont(new Font("DejaVu Sans", Font.PLAIN, 10));
		btnProduct1.setOpaque(false);
		btnProduct1.setHorizontalTextPosition(SwingConstants.LEFT);
		btnProduct1.setVisible(false);
		btnProduct1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = currentStore.getProducts().get(0);
				if(currentPlayer.getCash()>item.getPrice()){
					if(isFoodStore){
						currentPlayer.buysFood((Food)item);
						updateFridge();
						
					}else{
						currentPlayer.buysToy((Toy)item);
						updateToyBox();
					}
						currentStore.sold(1);
						orderProducts();
					}else{
						msgBox.setText("You don't have sufficient money!!!");
					}
				}
		});
		btnProduct1.setBounds(22, 12, 83, 62);
		layeredPaneStores.add(btnProduct1);
		
		btnProduct2 = new JButton("");
		btnProduct2.setBounds(234, 12, 83, 62);
		layeredPaneStores.add(btnProduct2);
		btnProduct2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = currentStore.getProducts().get(1);
				if(currentPlayer.getCash()>item.getPrice()){
					if(isFoodStore){
						currentPlayer.buysFood((Food)item);
						updateFridge();
						
					}else{
						currentPlayer.buysToy((Toy)item);
						updateToyBox();
					}
						currentStore.sold(2);
						orderProducts();
					}else{
						msgBox.setText("You don't have sufficient money!!!");
					}
				}
		});
		
		btnProduct3 = new JButton("");
		btnProduct3.setBounds(127, 12, 83, 62);
		layeredPaneStores.add(btnProduct3);
		btnProduct3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = currentStore.getProducts().get(2);
				if(currentPlayer.getCash()>item.getPrice()){
					if(isFoodStore){
						currentPlayer.buysFood((Food)item);
						updateFridge();
						
					}else{
						currentPlayer.buysToy((Toy)item);
						updateToyBox();
					}
						currentStore.sold(3);
						orderProducts();
					}else{
						msgBox.setText("You don't have sufficient money!!!");
					}
				}
				
		});
		
		btnProduct4 = new JButton("");
		btnProduct4.setBounds(329, 12, 83, 62);
		layeredPaneStores.add(btnProduct4);
		btnProduct4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = currentStore.getProducts().get(3);
				if(currentPlayer.getCash()>item.getPrice()){
					if(isFoodStore){
						currentPlayer.buysFood((Food)item);
						updateFridge();
						
					}else{
						currentPlayer.buysToy((Toy)item);
						updateToyBox();
					}
						currentStore.sold(4);
						orderProducts();
					}else{
						msgBox.setText("You don't have sufficient money!!!");
					}
				}
		});
		
		btnProduct5 = new JButton("");
		btnProduct5.setBounds(424, 12, 83, 62);
		layeredPaneStores.add(btnProduct5);
		btnProduct5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = currentStore.getProducts().get(4);
				if(currentPlayer.getCash()>item.getPrice()){
					if(isFoodStore){
						currentPlayer.buysFood((Food)item);
						updateFridge();
						
					}else{
						currentPlayer.buysToy((Toy)item);
						updateToyBox();
					}
						currentStore.sold(5);
						orderProducts();
					}else{
						msgBox.setText("You don't have sufficient money!!!");
					}
				}
		});
		
		btnProduct7 = new JButton("");
		btnProduct7.setBounds(22, 110, 83, 62);
		layeredPaneStores.add(btnProduct7);
		btnProduct7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = currentStore.getProducts().get(6);
				if(currentPlayer.getCash()>item.getPrice()){
					if(isFoodStore){
						currentPlayer.buysFood((Food)item);
						updateFridge();
						
					}else{
						currentPlayer.buysToy((Toy)item);
						updateToyBox();
					}
						currentStore.sold(7);
						orderProducts();
					}else{
						msgBox.setText("You don't have sufficient money!!!");
					}
				}

		});
		
		btnProduct6 = new JButton("");
		btnProduct6.setBounds(127, 110, 83, 62);
		layeredPaneStores.add(btnProduct6);
		btnProduct6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = currentStore.getProducts().get(5);
				if(currentPlayer.getCash()>item.getPrice()){
					if(isFoodStore){
						currentPlayer.buysFood((Food)item);
						updateFridge();
						
					}else{
						currentPlayer.buysToy((Toy)item);
						updateToyBox();
					}
						currentStore.sold(6);
						orderProducts();
					}else{
						msgBox.setText("You don't have sufficient money!!!");
					}
				}
		});
		
		btnProduct8 = new JButton("");
		btnProduct8.setBounds(234, 110, 83, 62);
		layeredPaneStores.add(btnProduct8);
		btnProduct8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = currentStore.getProducts().get(7);
				if(currentPlayer.getCash()>item.getPrice()){
					if(isFoodStore){
						currentPlayer.buysFood((Food)item);
						updateFridge();
						
					}else{
						currentPlayer.buysToy((Toy)item);
						updateToyBox();
					}
						currentStore.sold(8);
						orderProducts();
					}else{
						msgBox.setText("You don't have sufficient money!!!");
					}
				}
		});
		
		btnProduct9 = new JButton("");
		btnProduct9.setBounds(329, 110, 83, 62);
		layeredPaneStores.add(btnProduct9);
		btnProduct9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = currentStore.getProducts().get(8);
				if(currentPlayer.getCash()>item.getPrice()){
					if(isFoodStore){
						currentPlayer.buysFood((Food)item);
						updateFridge();
						
					}else{
						currentPlayer.buysToy((Toy)item);
						updateToyBox();
					}
						currentStore.sold(9);
						orderProducts();
					}else{
						msgBox.setText("You don't have sufficient money!!!");
					}
				}
		});
		
		btnProduct10 = new JButton("");
		btnProduct10.setBounds(424, 110, 83, 62);
		layeredPaneStores.add(btnProduct10);
		btnProduct10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = currentStore.getProducts().get(9);
				if(currentPlayer.getCash()>item.getPrice()){
					if(isFoodStore){
						currentPlayer.buysFood((Food)item);
						updateFridge();
						
					}else{
						currentPlayer.buysToy((Toy)item);
						updateToyBox();
					}
						currentStore.sold(10);
						orderProducts();
					}else{
						msgBox.setText("You don't have sufficient money!!!");
					}
				}
		});
		
		
		btnGoBack = new JButton("Go  Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayStores();
				storeDescription.setVisible(false);
				storeDescription.setText("");
			}
		});
		btnGoBack.setBounds(390, 209, 117, 25);
		layeredPaneStores.add(btnGoBack);
		
		storeDescription = new JTextPane();
		storeDescription.setBackground(UIManager.getColor("Button.shadow"));
		storeDescription.setEditable(false);
		storeDescription.setBounds(12, 175, 371, 59);
		layeredPaneStores.add(storeDescription);
		hideProducts();
		
		
		button_1 = new JButton("");
		button_1.setBounds(310, 217, 106, 31);

//		button_1.setText();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Pet pet:currentPlayer.getAllPets()){
					if(button_1.getText().equals(pet.getName())){
						currentPet = pet;
						updatePetsSeg();
						break;
					};
				}
			}
		});
		frame.getContentPane().add(button_1);
		
		button_2 = new JButton("");
		
		button_2.setBounds(165, 217, 117, 31);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(Pet pet:currentPlayer.getAllPets()){
					if(button_2.getText().equals(pet.getName())){
						currentPet = pet;
						updatePetsSeg();
						break;
					};
			}}
		});
		frame.getContentPane().add(button_2);
		
		msgBox = new JTextField();
		msgBox.setHorizontalAlignment(SwingConstants.CENTER);
		msgBox.setBounds(164, 530, 518, 61);
		msgBox.setText("....Welcome....\nHello");
		msgBox.setEditable(false);
//		frame.getContentPane().add(msgBox);
		msgBox.setColumns(10);
		
		listToyBox = new JList();
		listToyBox.setBounds(703, 359, 181, 158);
		listToyBox.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				
				if(e.getValueIsAdjusting()==false){
					if (listToyBox.getSelectedIndex()!=-1){
						
						Item chosen = currentPlayer.getToyBox().get(listToyBox.getSelectedIndex());
						String intro = "<html><p width=\"150\">"+chosen.betterIntro(10)+"</p></html>";
						imgItem.setIcon(productImgMap.get(chosen.getName()));
						dspItem.setText(intro);
					}
				}
				
			}
		});
		
		toyBox = new JScrollPane();
		toyBox.setBounds(706, 454, 180, 107);
		toyBox.setViewportView(this.listToyBox);
		frame.getContentPane().add(toyBox);
		
		fridge = new JScrollPane();
		fridge.setBounds(703, 249, 181, 136);
		frame.getContentPane().add(fridge);
		
		listFridge = new JList();
//		frame.getContentPane().add(listFridge);
		listFridge.setBounds(706, 227, 178, 133);
		listFridge.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				
				if(e.getValueIsAdjusting()==false){
					if (listFridge.getSelectedIndex()!=-1){
						
						Item chosen = currentPlayer.getFridge().get(listFridge.getSelectedIndex());
						String intro = "<html><p width=\"150\">"+chosen.betterIntro(10)+"</p></html>";
						imgItem.setIcon(productImgMap.get(chosen.getName()));
						dspItem.setText(intro);
					}
				}
				
			}
		});
		fridge.setViewportView(listFridge);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(689, -59, 15, 674);
		frame.getContentPane().add(separator_1);
		
		table = new JTable();
		table.setBounds(877, 8, -159, 160);
		frame.getContentPane().add(table);
		
		JScrollPane scrollPaneMsg = new JScrollPane();
		scrollPaneMsg.setBounds(165, 530, 518, 61);
		scrollPaneMsg.setViewportView(msgBox);
		frame.getContentPane().add(scrollPaneMsg);
		msgBox.setText("Welcome");
		
		lblFeeling = new JLabel("");
		lblFeeling.setForeground(new Color(255, 255, 255));
		lblFeeling.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 14));
		lblFeeling.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeeling.setBounds(703, 12, 181, 15);
		frame.getContentPane().add(lblFeeling);
		lblFeeling.setText("Status");
		
		lblAngry = new JLabel("Angry");
		lblAngry.setForeground(new Color(255, 0, 255));
		lblAngry.setBounds(694, 34, 56, 15);
		frame.getContentPane().add(lblAngry);
		
		lblHappy = new JLabel("HAPPY");
		lblHappy.setForeground(new Color(0, 0, 205));
		lblHappy.setBounds(747, 34, 56, 15);
		frame.getContentPane().add(lblHappy);
		
		lblSad = new JLabel("Sad");
		lblSad.setForeground(new Color(70, 130, 180));
		lblSad.setBounds(803, 34, 56, 15);
		frame.getContentPane().add(lblSad);
		
		lblDead = new JLabel("Dead");
		lblDead.setForeground(Color.RED);
		lblDead.setBounds(770, 50, 56, 15);
		frame.getContentPane().add(lblDead);
		
		lblHungry = new JLabel("Hungry");
		lblHungry.setForeground(new Color(0, 100, 0));
		lblHungry.setBounds(842, 34, 56, 15);
		frame.getContentPane().add(lblHungry);
		
		lblTired = new JLabel("Tired");
		lblTired.setForeground(new Color(128, 128, 0));
		lblTired.setBounds(717, 50, 56, 15);
		frame.getContentPane().add(lblTired);
		
		lblSick = new JLabel("Sick");
		lblSick.setForeground(new Color(220, 20, 60));
		lblSick.setBounds(828, 50, 56, 15);
		frame.getContentPane().add(lblSick);
		
		lblFullfilled = new JLabel("Fullfilled");
		lblFullfilled.setForeground(new Color(128, 0, 128));
		lblFullfilled.setBounds(702, 74, 87, 15);
		frame.getContentPane().add(lblFullfilled);
		
		lblMisbehaving = new JLabel("Misbehaving");
		lblMisbehaving.setForeground(new Color(139, 0, 0));
		lblMisbehaving.setBounds(790, 74, 121, 15);
		frame.getContentPane().add(lblMisbehaving);
		
		dspItem = new JLabel("");
		dspItem.setBounds(790, 133, 96, 84);
		frame.getContentPane().add(dspItem);
		
		imgItem = new JLabel("");
		imgItem.setBounds(706, 143, 83, 62);
		frame.getContentPane().add(imgItem);
		
		lblBackground = new JLabel("backGround");
		lblBackground.setBounds(0, 0, 1035, 639);
		frame.getContentPane().add(lblBackground);
		lblBackground.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/bg1.jpg")).getImage()));
		
		
		storeDescription.setVisible(false);
		generateProductHM();
		updateStats();
		updatePetsSeg();
		updateFridge();
		updateToyBox();
		initPlaces();
	}
	
	
	/******************************************************************************************************/
	
	/**
	 * 
	 */
	
	void initPlaces(){
		neWorld = new NeWorld();neWorld.inStock();

		seaWorld = new SeaWorld();seaWorld.inStock(10);

		bugWorld = new BugWorld();bugWorld.inStock(10);

		corpseParty = new CorpseParty();corpseParty.inStock(10);

		grocery = new Grocery();grocery.inStock(10);

		growersMarket = new GrowersMarket(); growersMarket.inStock(10);

		toyLand = new ToyLand(); toyLand.inStock(10);
	}

	/**
	 * updating the statistics of the pet that user is currently interacting with
	 * @param pet
	 */
	void updateStats(){
		lblPetName.setText(currentPet.getName());
		lblAge.setText("Age: "+Integer.toString(currentPet.getAge())+" days");
		lblAction.setText("Action: "+Integer.toString(currentPet.getActionDone())+"/2");
		lblSpecies.setText("Species: "+currentPet.getSpecies());
		pbHealth.setValue((int) currentPet.getHealth());
		pbHygiene.setValue(currentPet.getHygiene());
		pbHunger.setValue(currentPet.getHunger());
		pbHappiness.setValue(currentPet.getHappiness());
		pbEnergy.setValue( currentPet.getEnergy());
		pbSickness.setValue(currentPet.getSickness());
		pbInjury.setValue(currentPet.getInjury());
		pbExercise.setValue(currentPet.getExercise());
		

		lblAngry.setVisible(false);
		lblHappy.setVisible(false);
		lblDead.setVisible(false);
		lblSad.setVisible(false);
		lblHungry.setVisible(false);
		lblTired.setVisible(false);
		lblSick.setVisible(false);
		lblFullfilled.setVisible(false);
		lblMisbehaving.setVisible(false);
		
		
		
		if(currentPet.isDead()){
			lblDead.setVisible(true);
		}
		if(currentPet.isSick()){
			lblSick.setVisible(true);
		}
		if(currentPet.isMisbehave()){
			lblMisbehaving.setVisible(true);
		}
		if(currentPet.getHappiness()>60){
			lblHappy.setVisible(true);
		}
		if(currentPet.getHappiness() < 20 || currentPet.isNeedsToilet()){
			lblAngry.setVisible(true);
		}
		if(currentPet.getHunger()<50){
			lblHungry.setVisible(true);
		}
		if(currentPet.getEnergy()<50){
			lblTired.setVisible(true);
		}
		if(currentPet.getHappiness()<40 && currentPet.isMisbehave()){
			lblSad.setVisible(true);
		}
		
	}
	/**
	 * refresh the segment where user can choose a pet to interact with,
	 * and also refresh the statistics of the current pet once the pet's been changed.
	 */
	void updatePetsSeg(){
		int j=0;

		for(int i=0;i<numOfPets;i++){
			Pet thisPet = currentPlayer.getAllPets().get(i);
			if(! currentPet.equals(thisPet)){
				j++;
				if(j==2){
					button_2.setVisible(true);
					button_2.setText(thisPet.getName());
				}else{
					button_1.setVisible(true);
					button_1.setText(thisPet.getName());
				}
			}else{
				
			}
		}
		if(j==0){
			button_1.setVisible(false);
			button_2.setVisible(false);
		}
		if(j==1){
			button_2.setVisible(false);
		}
		switch(currentPet.getSpecies()){
		case "Cat":imgPet.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/Pets/cat.png")).getImage()));break;
		case "Bird":imgPet.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/Pets/bird.png")).getImage()));break;
		case "Dog":imgPet.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/Pets/dog.png")).getImage()));break;
		case "Wolf":imgPet.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/Pets/wolf.png")).getImage()));break;
		case "Dinosaur":imgPet.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/Pets/dinosaur.png")).getImage()));break;
		case "Rabbit":imgPet.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/Pets/rabbit.png")).getImage()));break;
			
		}

		updateStats();
	}
	/**
	 * set up the current player and update corresponding things
	 * @param player the player the user want it to be the current player
	 * 
	 */
	void setCurrentPlayer(Player player){
		currentPlayer = player;
		if(currentPlayer.getGender().equals("male")){
			lblNewLabel.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/male.png")).getImage()));
		}else{
		lblNewLabel.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/female.png")).getImage()));
	}
		lblPlayerName.setText(player.getName());
		currentPet = currentPlayer.getAllPets().get(0);
		numOfPets = currentPlayer.getAllPets().size();
		updatePetsSeg();
	}

	
	void displayStores(){
		btnBugWorld.setVisible(true);
		btnNeWorld.setVisible(true);
		btnGrocery.setVisible(true);
		btnGrowersMarket.setVisible(true);
		btnToyLand.setVisible(true);
		btnCorpseParty.setVisible(true);
		btnSeaWorld.setVisible(true);
		lblPay.setVisible(true);
		hideProducts();
		isFoodStore = true;
		currentStore = null;
	}
	
	
	
	void displayProducts(Store store){
		currentStore = store;
		if(currentStore.getName().equals("Toy Land")){isFoodStore = false;}
		btnBugWorld.setVisible(false);
		btnNeWorld.setVisible(false);
		btnGrocery.setVisible(false);
		btnGrowersMarket.setVisible(false);
		btnToyLand.setVisible(false);
		btnCorpseParty.setVisible(false);
		btnSeaWorld.setVisible(false);
		lblPay.setVisible(false);
		btnProduct10.setVisible(true);
		btnProduct9.setVisible(true);
		btnProduct8.setVisible(true);
		btnProduct7.setVisible(true);
		btnProduct6.setVisible(true);
		btnProduct5.setVisible(true);
		btnProduct4.setVisible(true);
		btnProduct3.setVisible(true);
		btnProduct2.setVisible(true);
		btnProduct1.setVisible(true);
		btnGoBack.setVisible(true);
//		String name = store.getName();
		orderProducts();
		System.out.println("is Food Store: "+ isFoodStore);
		
		
	}
	
	void orderProducts(){
		int i=0;
		for(Item item: currentStore.getProducts()){
			i++;
			String intro = "<html><p width=\"150\">"+item.betterIntro(30)+"</p></html>";
			switch(i){
			case 1: 
				btnProduct1.setEnabled(true);
				btnProduct1.setToolTipText(intro);
				btnProduct1.setIcon(productImgMap.get(item.getName()));break;
			case 2: btnProduct2.setEnabled(true);btnProduct2.setToolTipText(intro);btnProduct2.setIcon(productImgMap.get(item.getName()));break;
			case 3: btnProduct3.setEnabled(true);btnProduct3.setToolTipText(intro);btnProduct3.setIcon(productImgMap.get(item.getName()));break;
			case 4: btnProduct4.setEnabled(true);btnProduct4.setToolTipText(intro);btnProduct4.setIcon(productImgMap.get(item.getName()));break;
			case 5: btnProduct5.setEnabled(true);btnProduct5.setToolTipText(intro);btnProduct5.setIcon(productImgMap.get(item.getName()));break;
			case 6: btnProduct6.setEnabled(true);btnProduct6.setToolTipText(intro);btnProduct6.setIcon(productImgMap.get(item.getName()));break;
			case 7: btnProduct7.setEnabled(true);btnProduct7.setToolTipText(intro);btnProduct7.setIcon(productImgMap.get(item.getName()));break;
			case 8: btnProduct8.setEnabled(true);btnProduct8.setToolTipText(intro);btnProduct8.setIcon(productImgMap.get(item.getName()));break;
			case 9: btnProduct9.setEnabled(true);btnProduct9.setToolTipText(intro);btnProduct9.setIcon(productImgMap.get(item.getName()));break;
			case 10: btnProduct10.setEnabled(true);btnProduct10.setToolTipText(intro);btnProduct10.setIcon(productImgMap.get(item.getName()));break;
			default:
				break;
			}
			
		}
		while(i<10){
			i++;
			switch(i){
			case 1: btnProduct1.setEnabled(false);break;
			case 2: btnProduct2.setEnabled(false);break;
			case 3: btnProduct3.setEnabled(false);break;
			case 4: btnProduct4.setEnabled(false);break;
			case 5: btnProduct5.setEnabled(false);break;
			case 6: btnProduct6.setEnabled(false);break;
			case 7: btnProduct7.setEnabled(false);break;
			case 8: btnProduct8.setEnabled(false);break;
			case 9: btnProduct9.setEnabled(false);break;
			case 10: btnProduct10.setEnabled(false);break;
			default:
				break;
			}
		}
	}
	void hideProducts(){
		btnProduct10.setVisible(false);
		btnProduct9.setVisible(false);
		btnProduct8.setVisible(false);
		btnProduct7.setVisible(false);
		btnProduct6.setVisible(false);
		btnProduct5.setVisible(false);
		btnProduct4.setVisible(false);
		btnProduct3.setVisible(false);
		btnProduct2.setVisible(false);
		btnGoBack.setVisible(false);
		
		
	}
	
	
	void generateProductHM(){
		String fin = "";
		productImgMap = new HashMap<String, ImageIcon>();
		productImgMap.put("Butterfly", new ImageIcon(new ImageIcon(this.getClass().getResource("/butterfly.png")).getImage()));
		productImgMap.put("Earthworm", new ImageIcon(new ImageIcon(this.getClass().getResource("/worm.png")).getImage()));
		productImgMap.put("Ladybug", new ImageIcon(new ImageIcon(this.getClass().getResource("/ladybug.png")).getImage()));
		productImgMap.put("Mantis", new ImageIcon(new ImageIcon(this.getClass().getResource("/mantis.png")).getImage()));
		productImgMap.put("Mouse", new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/Rat.png")).getImage()));
		productImgMap.put("Ant", new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/ant.png")).getImage()));
		
		
		productImgMap.put("Squirrel", new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/Squirrel.png")).getImage()));
		productImgMap.put("Donkey", new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/donkey.png")).getImage()));
		
		productImgMap.put("Chicken", new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/Chicken.png")).getImage()));
		
		
		productImgMap.put("Pig", new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/Pig.png")).getImage()));
		productImgMap.put("Liver", new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/Liver.png")).getImage()));
		productImgMap.put("Spider", new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/Spider.png")).getImage()));
		
		
		
		productImgMap.put("Kangaroo", new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/Kangaroo.png")).getImage()));
		productImgMap.put("Lion", new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/lion.png")).getImage()));
		productImgMap.put("Tiger", new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/Tiger.png")).getImage()));
		
		productImgMap.put("Leopard", new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/leopard.png")).getImage()));
		productImgMap.put("Cow", new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/Cow.png")).getImage()));
		
		
		productImgMap.put("Horse", new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/Horse.png")).getImage()));
		
		
		
		productImgMap.put("Elephant", new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/Elephant.png")).getImage()));
		
		productImgMap.put("Giraffe", new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/Giraffe.png")).getImage()));
		
		productImgMap.put("Rhino", new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/rhino.png")).getImage()));

		productImgMap.put("Pterosaurus", new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/Pterosaurus.png")).getImage()));
		
		productImgMap.put("T-rex", new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/t-rex.png")).getImage()));
		
		
		productImgMap.put("Whale", new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/whale.png")).getImage()));
		productImgMap.put("SeaWeed", new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/seaweed.png")).getImage()));
		productImgMap.put("Oyster", new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/oyster.png")).getImage()));
		productImgMap.put("Fish", new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/fish.png")).getImage()));
		productImgMap.put("Clam", new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/clam.png")).getImage()));
		productImgMap.put("Mussel", new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/mussel.png")).getImage()));
		productImgMap.put("Pipi", new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/pipi.png")).getImage()));
		productImgMap.put("Shrimp", new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/shrimp.png")).getImage()));
		productImgMap.put("Tuna", new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/tuna.png")).getImage()));
		productImgMap.put("Small crab", new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/small crab.png")).getImage()));
		productImgMap.put("Black oreo", new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/black oreo.png")).getImage()));
		productImgMap.put("Salmon", new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/salmon.png")).getImage()));
		productImgMap.put("Lanternfish", new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/laternfish.png")).getImage()));
		productImgMap.put("Rock lobster", new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/rock lobster.png")).getImage()));
		
		
		productImgMap.put("Shark", new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/shark.png")).getImage()));
		
		productImgMap.put("horseshoe crab", new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/horseshoeCrab.png")).getImage()));
		productImgMap.put("Ray", new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/ray.png")).getImage()));
		
		productImgMap.put("Ball", new ImageIcon(new ImageIcon(this.getClass().getResource("/toys/ball.png")).getImage()));
		productImgMap.put("Book", new ImageIcon(new ImageIcon(this.getClass().getResource("/toys/Book.png")).getImage()));
		
		productImgMap.put("Birds' toy", new ImageIcon(new ImageIcon(this.getClass().getResource("/toys/birdtoy.png")).getImage()));
		
		productImgMap.put("Feather toy", new ImageIcon(new ImageIcon(this.getClass().getResource("/toys/Feather.png")).getImage()));
		
		productImgMap.put("Frisbee", new ImageIcon(new ImageIcon(this.getClass().getResource("/toys/Frisbee.png")).getImage()));
		
		productImgMap.put("Play Station", new ImageIcon(new ImageIcon(this.getClass().getResource("/toys/playstation.png")).getImage()));
		productImgMap.put("Rock", new ImageIcon(new ImageIcon(this.getClass().getResource("/toys/Stone.png")).getImage()));
		
		productImgMap.put("Melon", new ImageIcon(new ImageIcon(this.getClass().getResource("/fruit/melon.png")).getImage()));
		productImgMap.put("Apple", new ImageIcon(new ImageIcon(this.getClass().getResource("/fruit/apple.png")).getImage()));
		
		
		productImgMap.put("Papaya", new ImageIcon(new ImageIcon(this.getClass().getResource("/fruit/papaya.png")).getImage()));
		
		productImgMap.put("Watermelon", new ImageIcon(new ImageIcon(this.getClass().getResource("/fruit/watermelon.png")).getImage()));
		productImgMap.put("Kiwi fruit", new ImageIcon(new ImageIcon(this.getClass().getResource("/fruit/kiwi.png")).getImage()));
		
		
		productImgMap.put("Guava", new ImageIcon(new ImageIcon(this.getClass().getResource("/fruit/guava.png")).getImage()));
		productImgMap.put("Mango", new ImageIcon(new ImageIcon(this.getClass().getResource("/fruit/mango.png")).getImage()));
		productImgMap.put("Orange", new ImageIcon(new ImageIcon(this.getClass().getResource("/fruit/orange.png")).getImage()));
		productImgMap.put("Banana", new ImageIcon(new ImageIcon(this.getClass().getResource("/fruit/banana.png")).getImage()));
		
		productImgMap.put("Broccoli", new ImageIcon(new ImageIcon(this.getClass().getResource("/vege/Broccoli.png")).getImage()));
		
		productImgMap.put("Cabbage", new ImageIcon(new ImageIcon(this.getClass().getResource("/vege/Cabbage.png")).getImage()));
		productImgMap.put("Celery", new ImageIcon(new ImageIcon(this.getClass().getResource("/vege/celery.png")).getImage()));
		productImgMap.put("Lettuce", new ImageIcon(new ImageIcon(this.getClass().getResource("/vege/lettuce.png")).getImage()));
		productImgMap.put("Pea", new ImageIcon(new ImageIcon(this.getClass().getResource("/vege/Peas.png")).getImage()));
		productImgMap.put("Spinach", new ImageIcon(new ImageIcon(this.getClass().getResource("/vege/spinach.png")).getImage()));
		
		productImgMap.put("soda", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/soda.png")).getImage()));
		productImgMap.put("Ginger Beer", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/soda.png")).getImage()));
		productImgMap.put("Pepsi", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/soda.png")).getImage()));
		productImgMap.put("7Ups", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/soda.png")).getImage()));
		productImgMap.put("Lemon", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/soda.png")).getImage()));
		productImgMap.put("Sarsi", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/soda.png")).getImage()));
		productImgMap.put("Coke", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/soda.png")).getImage()));
	
		productImgMap.put("juice", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/juice.png")).getImage()));
		productImgMap.put("Lemon juice", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/juice.png")).getImage()));
		productImgMap.put("Papaya juice", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/juice.png")).getImage()));
		productImgMap.put("Apple juice", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/juice.png")).getImage()));
		productImgMap.put("Orange juice", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/juice.png")).getImage()));
		productImgMap.put("Banana juice", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/juice.png")).getImage()));
	
		productImgMap.put("Barly tea", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/tea.png")).getImage()));
		productImgMap.put("White tea", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/tea.png")).getImage()));
		productImgMap.put("Milk tea", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/tea.png")).getImage()));
		productImgMap.put("Green tea", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/tea.png")).getImage()));
		productImgMap.put("Black tea", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/tea.png")).getImage()));
		productImgMap.put("Asam milk tea", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/tea.png")).getImage()));
		productImgMap.put("Flowering tea", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/tea.png")).getImage()));
		productImgMap.put("tea", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/tea.png")).getImage()));

		productImgMap.put("coffee", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/coffee.png")).getImage()));
		productImgMap.put("Latte", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/coffee.png")).getImage()));
		productImgMap.put("Americano", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/coffee.png")).getImage()));
		productImgMap.put("Mocha", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/coffee.png")).getImage()));
		productImgMap.put("Cappucino", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/coffee.png")).getImage()));

		productImgMap.put("Egg", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/egg.png")).getImage()));
		productImgMap.put("Kit kat", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/chocolate.png")).getImage()));
		productImgMap.put("Steak", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/Steak.png")).getImage()));
		productImgMap.put("Oreo", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/chocolate.png")).getImage()));
		productImgMap.put("Mars", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/chocolate.png")).getImage()));
		productImgMap.put("Cadbury", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/chocolate.png")).getImage()));
		productImgMap.put("Toblerone", new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/chocolate.png")).getImage()));

	}
	
	
	
//	
//	void setProductimg(JButton btn, Item item){
//		String name = currentStore.getName();
//		String pname = btn.getText(); 
//		if(name.equals("Bug World")||name.equals("Ne World")){
//			switch(pname){
//			case "Butterfly":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/butterfly.png")).getImage()));break;
//			case "Earthworm":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/worm.png")).getImage()));break;
//			case "Ladybug":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/ladybug.png")).getImage()));break;
//			case "Mantis":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/mantis.png")).getImage()));break;
//			}
//			
//		}
//		if(name.equals("Corpse Party")||name.equals("Ne World")){
//			switch(item.getSize()){
//			case 2:
//				switch(pname){
//				case "Mouse":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/Rat.png")).getImage()));break;
//				case "Spider":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/Spider.png")).getImage()));break;
//				case "Ant":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/ant.png")).getImage()));break;
//				case "Squirrel":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/Squirrel.png")).getImage()));break;
//				}
//			case 3:
//				switch(pname){
//				case "Donkey":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/donkey.png")).getImage()));break;
//				case "Chicken":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/Chicken.png")).getImage()));break;
//				case "Pig":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/Pig.png")).getImage()));break;
//				case "Liver":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/Liver.png")).getImage()));break;
//				}
//			case 5:
//				switch(pname){
//				case "Kangaroo":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/Kangaroo.png")).getImage()));break;
//				case "Lion":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/lion.png")).getImage()));break;
//				case "Tiger":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/Tiger.png")).getImage()));break;
//				case "Leopard":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/leopard.png")).getImage()));break;
//				case "Cow":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/Cow.png")).getImage()));break;
//				case "Horse":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/Horse.png")).getImage()));break;
//					
//				}
//			case 7:
//				switch(pname){
//				case "Elephant":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/Elephant.png")).getImage()));break;
//				case "Giraffe":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/Giraffe.png")).getImage()));break;
//				case "Rhino":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/rhino.png")).getImage()));break;
//				case "Pterosaurus":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/Pterosaurus.png")).getImage()));break;
//					
//				}
//			case 10:
//				switch(pname){
//				case "T-rex":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/t-rex.png")).getImage()));break;
//				case "Whale":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/corpse/whale.png")).getImage()));break;
//				}
//			}
//			
//		}
//		if(name.equals("Sea World")||name.equals("Ne World")){
//			switch(item.getSize()){
//			case 2:
//				switch(pname){
//				case "SeaWeed":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/seaweed.png")).getImage()));break;
//				case "Oyster":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/oyster.png")).getImage()));break;
//				case "Fish":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/fish.png")).getImage()));break;
//				case "Clam":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/clam.png")).getImage()));break;
//				case "Mussel":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/mussel.png")).getImage()));break;
//				case "Pipi":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/pipi.png")).getImage()));break;
//				}
//			case 3:
//				switch(pname){
//				case "Shrimp":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/shrimp.png")).getImage()));break;
//				case "Tuna":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/tuna.png")).getImage()));break;
//				case "Small crab":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/small crab.png")).getImage()));break;
//				case "Salmon":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/salmon.png")).getImage()));break;
//				case "Black oreo":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/black oreo.png")).getImage()));break;
//					
//				}
//			case 5:
//				switch(pname){
//				case "Lanternfish":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/lanternfish.png")).getImage()));break;
//				case "Rock lobster":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/rock lobster.png")).getImage()));break;
//				}
//			case 7:
//				switch(pname){
//				case "Shark":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/shark.png")).getImage()));break;
//				case "horseshoe crab":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/Horseshoe crab.png")).getImage()));break;
//				case "Ray":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/seafood/ray.png")).getImage()));break;
//			};
//				}
//			}
//			
//		
//		if(name.equals("Toy Land")){
//			switch(pname){
//			case "Ball":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/toys/ball.png")).getImage()));break;
//			case "Book":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/toys/Book.png")).getImage()));break;
//			case "Birds' toy":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/toys/birdtoy.png")).getImage()));break;
//			case "Feather toy":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/toys/Feather.png")).getImage()));break;
//			case "Frisbee":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/toys/Frisbee.png")).getImage()));break;
//			case "Play Station":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/toys/playstation.png")).getImage()));break;
//			case "Rock":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/toys/Stone.png")).getImage()));break;
//				
//			}
//			
//		}
//		if(name.equals("Growers Market")||name.equals("Ne World")){
//			switch(pname){
//			case "Melon":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/fruit/melon.png")).getImage()));break;
//			case "Apple":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/fruit/apple.png")).getImage()));break;
//			case "Papaya":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/fruit/papaya.png")).getImage()));break;
//			case "Watermelon":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/fruit/watermelon.png")).getImage()));break;
//			case "Banana":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/fruit/banana.png")).getImage()));break;
//			case "Kiwi fruit":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/fruit/kiwi.png")).getImage()));break;
//			case "Guava":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/fruit/guava.png")).getImage()));break;
//			case "Mango":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/fruit/mango.png")).getImage()));break;
//			case "Orange":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/fruit/orange.png")).getImage()));break;
//			case "Broccoli":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/vege/Broccoli.png")).getImage()));break;
//			case "Cabbage":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/vege/Cabbage.png")).getImage()));break;
//			case "Celery":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/vege/celery.png")).getImage()));break;
//			case "Lettuce":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/vege/lettuce.png")).getImage()));break;
//			case "Pea":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/vege/Peas.png")).getImage()));break;
//			case "Spinach":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/vege/spinach.png")).getImage()));break;
//				
//			}
//		}
//		if(name.equals("Grocery")||name.equals("Ne World")){
//				switch(((Food) item).getType()){
//				case "soda":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/soda.png")).getImage()));break;
//				case "juice":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/juice.png")).getImage()));break;
//				case "tea":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/tea.png")).getImage()));break;
//				case "coffee":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/coffee.png")).getImage()));break;
//				case "Egg":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/egg.png")).getImage()));break;
//				case "Chocolate":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/chocolate.png")).getImage()));break;
//				case "Steak":btn.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/grocery/Steak.png")).getImage()));break;
//
//			}
//			
//		}
//		btn.setText("");
//	}
//	
	void updateStocks(int qty){
		neWorld.inStock();

		seaWorld.inStock(qty);

		bugWorld.inStock(qty);

		corpseParty.inStock(qty);

		grocery.inStock(qty);

		growersMarket.inStock(qty);

		toyLand.inStock(qty);
		
	}
	
	/**
	 * 
	 */
	
	void updateFridge(){
		int num = currentPlayer.getFridge().size();
		DefaultListModel listModel = new DefaultListModel();
		for(int i=0;i<num;i++){
			String food = "";
			food = String.format("%s%s", currentPlayer.getFridge().get(i).getName(),currentPlayer.getFoodqty().get(i)!=1?" ("+currentPlayer.getFoodqty().get(i)+")":"");
			listModel.addElement(food);
			
		}
//		listModel.addElement("");
		listFridge.setModel(listModel);
		updateBalance();
		
	}
	/**
	 * 
	 */
	void updateToyBox(){
		int num = currentPlayer.getToyBox().size();
		DefaultListModel listModel = new DefaultListModel();
		for(int i=0;i<num;i++){
			String toy = "";
			toy = String.format("%s%s", currentPlayer.getToyBox().get(i).getName(),currentPlayer.getToyqty().get(i)!=1?" ("+currentPlayer.getToyqty().get(i)+")":"");
			listModel.addElement(toy);
			
		}
//		listModel.addElement("");
		listToyBox.setModel(listModel);
//		listToyBox.setToolTipText("????????");
		updateBalance();
	}
	/**
	 * 
	 */
	void updateBalance(){
		lblBalance.setText("$ "+Integer.toString(currentPlayer.getCash()));
	}
	
	/**
	 * In order to go to next day, there are varieties to be setup.
	 */
	void nextDay(){
		for(Player p: players){
			p.earn(20);
			for(Pet pet: p.getAllPets()){
				pet.aDayPassed();
			}
		}
		updateStats();
		
	}
}
