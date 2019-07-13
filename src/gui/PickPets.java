package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import game.*;
import pet.*;
import pet.Wolf;

import java.awt.Choice;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.ScrollPane;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.ComponentOrientation;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

public class PickPets {

	private JFrame frame;
	private ArrayList<Player> players;
	private JTextPane petDscr;
	private int day;
	String descp="";
	private JButton buttonAdd;
	private JTextPane inputName;
	private JLabel lblPhoto;
	

	/**
	 * Launch the application.
	 */
	public void start(ArrayList<Player> players, int day) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PickPets window = new PickPets(players, day);
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
	public PickPets(ArrayList<Player> players, int day) {
		this.day = day;
//		players.add(new Player(1, "pig", 43, "Male"));
		this.players = new ArrayList<Player>();
		this.players = players;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(173, 216, 230));
//		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(PickPets.class.getResource("/com/sun/java/swing/plaf/motif/icons/DesktopIcon.gif")));
		frame.setResizable(false);
		frame.setBounds(100, 100, 549, 386);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTextPane petAttr = new JTextPane();
		petAttr.setEditable(false);
		petAttr.setBounds(229, 144, 296, 154);
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(674, 22, 17, 197);
		frame.getContentPane().setLayout(null);
		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(0, 0, 0, 0);
		frame.getContentPane().add(jsp);
		JComboBox comboBox = new JComboBox();
		comboBox.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
       		 int notches = e.getWheelRotation();
       		 if(comboBox.isEnabled()){
       			
       		 if (notches < 0 && comboBox.getSelectedIndex()!=0) {
       			
       				comboBox.setSelectedIndex(comboBox.getSelectedIndex()-1);
       			 
       			
       	       } 
       		 if(notches > 0 && comboBox.getSelectedIndex() != comboBox.getItemCount()-1){
//       	    	   System.out.println(notches);
       	    	comboBox.setSelectedIndex(comboBox.getSelectedIndex()+1);
       	       }
       		 }
       	}
		});
		comboBox.setBounds(12, 22, 196, 20);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Choose a player"}));
		frame.getContentPane().add(comboBox);
		for(Player player: players){
			comboBox.addItem(player);
		}
		JLabel lblPlayer = new JLabel("Player:");
		lblPlayer.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayer.setBounds(0, 0, 77, 17);
		lblPlayer.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 15));
		frame.getContentPane().add(lblPlayer);
		JRadioButton rdbtnDog = new JRadioButton("Dog");
		rdbtnDog.setToolTipText("WooF WooF");
		rdbtnDog.setBounds(10, 234, 109, 23);
		JRadioButton rdbtnCat = new JRadioButton("Cat");
		rdbtnCat.setToolTipText("Meow");
		rdbtnCat.setBounds(10, 260, 109, 23);
		JRadioButton rdbtnDinosaur = new JRadioButton("Dinosaur");
		rdbtnDinosaur.setToolTipText("Auwo");
		rdbtnDinosaur.setBounds(10, 286, 109, 23);
		JRadioButton rdbtnBird = new JRadioButton("Bird");
		rdbtnBird.setToolTipText("ChuChiu");
		rdbtnBird.setBounds(10, 208, 109, 23);
		
		JRadioButton rdbtnRabbit = new JRadioButton("Rabbit");
		rdbtnRabbit.setToolTipText("FuaFuaa");
		rdbtnRabbit.setBounds(10, 182, 109, 23);
		JRadioButton rdbtnWolf = new JRadioButton("Wolf");
		rdbtnWolf.setToolTipText("AuawAwua");
		rdbtnWolf.setBounds(10, 153, 109, 23);
		frame.getContentPane().add(rdbtnDog);
		
		rdbtnDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPhoto.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/Pets_small/dog.png")).getImage()));
				if(rdbtnDog.isSelected()){
					rdbtnRabbit.setSelected(false);
					rdbtnDinosaur.setSelected(false);
					rdbtnCat.setSelected(false);
					rdbtnBird.setSelected(false);
					rdbtnWolf.setSelected(false);
					int i=0;
					descp="";
					for(String str:new Dog(1, "Dog").attributes(44)){
						i++;
						if(i>2){
							descp += str+"\n";
						}
					}
					petAttr.setText(descp);
					for(String str:new Dog(1, "Dog").description()){
						descp += str;
					}
					petDscr.setText("Friendly puppies are always the best friends all around the world, our puppies are very kind and discipline, and they are concerned about your feelings. Supple paws, watery eyes and fluffy furs like soft pillows, are to ease your pressure away infinitely!");
					petDscr.setCaretPosition(0);
				}
				rdbtnDog.setSelected(true);
				if(comboBox.getSelectedIndex()!=0){
					inputName.requestFocus();
					inputName.setText("");
				}
				
				
			}
		});
		frame.getContentPane().add(rdbtnCat);
		rdbtnCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPhoto.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/Pets_small/cat.png")).getImage()));
				if(rdbtnCat.isSelected()){
					rdbtnCat.setSelected(true);
					rdbtnRabbit.setSelected(false);
					rdbtnDinosaur.setSelected(false);
					rdbtnDog.setSelected(false);
					rdbtnBird.setSelected(false);
					rdbtnWolf.setSelected(false);
					int i=0;
					descp="";
					for(String str:new Cat(1, "Cat").attributes(44)){
						i++;
						if(i>2){
							descp += str+"\n";
						}
					}
					petAttr.setText(descp);
					for(String str:new Cat(1, "Cat").description()){
						descp += str;
					}
					petDscr.setText("Have a lot of stories to share but have no one to whisper to? Well, a little kitten would be your choice! Its nature of being quiet and clean will save you a lot of time. No matter when you are in a good mood or bad mood, it will always tbe your best friend to share moments with.");
					petDscr.setCaretPosition(0);
				}
				rdbtnCat.setSelected(true);
				if(comboBox.getSelectedIndex()!=0){
					inputName.requestFocus();
					inputName.setText("");
				}
			}
		});
		frame.getContentPane().add(rdbtnDinosaur);
		rdbtnDinosaur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPhoto.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/Pets_small/dinosaur.png")).getImage()));
				if(rdbtnDinosaur.isSelected()){
					rdbtnDinosaur.setSelected(true);
					rdbtnRabbit.setSelected(false);
					rdbtnCat.setSelected(false);
					rdbtnDog.setSelected(false);
					rdbtnBird.setSelected(false);
					rdbtnWolf.setSelected(false);
					int i=0;
					descp="";
					for(String str:new Dinosaur(1, "Dinosaur").attributes(44)){
						i++;
						if(i>2){
							descp += str+"\n";
						}
					}
					petAttr.setText(descp);
					for(String str:new Dinosaur(1, "Dinosaur").description()){
						descp += str;
					}
					petDscr.setText("Are you always feeling your life lacking of excitements, strangeness and passions? With them, your life is going to be full of surprises and joys. (Don't worry they ain't gon a bite ya since they are well fed.)");
					petDscr.setCaretPosition(0);
				}
				rdbtnDinosaur.setSelected(true);
				if(comboBox.getSelectedIndex()!=0){
					inputName.requestFocus();
					inputName.setText("");
				}
			}
		});
		frame.getContentPane().add(rdbtnBird);
		rdbtnBird.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPhoto.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/Pets_small/owl.png")).getImage()));
				if(rdbtnBird.isSelected()){
					rdbtnBird.setSelected(true);
					rdbtnRabbit.setSelected(false);
					rdbtnCat.setSelected(false);
					rdbtnDog.setSelected(false);
					rdbtnDinosaur.setSelected(false);
					rdbtnWolf.setSelected(false);
					int i=0;
					descp="";
					for(String str:new Bird(1, "Owl").attributes(44)){
						i++;
						if(i>2){
							descp += str+"\n";
						}
					}
					petAttr.setText(descp);
					for(String str:new Bird(1, "Owl").description()){
						descp += str;
					}
					petDscr.setText("Heavy academic and work pressure makes your life much stressful? Do you uusually get mad by traffic jams? Birds that are capable of singing joyful songs will tremendously relieve your pressures.");
					petDscr.setCaretPosition(0);
				
				}
				rdbtnBird.setSelected(true);
				if(comboBox.getSelectedIndex()!=0){
					inputName.requestFocus();
					inputName.setText("");
				}
			}
		});

		rdbtnRabbit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPhoto.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/Pets_small/rabbit.png")).getImage()));
				if(rdbtnRabbit.isSelected()){
					rdbtnRabbit.setSelected(true);
					rdbtnBird.setSelected(false);
					rdbtnCat.setSelected(false);
					rdbtnDog.setSelected(false);
					rdbtnDinosaur.setSelected(false);
					rdbtnWolf.setSelected(false);
					int i=0;
					descp="";
					for(String str:new Rabbit(1, "Rabbit").attributes(44)){
						i++;
						if(i>2){
							descp += str+"\n";
						}
					}
					petAttr.setText(descp);
					for(String str:new Rabbit(1, "Rabbit").description()){
						descp += str;
					}
					petDscr.setText("Do you wish to raise a pet but don't want it to be too noisy? You should really take an adorable rabbit into consideration! All you need to do is give them food and a soft weedy bed, then enjoy watching them. ");
					petDscr.setCaretPosition(0);
				}
				rdbtnRabbit.setSelected(true);
				if(comboBox.getSelectedIndex()!=0){
					inputName.requestFocus();
					inputName.setText("");
				}
			}
		});
		frame.getContentPane().add(rdbtnRabbit);
		
		

		rdbtnWolf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPhoto.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/Pets_small/wolf.png")).getImage()));
				if(rdbtnWolf.isSelected()){
					rdbtnWolf.setSelected(true);
					rdbtnBird.setSelected(false);
					rdbtnCat.setSelected(false);
					rdbtnDog.setSelected(false);
					rdbtnRabbit.setSelected(false);
					rdbtnDinosaur.setSelected(false);
					int i=0;
					descp="";
					for(String str:new Wolf(1, "Wolf").attributes(44)){
						i++;
						if(i>2){
							descp += str+"\n";
						}
					}
					petAttr.setText(descp);
					for(String str:new Wolf(1, "Wolf").description()){
						descp += str;
					}
					
					petDscr.setText("Need a partner to make your life more colorful and exciting but don't want to waste too much time and money on a gigantic beast which eats a lot? A wolf would be your best choice. Their appetites are similiar to dogs but they will make your life as much exciting as dinosaurs do.");
					petDscr.setCaretPosition(0);
				}
				rdbtnWolf.setSelected(true);
				if(comboBox.getSelectedIndex()!=0){
					inputName.requestFocus();
					inputName.setText("");
				}
			}
		});
		frame.getContentPane().add(rdbtnWolf);
		
		buttonAdd = new JButton("Add");
		buttonAdd.setBounds(192, 318, 70, 22);
		frame.getContentPane().add(buttonAdd);
		
		inputName = new JTextPane();
		inputName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(comboBox.getSelectedIndex()==0){
					inputName.setFocusable(false);
					JOptionPane.showMessageDialog(frame,
						    "You need to choose a player first!",
						    "^__^\"\"\"",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		inputName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					buttonAdd.doClick();
				}
			}
		});
		
		inputName.setToolTipText("Input Pet's name.....");
		inputName.setBounds(86, 318, 94, 20);
		inputName.setText("Pet's Name");
		
		inputName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(inputName.getText().trim().equals("Pet's Name")){
					inputName.setText("");
				}else{
					
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(inputName.getText().trim().equals("")){
					inputName.setText("Pet's Name");
				}else{
					
				}
			}
		});
		frame.getContentPane().add(inputName);
		
		JLabel lblName = new JLabel("N a m e :");
		lblName.setBounds(10, 316, 77, 20);
		frame.getContentPane().add(lblName);
		frame.getContentPane().add(petAttr);
						
						lblPhoto = new JLabel("Photo");
						lblPhoto.setBounds(229, 22, 126, 111);
						frame.getContentPane().add(lblPhoto);
												petDscr = new JTextPane();
//												frame.getContentPane().add(petDscr);
												petDscr.setBackground(Color.WHITE);
												//						ScrollPane scroll = new crollPane(petDscr);
												//						scrollPane.setViewportView(txtrFghj);
												//						frame.getContentPane().add(petDscr);
																		petDscr.setEditable(false);
																		//				frame.getContentPane().add(petDscr);
																						
																								
																		//				frame.getContentPane().add(petDscr);
																								petDscr.setBounds(360, 11, 165, 122);
																								
																								JScrollPane scrollPane = new JScrollPane();
																								scrollPane.setViewportBorder(UIManager.getBorder("TextPane.border"));
																								scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
																								scrollPane.setBounds(358, 11, 167, 122);
																								
																								scrollPane.setViewportView(petDscr);
																								
//																								scrollPane.getVerticalScrollBar().setValue(0);
																								frame.getContentPane().add(scrollPane);
																								
																								Button button_1 = new Button("Start");
																								button_1.addActionListener(new ActionListener() {
																									public void actionPerformed(ActionEvent e) {
																										if(ableToStart()){
																											frame.dispose();
																											Progress progress = new Progress(players, day);
																											progress.start(players, day);
																										}
																									}
																								});
																								button_1.setBounds(455, 315, 70, 22);
																								frame.getContentPane().add(button_1);
//		frame.getContentPane().add(petDscr);
		
		Label pet1 = new Label("New label");
		pet1.setName("L");
		pet1.setBounds(10, 48, 133, 22);
		
		JButton btnDelete1 = new JButton("X");
		btnDelete1.setBounds(176, 54, 43, 23);
		
		JButton btnDelete2 = new JButton("X");
		
		btnDelete2.setBounds(176, 82, 43, 23);
		
		
		JButton btnDelete3 = new JButton("X");
		btnDelete3.setBounds(176, 115, 43, 23);
//		frame.getContentPane().add(btnDelete1);
//		frame.getContentPane().add(btnDelete2);
//		frame.getContentPane().add(btnDelete3);
		Label pet2 = new Label("New label");
		pet2.setName("L");
		pet2.setBounds(10, 81, 132, 22);

		Label pet3 = new Label("New label");
		pet3.setName("L");
		pet3.setBounds(10, 114, 132, 22);
		inputName.setEditable(false);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.repaint();
				frame.remove(pet1);frame.remove(pet2);frame.remove(pet3);
				frame.remove(btnDelete1);frame.remove(btnDelete2);frame.remove(btnDelete3);
				if(comboBox.getSelectedIndex()!=0){
					inputName.setFocusable(true);
					Player player = ((Player) comboBox.getSelectedItem());
					int i=0;
					for(Pet pet:player.getAllPets()){
						switch(i){
						case 0:
							pet1.setText(pet.getName());
							frame.getContentPane().add(pet1);
							frame.getContentPane().add(btnDelete1);break;
						case 1:
							pet2.setText(pet.getName());
							frame.getContentPane().add(pet2);
							frame.getContentPane().add(btnDelete2);break;
						case 2:
							pet3.setText(pet.getName());
							frame.getContentPane().add(pet3);
							frame.getContentPane().add(btnDelete3);break;
							
						}
						i++;
					}
					if(i<3){
						inputName.setEditable(true);
					}
					
				}else{
					inputName.setEditable(false);
				}
				
			
			}
		});
		
		btnDelete2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((Player) comboBox.getSelectedItem()).removePet(1);
				if(btnDelete3.isDisplayable()){
					pet2.setText(pet3.getText());
					inputName.setEditable(true);
					frame.remove(btnDelete3);
					frame.remove(pet3);
				}else{
					frame.remove(pet2);
					frame.remove(btnDelete2);
				}
				frame.repaint();

				
			}
		});
		btnDelete3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((Player) comboBox.getSelectedItem()).removePet(2);
				inputName.setEditable(true);
				frame.repaint();
				frame.remove(btnDelete3);
				frame.remove(pet3);
				
			}
		});
		btnDelete1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				((Player)comboBox.getSelectedItem()).removePet(((Player)comboBox.getSelectedItem()).getAllPets().get(0));;
				if(pet2.isDisplayable()){
					pet1.setText(pet2.getText());
					if(pet3.isDisplayable()){
						pet2.setText(pet3.getText());
						inputName.setEditable(true);
						frame.remove(pet3);
						frame.remove(btnDelete3);
					}else{
						pet2.setText("");
						frame.remove(pet2);
						frame.remove(btnDelete2);

					}
					
				}else{
					frame.remove(pet1);
					frame.remove(btnDelete1);
				}
				frame.repaint();
			}
		});
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(comboBox.getSelectedIndex() != 0 && inputName.getText().trim().length()>0 && ! inputName.getText().equals("Pet's Name")){

					Player player = (Player)(comboBox.getSelectedItem());
					if(((Player)comboBox.getSelectedItem()).getAllPets().size()==3){
					}else{
				
				    if(rdbtnWolf.isSelected()){
				    	player.addPet(new Wolf(player.getAllPets().size()+1, inputName.getText()));
					
				
				}
				    if(rdbtnCat.isSelected()){
				    	player.addPet(new Cat(player.getAllPets().size()+1, inputName.getText()));
				}
				    if(rdbtnDog.isSelected()){
				    	player.addPet(new Dog(player.getAllPets().size()+1, inputName.getText()));
				}
				    if(rdbtnDinosaur.isSelected()){
				    	player.addPet(new Dinosaur(player.getAllPets().size()+1, inputName.getText()));
				}
				    if(rdbtnRabbit.isSelected()){
				    	player.addPet(new Rabbit(player.getAllPets().size()+1, inputName.getText()));
				}
				   if(rdbtnBird.isSelected()){
					   player.addPet(new Bird(player.getAllPets().size()+1, inputName.getText()));
				}
					switch(player.getAllPets().size()){
					
					case 1:
						pet1.setText(player.getAllPets().get(player.getAllPets().size()-1).getSpecies() + "-> "+ player.getAllPets().get(player.getAllPets().size()-1).getName());
						frame.getContentPane().add(pet1);
						frame.getContentPane().add(btnDelete1);break;
					case 2:
						pet2.setText(player.getAllPets().get(player.getAllPets().size()-1).getSpecies() + "-> "+ player.getAllPets().get(player.getAllPets().size()-1).getName());
						frame.getContentPane().add(pet2);
						frame.getContentPane().add(btnDelete2);break;
					case 3:
						pet3.setText(player.getAllPets().get(player.getAllPets().size()-1).getSpecies() + "-> "+ player.getAllPets().get(player.getAllPets().size()-1).getName());
						frame.getContentPane().add(pet3);
						frame.getContentPane().add(btnDelete3);break;
					}
					
					frame.repaint();
					inputName.setText("Pet's Name");
					if(player.getAllPets().size()==3){
						inputName.setEditable(false);
					}
					}
				}else{
					if(comboBox.getSelectedIndex()==0){
						inputName.setFocusable(false);
						JOptionPane.showMessageDialog(frame,
							    "You need to choose a player first!",
							    "^__^\"\"\"",
							    JOptionPane.WARNING_MESSAGE);
						
					}
				}
				
			}
		});
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	public void loadPlayers(ArrayList<Player> players){
		this.players = players;
	}
	public boolean ableToStart(){
		for(Player player: players){
			if(player.getAllPets().size()==0){
				return false;
			}
		}
		return true;
	}
}
